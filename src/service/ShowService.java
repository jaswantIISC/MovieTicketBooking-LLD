package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import entity.Movie;
import entity.Screen;
import entity.Show;
import entity.Theatre;
import strategy.pricing.PriceStrategy;

public class ShowService {
    private final Map<String, Show> showMap = new HashMap<>();

    public Show createShow(String id, LocalDateTime startTime, LocalDateTime endTime, Movie movie, Theatre theatre,
            Screen screen, PriceStrategy priceStrategy) {

        Show show = new Show(id, startTime, endTime, movie, theatre, screen, priceStrategy);
        showMap.put(show.getId(), show);
        return show;
    }

    public Show getShow(String showId) {
        return showMap.get(showId);
    }

    public List<Show> findAllShowsForMovie(String MovieTitle, String city) {
        List<Show> shows = showMap.values()
                .stream()
                .filter(show -> show.getMovie().getTitle().equalsIgnoreCase(MovieTitle)
                        && show.getTheatre().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return shows;
    }

}
