package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddThenReturn() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = hbmTracker.add(new Item("dayOff"));
        assertEquals(item.getName(), "dayOff");
    }

    @Test
    public void whenReplace() {
        HbmTracker hbmTracker = new HbmTracker();
        Item itemNew = new Item("dayOn");
        Item item = hbmTracker.add(new Item("dayOff"));
        hbmTracker.replace(1, itemNew);
        assertEquals(hbmTracker.findById(1).getName(), "dayOn");
    }

    @Test
    public void whenDelete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = hbmTracker.add(new Item("dayOff"));
        hbmTracker.delete(1);
        assertEquals(hbmTracker.findAll().size(), 0);
    }

    @Test
    public void whenfindAll() {
        HbmTracker hbmTracker = new HbmTracker();
        Item itemOne = new Item("dayOff");
        Item itemTwo = new Item("dayOn");
        hbmTracker.add(itemOne);
        hbmTracker.add(itemTwo);
        assertEquals(List.of(itemOne, itemTwo), hbmTracker.findAll());
    }


    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item itemOne = new Item("dayOff");
        Item itemTwo = new Item("dayOn");
        hbmTracker.add(itemOne);
        hbmTracker.add(itemTwo);
        Item newItem = (Item) hbmTracker.findByName("dayOff").get(0);
        assertEquals(itemOne, newItem);
    }

    @Test
    public void whenFindById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item itemOne = new Item("dayOff");
        Item itemTwo = new Item("dayOn");
        hbmTracker.add(itemOne);
        hbmTracker.add(itemTwo);
        Item newItem = hbmTracker.findById(2);
        assertEquals(itemTwo, newItem);
    }

}