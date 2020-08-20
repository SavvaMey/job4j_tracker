package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by id ====");
        int id = input.askInt("Enter the id of the application:");
        Item item = tracker.findById(id);
        if (item == null ) {
            out.println("Заявка с таким id не найдена");
        } else {
            out.println("id: " + item.getId() + " name: " + item.getName());
        }
        return true;
    }
}
