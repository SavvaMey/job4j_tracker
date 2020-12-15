package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public SqlTracker() {
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement(
                "INSERT INTO items (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.executeUpdate();
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        try (PreparedStatement statement = cn.prepareStatement(
                "UPDATE items set name=? where id=? ")) {
            statement.setString(1, item.getName());
            statement.setInt(2, Integer.parseInt(id));
            int row = statement.executeUpdate();
            if (row == 1) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try (PreparedStatement statement = cn.prepareStatement(
                "DELETE FROM items WHERE id=?")) {
            statement.setInt(1, Integer.parseInt(id));
            int row = statement.executeUpdate();
            if (row == 1) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items")) {
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString(2), resultSet.getInt(1));
                items.add(item);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "SELECT * FROM items WHERE name=?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getString(2), resultSet.getInt(1));
                    items.add(item);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(String id) {
        Item item = new Item();
        try (PreparedStatement statement = cn.prepareStatement(
                "SELECT * FROM items WHERE id=?")) {
            statement.setInt(1, Integer.parseInt(id));
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                    item.setName(resultSet.getString(2));
                    return item;
                }
            };

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
