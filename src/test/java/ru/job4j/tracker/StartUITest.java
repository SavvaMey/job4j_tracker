package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
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
                new String[]{"0", "Item name", "1", "1", "2"}
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
                new String[]{"0", "Item name", "1", "1", "New name", "2"}
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
                new String[]{"0", "name", "1", "name", "2"}
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
                new String[]{"one", "1"}
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
                new String[]{"one", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Please enter validate data again.\r\n"));
    }

    @Test
    public void whenReplaceActThenSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Replace Item ====" + ln + "имя заявки изменено" + ln)
        );
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenReplaceActThenFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }

    @Test
    public void whenDeleteActThenSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Add item"));
        DeleteAction rep = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Delete Item ====" + ln + "имя заявки удалено" + ln)
        );
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenDeleteActThenFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Add item"));
        DeleteAction rep = new DeleteAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is("Add item"));
    }

    @Test
    public void whenFindByIdActionThenSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Add item"));
        FindByIdAction rep = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find by id ====" + ln
                        + "id: 1 name: Add item" + ln)
        );
        assertThat(tracker.findById(1).getName(), is("Add item"));
    }

    @Test
    public void whenFindByIdActionThenFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Add item"));
        FindByIdAction rep = new FindByIdAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find by id ====" + ln
                        + "Заявка с таким id не найдена" + ln)
        );
    }

    @Test
    public void whenFindByNameActionThenSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Add item"));
        tracker.add(new Item("Add item"));
        FindByNameAction rep = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Add item");
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find by name ====" + ln
                        + "id: 1 name: Add item" + ln
                        + "id: 2 name: Add item" + ln)
        );
        assertThat(tracker.findByName("Add item").size(), is(2));
    }

    @Test
    public void whenFindByNameActionThenFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Add item"));
        tracker.add(new Item("Add item"));
        FindByNameAction rep = new FindByNameAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find by name ====" + ln
                        + "Заявки с таким именем не найдены" +ln)
        );
    }
}