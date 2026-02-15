package service;

import java.util.HashMap;
import java.util.Map;

import entity.Screen;

public class ScreenService {
    Map<String, Screen> screenMap = new HashMap<>();

    public Screen createScreen(String id, String name) {
        Screen screen = new Screen(id, name);
        addScreen(screen);
        return screen;
    }

    public void addScreen(Screen screen) {
        screenMap.put(screen.getId(), screen);
    }
    
    public Screen getScreen(String screenId) {
        return screenMap.get(screenId);
    }

}
