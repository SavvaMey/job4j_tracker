package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find by name ====");
        String name = input.askStr("Enter the new name of application:");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println("id: " + item.getId() + " name: " + item.getName());
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
