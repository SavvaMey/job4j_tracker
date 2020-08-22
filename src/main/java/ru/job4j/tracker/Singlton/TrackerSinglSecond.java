package ru.job4j.tracker.Singlton;

import ru.job4j.tracker.Tracker;

public class TrackerSinglSecond {
    private static final TrackerSinglSecond INSTANCE = new TrackerSinglSecond();

    Tracker tracker = new Tracker();

    private TrackerSinglSecond() {
    }

    public static TrackerSinglSecond getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        TrackerSinglSecond tracker = TrackerSinglSecond.getInstance();
    }
}
