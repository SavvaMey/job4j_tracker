package ru.job4j.tracker.Singlton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSinglFourthTest {

    @Test
    public void values() {
        TrackerSinglFourth tracker = TrackerSinglFourth.INSTANCE;
        TrackerSinglFourth tracker_new = TrackerSinglFourth.INSTANCE;
        assertSame(tracker, tracker_new);
    }
}