package ru.job4j.tracker.Singlton;

import ru.job4j.tracker.Tracker;

public enum TrackerSinglFourth {
    INSTANCE;
    Tracker tracker = new Tracker();
}
