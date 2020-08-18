package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("task");
        Item item1 = new Item("task");
        Item item2 = new Item("task1");
        System.out.println(item);
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        System.out.println(tracker);
        System.out.println();
        System.out.println(tracker.findById(1));
        System.out.println();
        System.out.println(Arrays.toString(tracker.findByName("task")));


    }
}
