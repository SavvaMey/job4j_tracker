package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2" }
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        Item delete = tracker.findById(1);
        assertThat(delete, is(nullValue()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "New name", "2" }
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("New name"));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "=== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "guyazo", "1", "2"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find all items" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find all items" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Output all items ====" + System.lineSeparator()
                        + "id: 1 " + "name: guyazo" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find all items" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "name", "1", "name", "2" }
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find by name" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find by name" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Find by name ====" + System.lineSeparator()
                        + "id: 1 " + "name: " + "name" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find by name" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "name", "1", "1", "2"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find by id" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find by id" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Find by id ====" + System.lineSeparator()
                        + "id: 1 " + "name: " + "name" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create" + System.lineSeparator()
                        + "1. Find by id" + System.lineSeparator()
                        + "2. Exit" + System.lineSeparator()
                        + "=== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Please enter validate data again.\r\n"));
    }
}