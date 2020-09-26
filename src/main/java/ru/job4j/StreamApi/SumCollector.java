package ru.job4j.StreamApi;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SumCollector implements Collector<Integer, ArrayList<Integer>,Integer> {
    @Override
    public Supplier<ArrayList<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<Integer>, Integer> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<Integer>> combiner() {
        return (l, r) -> {
            l.addAll(r);
            return l; };
    }

    @Override
    public Function<ArrayList<Integer>, Integer> finisher() {
        return s ->  s.stream().mapToInt(i ->  i).sum();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
