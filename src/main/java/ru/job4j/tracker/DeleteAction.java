package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id of the removable application:");
        if (tracker.delete(id)) {
            System.out.println("имя заявки удалено");
        } else {
            System.out.println("введен неккоректный id");
        }
        return true;
    }
}
