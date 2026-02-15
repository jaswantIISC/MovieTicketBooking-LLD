package service;

import java.util.HashMap;
import java.util.Map;

import entity.Screen;
import entity.Seat;
import entity.Theatre;

public class TheatreService {
    private ScreenService screenService;
    private SeatService seatService;
    private final Map<String, Theatre> theatreMap = new HashMap<>();

    public TheatreService(ScreenService screenService, SeatService seatService) {
        this.screenService = screenService;
        this.seatService = seatService;
    }

    public Theatre createTheatre(String id, String name, String city) {
        Theatre theatre = new Theatre(id, name, city);
        saveTheatre(theatre);
        return theatre;
    }

    // adding theatre
    public void saveTheatre(Theatre theatre) {
        theatreMap.put(theatre.getId(), theatre);
    }
    
    // getting a theatre
    public void getTheatre(Theatre theatre) {
        theatreMap.get(theatre.getId());
    }

    // adding a Screen to a theatre
    public void addScreen(String threatreId, Screen screen) {
        screenService.saveScreen(screen);
        theatreMap.get(threatreId).addScreen(screen);
       // System.out.println("TEST: screen added to given theatre in theatreMap"+ theatreMap.get(threatreId).toString());
    }

    //getting a screen
    public Screen getScreen(String screenId) {
        return screenService.getScreen(screenId);
    }

    //adding a seat to a screen of a theatre
    public void addSeat(String theatreId, String screenId, Seat seat) {
        seatService.saveSeat(seat);
        screenService.getScreen(screenId).addSeat(seat);
        theatreMap.get(theatreId).getScreen(screenId).addSeat(seat);
    }

 
}
