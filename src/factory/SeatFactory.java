package factory;

import entity.PremiumSeat;
import entity.RegularSeat;
import entity.Seat;
import enums.SeatType;

public class SeatFactory {

    public static Seat getInstance(SeatType type, String row, int num, double price){
        return switch (type) {
            case REGULAR -> new RegularSeat(row, num, price);
            case PREMIUM -> new PremiumSeat(row, num, price);
        };
    }
}
