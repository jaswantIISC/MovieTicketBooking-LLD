package strategy.pricing;

import java.util.List;

import entity.Seat;

public interface PriceStrategy {

    public double calculatePrice(List<Seat> seats);
} 