package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Output all items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println("id: "+ item.getId() + " name: " + item.getName());
                }
            } else if (select == 2) {
                System.out.println("===  Edit item ====");
                System.out.print("Enter the id of the changed application:");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter the new name of the changed application:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id,item)) {
                    System.out.println("имя заявки изменено");
                } else {
                    System.out.println("введен неккоректный id");
                }
            } else if (select == 3) {
                System.out.print("Enter the id of the removable application:");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("имя заявки изменено");
                } else {
                    System.out.println("введен неккоректный id");
                }
            } else if (select == 4) {
                System.out.print("Enter the id of the application:");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item == null ) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println("id: " + item.getId() + "name: " + item.getName());
                }
            } else if (select == 5) {
                System.out.print("Enter the new name of application:");
                String name = scanner.nextLine();
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
                + "6. Exit Program" + '\n'
                + "Select:" );
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
