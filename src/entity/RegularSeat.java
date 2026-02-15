package entity;

import enums.SeatType;

public class RegularSeat extends Seat{
    private final double price;

    public RegularSeat(String row, int num, double price) {
        super(row, num);
        this.price = price;
    }

    @Override
    public SeatType getType() {
        return SeatType.REGULAR;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}
