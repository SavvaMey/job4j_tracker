package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id of the application:");
        Item item = tracker.findById(id);
        if (item == null ) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println("id: " + item.getId() + " name: " + item.getName());
        }
        return false;
    }
}
