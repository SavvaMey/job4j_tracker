package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements  UserAction {

    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Output all items ====");
        List<Item> items = tracker.findAll();
                for (Item item : items) {
                    out.println("id: " + item.getId() + " name: " + item.getName());
                }
        return true;
    }
}
