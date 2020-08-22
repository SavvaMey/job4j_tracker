package ru.job4j.tracker.Singlton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle {
    private static TrackerSingle instance;

    //public static int counter = 0;

    Tracker tracker = new Tracker();

    private TrackerSingle() {
        //counter++;
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

}
