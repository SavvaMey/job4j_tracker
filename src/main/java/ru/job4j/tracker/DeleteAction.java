package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "delete";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete Item ====");
        int id = input.askInt("Enter the id of the removable application:");
        if (tracker.delete(id)) {
            out.println("имя заявки удалено");
        } else {
            out.println("введен неккоректный id");
        }
        return true;
    }
}
