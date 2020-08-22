package ru.job4j.tracker;

public class TrackerSingle {
    private static TrackerSingle instance;
    public static int counter = 0;

    Tracker tracker = new Tracker();

    private TrackerSingle() {
        counter++;
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}
