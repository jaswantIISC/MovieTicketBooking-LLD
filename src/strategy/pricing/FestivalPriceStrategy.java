package strategy.pricing;

import java.util.List;

import entity.Seat;

public class FestivalPriceStrategy implements PriceStrategy{

    @Override
    public double calculatePrice(List<Seat> seats) {
        double surcharge = 2.2;
        double fee = 10.0;
        double total =0.0;
        for(Seat seat : seats){
            total += seat.getPrice();
        }
        return total*surcharge + fee;
    }

}
