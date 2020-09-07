package ru.job4j.tracker.singlton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSinglFourthTest {

    @Test
    public void values() {
        TrackerSinglFourth tracker = TrackerSinglFourth.INSTANCE;
        TrackerSinglFourth trackerNew = TrackerSinglFourth.INSTANCE;
        assertSame(tracker, trackerNew);
    }
}