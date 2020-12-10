package ru.job4j.tracker.singlton;

import ru.job4j.tracker.MemTracker;

public enum TrackerSinglFourth {
    INSTANCE;
     private MemTracker tracker = new MemTracker();

     public MemTracker getTracker() {
         return tracker;
     }
}
