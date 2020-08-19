package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("===  Edit item ====");
        int id =input.askInt("Enter the id of the changed application:");
        String name = input.askStr("Enter the new name of the changed application:");
        Item item = new Item(name);
        if (tracker.replace(id,item)) {
            System.out.println("имя заявки изменено");
        } else {
            System.out.println("введен неккоректный id");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id of the removable application:");
        if (tracker.delete(id)) {
            System.out.println("имя заявки изменено");
        } else {
            System.out.println("введен неккоректный id");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select:");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                System.out.println("=== Output all items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println("id: "+ item.getId() + " name: " + item.getName());
                }
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                int id = input.askInt("Enter the id of the application:");
                Item item = tracker.findById(id);
                if (item == null ) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println("id: " + item.getId() + "name: " + item.getName());
                }
            } else if (select == 5) {
                String name = input.askStr("Enter the new name of application:");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println("id: " + item.getId() + "name: " + item.getName());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
                System.out.println("good bye");
            }
        }
    }

    private void showMenu() {
        System.out.println('\n' +"Menu.");
        System.out.println("0. Add new Item" + '\n'
        + "1. Show all items" + '\n'
                + "2. Edit item" + '\n'
                + "3. Delete item" + '\n'
                + "4. Find item by Id" + '\n'
                + "5. Find items by name" + '\n'
                + "6. Exit Program" + '\n' );
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
