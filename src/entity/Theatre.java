package entity;

import java.util.HashMap;
import java.util.Map;

public class Theatre {

    private final String id;
    private final String name;
    private final String city;
    private final Map<String, Screen> screens;

    public Theatre(String id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
        this.screens = new HashMap<>();
    }

    public void addScreen(Screen screen) {
        this.screens.put(screen.getId(), screen);
    }

    public Screen getScreen(String screenId) {
        return this.screens.get(screenId);
    }

    public String getId() {
        return id;
    }
  
    public String getName() {
        return name;
    }
  
    public String getCity() {
        return city;
    }
   
  

    @Override
    public String toString() {
        return "Theatre [id=" + id + ", name=" + name + ", city=" + city + ", screens=" + screens + "]";
    }

    public Map<String, Screen> getScreens() {
        return screens;
    }

}
