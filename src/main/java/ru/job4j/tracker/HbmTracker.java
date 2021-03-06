package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = true;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Item itemNew = session.get(Item.class, id);
            if (itemNew != null) {
                itemNew.setName(item.getName());
                session.update(itemNew);
            } else {
                result = false;
            }
            transaction.commit();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.delete(item);
                result = true;
                transaction.commit();
            }
            return result;
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> result;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            result = session.createQuery("from Item", Item.class).list();
            transaction.commit();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            list = session.createQuery(
                    "from Item where name = : paramName",
                    Item.class)
                    .setParameter("paramName", key)
                    .list();
            transaction.commit();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            item = session.get(Item.class, id);
            transaction.commit();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

}
