package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        Item delete = tracker.findById(1);
        assertThat(delete, is(nullValue()));
    }

    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name" , "1", "1", "New name", "2" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New name"));
    }
}