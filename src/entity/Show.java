package entity;

import java.time.LocalDateTime;

public class Show {

    private final String id;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Movie movie;
    private final Theatre theatre;
    private final Screen screen;
    
    public Show(String id, LocalDateTime startTime, LocalDateTime endTime, Movie movie, Theatre theatre,
            Screen screen) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
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

}
