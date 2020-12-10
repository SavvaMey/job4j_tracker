package ru.job4j.tracker.singlton;

import ru.job4j.tracker.MemTracker;

public class TrackerSinglThird {
    private MemTracker tracker = new MemTracker();

    private TrackerSinglThird() {
    }

    public MemTracker getTracker() {
        return tracker;
    }

    public static TrackerSinglThird getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSinglThird INSTANCE = new TrackerSinglThird();
    }

}
