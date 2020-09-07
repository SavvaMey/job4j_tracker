package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void SortTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Vol", 19));
        items.add(new Item("Val", 6));
        items.add(new Item("Vil", 24));
        Collections.sort(items, new SortById());
        List<Item> itemsAnother = new ArrayList<>();
        itemsAnother.add(new Item("Vol", 19));
        itemsAnother.add(new Item("Val", 24));
        itemsAnother.add(new Item("Vil", 6));
        Collections.sort(itemsAnother, new BackwardsSortById());
        assertThat(items.get(1).getId(), is(itemsAnother.get(1).getId()));
    }

    @Test
    public void SortTestDecrease() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Vol", 19));
        items.add(new Item("Val", 6));
        items.add(new Item("Vil", 24));
        Collections.sort(items, new BackwardsSortById());
        assertThat(items.get(0).getId(), is(24));
    }

    @Test
    public void SortTestIncreaseName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Kol", 19));
        items.add(new Item("Aml", 6));
        items.add(new Item("Uil", 24));
        Collections.sort(items, new SortByname());
        System.out.println(items);
        assertThat(items.get(0).getId(), is(6));
    }

    @Test
    public void SortTestDecreaseName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Kol", 19));
        items.add(new Item("Aml", 6));
        items.add(new Item("Uil", 24));
        Collections.sort(items, new BackwardsSortById());
        System.out.println(items);
        assertThat(items.get(0).getId(), is(24));
    }
}