package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Replace Item ====");
        int id = input.askInt("Enter the id of the changed application:");
        String name = input.askStr("Enter the new name of the changed application:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("имя заявки изменено");
        } else {
            out.println("введен неккоректный id");
        }
        return true;
    }
}
