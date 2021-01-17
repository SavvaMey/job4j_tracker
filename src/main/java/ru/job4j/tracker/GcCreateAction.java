package ru.job4j.tracker;

public class GcCreateAction implements UserAction{
    private final Output out;

    public GcCreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "CreateGcItem";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ====");
        for (int i = 0; i < 500000000; i++) {
            Item item = new Item("itemGC" + i);
            tracker.add(item);
        }
        return true;
    }
}
