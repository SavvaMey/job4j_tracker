package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter the new name of application:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println("id: " + item.getId() + " name: " + item.getName());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return false;
    }
}
