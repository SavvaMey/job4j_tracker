package ru.job4j.tracker;

public class TrackerSingle {
    private static TrackerSingle instance;
    public static int counter = 0;
    private Tracker tracker = new Tracker();
    public Tracker getTracker() {
        return tracker;
    }
    private TrackerSingle() {
        counter++;
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

}
