package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment attachment : list) {
                if (predicate.test(attachment)){
                    rsl.add(attachment);
                }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list, int to) {
        Predicate<Attachment> predicate = x -> x.getSize() > to;
        return filter(list,predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list, String string) {
        Predicate<Attachment> predicate = x -> x.getName().contains(string);
        return filter(list,predicate);
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("bug", 101),
                new Attachment("image 2", 150),
                new Attachment("image 3", 13),
                new Attachment("image 5", 13),
                new Attachment("image 4", 13)
        );
        System.out.println(filterSize(attachments, 100));
        System.out.println(filterName(attachments, "bug"));
    }
}
