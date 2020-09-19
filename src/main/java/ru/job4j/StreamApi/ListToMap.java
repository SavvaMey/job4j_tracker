package ru.job4j.StreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("key", 50),
                new Student("dan",40),
                new Student("bim", 48),
                new Student("key", 40)
        );
        Map<String, Integer> map = studentList.stream()
                .collect(Collectors.toMap(Student::getSurname, Student::getScore,
                        (address1, address2) -> address1 ));
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }
}
