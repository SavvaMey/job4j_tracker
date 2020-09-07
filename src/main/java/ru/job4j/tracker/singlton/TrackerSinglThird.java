package ru.job4j.tracker.singlton;

import ru.job4j.tracker.Tracker;

public class TrackerSinglThird {

    private TrackerSinglThird() {
    }

    private Tracker tracker = new Tracker();

    public static TrackerSinglThird getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSinglThird INSTANCE = new TrackerSinglThird();
    }

}
