package ru.job4j.tracker.Singlton;

import org.junit.Test;
import ru.job4j.tracker.TrackerSingle;

import static org.junit.Assert.*;

public class TrackerSinglSecondTest {


    @Test
    public void getInstance() {
       TrackerSinglSecond s = TrackerSinglSecond.getInstance();
        TrackerSinglSecond s_new = TrackerSinglSecond.getInstance();
        assertSame( s , s_new);
    }
}