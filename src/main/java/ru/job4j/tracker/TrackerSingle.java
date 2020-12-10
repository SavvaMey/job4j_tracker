package ru.job4j.tracker;

public class TrackerSingle {
    private static int counter = 0;
    private static TrackerSingle instance;
    private MemTracker tracker = new MemTracker();

    private TrackerSingle() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public MemTracker getTracker() {
        return tracker;
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

}
