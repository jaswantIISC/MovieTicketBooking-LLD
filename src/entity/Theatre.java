package entity;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String id;
    private String name;
    private String city;
    private List<Screen> screens;

    public Theatre(String id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public List<Screen> getScreens() {
        return screens;
    }
    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

}
