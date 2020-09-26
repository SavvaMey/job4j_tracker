package ru.job4j.StreamApi;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class OwnStream {

    public interface Generator<T> {
        void generate(Consumer<T> context);
    }

        public static class StreamJob4j<T>  {

            private final Generator<T> generator;


            public StreamJob4j(Generator<T> generator)  {
                this.generator = generator;
            }

            public void forEach(Consumer<T> consumer) {
                generator.generate(consumer);
            }

            public StreamJob4j<T> filter(Predicate<T> predicate) {
                return new StreamJob4j<>(generatorContext -> generator.generate(value -> {
                    if (predicate.test(value)) {
                        generatorContext.accept(value);
                    }
                }));
            }

            public static <T> StreamJob4j<T> of(Collection<T> collection) {
                return new StreamJob4j<>(collection::forEach);
            }
//            public <R,A> R collect(Collector<? super T,A,R> collector){
//                return
//            }


        }

        public static void main(String... args) {
            StreamJob4j.of(Arrays.asList(5, 7, 9, 1))
                   .filter(s -> s > 2)
                    .forEach(System.out::println);
        }
}
