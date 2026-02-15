package entity;

public class Movie {

    private final  String id;
    private final String title;
    private final int durationInMinutes;
    private final String language;
    private final String genre;

  

    public Movie(String id, String title, int durationInMinutes, String language, String genre) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.language = language;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }
   
    public String getTitle() {
        return title;
    }
  
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }
    
}
