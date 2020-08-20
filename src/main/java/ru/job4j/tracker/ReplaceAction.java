package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "=== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id =input.askInt("Enter the id of the changed application:");
        String name = input.askStr("Enter the new name of the changed application:");
        Item item = new Item(name);
        if (tracker.replace(id,item)) {
            System.out.println("имя заявки изменено");
        } else {
            System.out.println("введен неккоректный id");
        }
        return true;
    }
}
