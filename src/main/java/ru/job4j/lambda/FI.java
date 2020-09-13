package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("A", 20),
                new Attachment("AVV", 120),
                new Attachment("AV", 23)
        };
        Comparator<Attachment> cmpDescSize = (left, right) -> right.getName().length() - left.getName().length();
        Arrays.sort(atts, cmpDescSize);
        System.out.println(Arrays.toString(atts));
    }
}
