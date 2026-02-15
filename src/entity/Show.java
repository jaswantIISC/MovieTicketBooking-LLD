package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import strategy.pricing.PriceStrategy;

public class Show {

    private final String id;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Movie movie;
    private final Theatre theatre;
    private final Screen screen;
    private final PriceStrategy priceStrategy;
    
    public Show(String id, LocalDateTime startTime, LocalDateTime endTime, Movie movie, Theatre theatre,
            Screen screen, PriceStrategy priceStrategy) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.priceStrategy = priceStrategy;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public List<Seat> getSeats() {
        return new ArrayList<>(screen.getSeats().values()) ;
    }

    @Override
    public String toString() {
        return "Show [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", movie=" + movie.getTitle()
                + ", theatre=" + theatre.getName() + ", screen=" + screen.getName() + "]";
    }
    
}
