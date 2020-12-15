package ru.job4j.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {
    public static Map<String, Integer> listToMap(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname, Student::getScore,
                        (address1, address2) -> address1));
    }

    public static List<Integer> listInt(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}
