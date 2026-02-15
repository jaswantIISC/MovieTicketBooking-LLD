package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Booking;
import entity.Show;
import strategy.lockMethods.LockManager;


public class BookingService {

    private static final long TTL = 5000L; // value is set for demo purpose
    private final Map<String, Booking> bookingMap = new HashMap<>();
    private final LockManager lockManager;

    public Booking reserveBooking(String userId, Show show, List<String> seatIds) {
        
        for( String seatId :  seatIds) {
            String lockKey = show.getId()+ ":" + seatId;
            if(!lockManager.lockSeat(lockKey, userId, TTL)) {
                throw new IllegalStateException("Seat "+ seatId + " is not available. May be locked by other user");
            }
        }
    }

    public void confirmBooking() {

    }
}
