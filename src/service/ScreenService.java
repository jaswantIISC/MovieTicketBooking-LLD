package service;

import java.util.HashMap;
import java.util.Map;

import entity.Screen;

public class ScreenService {
    private final Map<String, Screen> screenMap = new HashMap<>();
    

    public ScreenService() {
    }

    public Screen createScreen(String id, String name) {
        Screen screen = new Screen(id, name);
        saveScreen(screen);
        return screen;
    }

    public void saveScreen(Screen screen) {
        screenMap.put(screen.getId(), screen);
    }
    
    public Screen getScreen(String screenId) {
        return screenMap.get(screenId);
    }

}
