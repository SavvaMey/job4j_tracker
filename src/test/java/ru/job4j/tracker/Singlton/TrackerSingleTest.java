package ru.job4j.tracker.Singlton;

import org.junit.Test;
import ru.job4j.tracker.TrackerSingle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {

    @Test
    public void getInstance() {
//        ru.job4j.tracker.TrackerSingle[] arr = new ru.job4j.tracker.TrackerSingle[100];
        TrackerSingle  s = TrackerSingle.getInstance();
        TrackerSingle  s_new = TrackerSingle.getInstance();
//        int count = 1;
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ru.job4j.tracker.TrackerSingle.getInstance();
//        }
        assertSame( s , s_new);
    }
}