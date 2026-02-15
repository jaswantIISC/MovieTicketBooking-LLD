package entity;

import enums.SeatType;
public class PremiumSeat extends Seat {
    private final double price;

    public PremiumSeat(String row, int number, double price) {
        super(row, number);
        this.price = price;
    }

    @Override
    public SeatType getType() {
        return SeatType.PREMIUM;
    }

    public double getPrice() {
        return price;
    }

}


