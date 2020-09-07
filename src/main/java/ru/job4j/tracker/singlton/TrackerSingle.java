package ru.job4j.tracker.singlton;

import ru.job4j.tracker.Tracker;

public class TrackerSingle {
    private static TrackerSingle instance;

    //public static int counter = 0;

    private Tracker tracker = new Tracker();

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
