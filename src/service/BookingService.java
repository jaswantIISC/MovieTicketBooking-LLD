package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import entity.Booking;
import entity.Seat;
import entity.Show;
import enums.BookingStatus;
import enums.PaymentStatus;
import strategy.lockMethods.LockManager;
import strategy.paymentMethods.PaymentStrategy;


public class BookingService {

    private static final long TTL = 5000L; // value is set for demo purpose
    private final Map<String, Booking> bookingMap ;
    private final LockManager lockManager ;

    public BookingService(LockManager lockManager) {
        this.lockManager = lockManager;
        this.bookingMap = new HashMap<>();
    }

    public Booking reserveBooking(String userId, Show show, Set<String> seatIds) {
        
        for( String seatId :  seatIds) {
            String lockKey = show.getId()+ ":" + seatId;
            if(!lockManager.lockSeat(lockKey, userId, TTL)) {
                throw new IllegalStateException("Seat "+ seatId + " is not available. May be locked by other user");
            }
        }

        // 2. Calculate the total price
        List<Seat> bookingSeats = show.getSeats()
                                .stream()
                                .filter(seat -> seatIds.contains(seat.getId()))
                                .collect(Collectors.toList());
        double totalAmount = show.getPriceStrategy().calculatePrice(bookingSeats);

        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, userId, show.getId(), new ArrayList<>(seatIds), BookingStatus.CREATED, totalAmount);
        saveBooking(booking);
        return booking;
    }

    public void saveBooking(Booking booking) {
        bookingMap.put(booking.getId(), booking);
    }

    public void confirmBooking(Booking booking, PaymentStrategy paymentStrategy) {
       //validate the seat status
        if(booking.getStatus() != BookingStatus.CREATED) {
            System.out.println("Invalid booking state..");
        }

        // validate if lock still valid
        for(String seatId : booking.getSeatIds()) {
            String lockKey = booking.getShowId()+":"+seatId;
            if(lockManager.isLockExpired(lockKey) || !lockManager.isLockedBy(lockKey, booking.getUserId())) {
                System.out.println("Seat is "+ seatId+ " is not available now. Please Try to book other seats");
            }
        }

        // change booking status to PENDING now
        booking.setStatus(BookingStatus.PENDING);

        //create and process payment
        PaymentStatus paymentStatus = paymentStrategy.processPayment(booking.getAmount());

        // Release the lock for all seats and update booking status as CONFIRMED if payment success
        if(paymentStatus == PaymentStatus.SUCCESS){
            booking.setStatus(BookingStatus.CONFIRMED);
            System.out.println("Booking is CONFIRMED for the seats - "+ booking.getSeatIds());
        }else{
            booking.setStatus(BookingStatus.CANCELLED);
            System.out.println("Payment is FAILED due to invalid card entered");
            System.out.println("Booking is CANCELLED");
        }
        
        for(String seatId : booking.getSeatIds()) {
            String lockKey = booking.getShowId() + ":"+ seatId;
            lockManager.unLockSeats(lockKey);
        }
        saveBooking(booking);
        
    }
}
