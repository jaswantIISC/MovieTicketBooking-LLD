package entity;

import java.util.List;

import enums.BookingStatus;

public class Booking {

    private final String id;
    private final String userId;
    private final String showId;
    private final List<String> seatIds;
    private  BookingStatus status;
    private final double amount;

    public Booking(String id, String userId, String showId, List<String> seatIds, BookingStatus status, double amount) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seatIds = seatIds;
        this.status = status;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public List<String> getSeatIds() {
        return seatIds;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    
    
}
