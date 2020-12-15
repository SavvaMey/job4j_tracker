package ru.job4j.streamapi;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void listToMap() {
        List<Student> studentList = List.of(
                new Student("key", 50),
                new Student("dan", 40),
                new Student("bim", 48),
                new Student("key", 40)
        );
        Map<String, Integer> map = ListToMap.listToMap(studentList);
        Map<String, Integer> mapExpected = Map.of(
                "key", 50,
                "dan", 40,
                "bim", 48
        );
        assertThat(mapExpected, is(map));
    }

    @Test
    public void matrixToList() {
        Integer[][] arr = {{1, 2, 3}, {1, 2}};
        List<Integer> list = ListToMap.listInt(arr);
        List<Integer> listExpected = List.of(1, 2, 3, 1, 2);
        assertThat(listExpected, is(list));
    }
}