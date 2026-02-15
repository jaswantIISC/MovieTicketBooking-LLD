package service;

import java.util.HashMap;
import java.util.Map;
import entity.Seat;
import enums.SeatType;
import factory.SeatFactory;

public class SeatService {

    Map<String, Seat> seatMap = new HashMap<>();

      public Seat createSeat(String row, int num, double price, SeatType seatType) {
        Seat seat = SeatFactory.getInstance(seatType, row, num, price);
        saveSeat(seat);
        return seat;
    }

    public void saveSeat(Seat seat) {
        seatMap.put(seat.getId(), seat);
    }

    public Seat getSeat(String seatId) {
        return seatMap.get(seatId);
    }
}
