package ru.job4j.tracker.Singlton;

import org.junit.Test;
import ru.job4j.tracker.TrackerSingle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {

    @Test
    public void getInstance() {
        TrackerSingle  s = TrackerSingle.getInstance();
        TrackerSingle  sNew = TrackerSingle.getInstance();

        assertSame(s , sNew);
    }
}