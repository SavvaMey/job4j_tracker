package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void getTestInstance() {
        TrackerSingle[] arr = new TrackerSingle[100];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = TrackerSingle.getInstance();
        }
        assertThat( TrackerSingle.counter , is(1));
    }
}