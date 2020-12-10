package ru.job4j.tracker.singlton;

import ru.job4j.tracker.MemTracker;

public class TrackerSingle {
    private static TrackerSingle instance;

    //public static int counter = 0;

    private MemTracker tracker = new MemTracker();

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
