package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item delete = tracker.findById(1);
        assertThat(delete, is(nullValue()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name" , "1", "1", "New name", "2" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New name"));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator() +
                        "=== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0","guyazo","1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find all items" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Create a new Item ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find all items" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Output all items ====" + System.lineSeparator() +
                        "id: 1 " + "name: guyazo" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find all items" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0","name","1", "name","2" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                        "1. Find by name" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Create a new Item ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find by name" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Find by name ====" + System.lineSeparator() +
                        "id: 1 " + "name: " + "name" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find by name" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0" ,"name", "1", "1" , "2" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find by id" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Create a new Item ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find by id" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Find by id ====" + System.lineSeparator() +
                        "id: 1 " + "name: " + "name" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create" + System.lineSeparator() +
                        "1. Find by id" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator() +
                        "=== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "1" , "0" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                                + "=== Exit ====%n"
                )
        ));
    }
}