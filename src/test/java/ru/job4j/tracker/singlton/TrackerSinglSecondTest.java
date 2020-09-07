package ru.job4j.tracker.singlton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSinglSecondTest {
    @Test
    public void getInstance() {
       TrackerSinglSecond s = TrackerSinglSecond.getInstance();
        TrackerSinglSecond sNew = TrackerSinglSecond.getInstance();
        assertSame(s, sNew);
    }
}