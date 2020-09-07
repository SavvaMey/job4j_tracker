package ru.job4j.tracker;

public class TrackerSingle {
    private static int counter = 0;
    private static TrackerSingle instance;
    private Tracker tracker = new Tracker();

    private TrackerSingle() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

}
