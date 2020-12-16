package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
//    private SqlTracker sqlTracker;

    public static Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(SqlTrackerTest.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByNameItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(SqlTrackerTest.init()))) {
            tracker.add(new Item("name"));
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(SqlTrackerTest.init()))) {
            tracker.add(new Item("name"));
            tracker.add(new Item("asdad"));
            tracker.add(new Item("name"));
            assertThat(tracker.findAll().size(), is(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(SqlTrackerTest.init()))) {
            Item item = new Item("name");
            Item itemAn = new Item("name");
            tracker.add(item);
            tracker.add(itemAn);
            tracker.delete(item.getId() + "");
            assertThat(tracker.findAll().size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByIdItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(SqlTrackerTest.init()))) {
            Item item = new Item("test");
            tracker.add(item);
            assertThat(item.getName(),
                    is(tracker.findById(String.valueOf(item.getId())).getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(SqlTrackerTest.init()))) {
            Item item = new Item("name");
            Item itemAn = new Item("key");
            tracker.add(item);
            tracker.add(itemAn);
            Item itemAnReplace = new Item("ok");
            tracker.replace(itemAn.getId() + "", itemAnReplace);
            assertThat(tracker.findByName("ok").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}