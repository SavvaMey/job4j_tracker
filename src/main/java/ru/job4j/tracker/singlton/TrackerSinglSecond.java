package ru.job4j.tracker.singlton;

import ru.job4j.tracker.MemTracker;

public class TrackerSinglSecond {
    private static final TrackerSinglSecond INSTANCE = new TrackerSinglSecond();

    private MemTracker tracker = new MemTracker();

    private TrackerSinglSecond() {
    }

    public static TrackerSinglSecond getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSinglSecond tracker = TrackerSinglSecond.getInstance();
    }
}
