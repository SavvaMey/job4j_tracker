package ru.job4j.tracker.singlton;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSinglThirdTest {

    @Test
    public void getInstance() {
        TrackerSinglThird s = TrackerSinglThird.getInstance();
        TrackerSinglThird sNew = TrackerSinglThird.getInstance();
        assertSame(s, sNew);
    }
}