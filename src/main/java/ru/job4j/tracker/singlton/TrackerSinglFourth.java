package ru.job4j.tracker.singlton;

import ru.job4j.tracker.Tracker;

public enum TrackerSinglFourth {
    INSTANCE;
     private Tracker tracker = new Tracker();

     public Tracker getTracker() {
         return tracker;
     }
}
