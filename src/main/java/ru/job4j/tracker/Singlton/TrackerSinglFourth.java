package ru.job4j.tracker.Singlton;

import ru.job4j.tracker.Tracker;

public enum TrackerSinglFourth {
    INSTANCE;
     private Tracker tracker = new Tracker();

     public Tracker GetTracker() {
         return tracker;
     }
}
