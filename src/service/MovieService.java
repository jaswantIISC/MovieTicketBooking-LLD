package service;

import java.util.HashMap;
import java.util.Map;

import entity.Movie;


public class MovieService {
    
    Map<String, Movie> movieMap = new HashMap<>();

    public Movie createMovie(String id, String title, int durationInMinutes, String lang, String genre) {
        Movie movie = new Movie(id, title, durationInMinutes, lang, genre);
        saveMovie(movie);
        return movie;
    }
    public void saveMovie(Movie movie) {
        movieMap.put(movie.getId(), movie);
    }
    
    public Movie getMovie(String movieId) {
        return movieMap.get(movieId);
    }

}
