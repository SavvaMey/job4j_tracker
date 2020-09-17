package ru.job4j.StreamApi;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> listStudent;

    @Before
    public void createNewStudents(){
        listStudent = List.of(
                new Student("Dan", 30),
                new Student("Kan",60),
                new Student("Key", 20),
                new Student("Best", 100),
                new Student("Pop", 80)
                );
    }

    @Test
    public void lowScoreShouldClassV(){
        School cl = new School();
        List<Student> classV = cl.collect(listStudent, student -> (student.getScore() < 50 && student.getScore() > 0));
        List<Student> listExpected = List.of (
                new Student("Dan", 30),
                new Student("Key", 20)
        );
        assertThat(listExpected, is(classV));
    }

    @Test
    public void MiddleScoreShouldClassB(){
        School cl = new School();
        List<Student> classV = cl.collect(listStudent, student -> (student.getScore() <= 70 && student.getScore() >= 50));
        List<Student> listExpected = List.of (
                new Student("Kan",60)
        );
        assertThat(listExpected, is(classV));
    }

    @Test
    public void HighScoreShouldClassA(){
        School cl = new School();
        List<Student> classV = cl.collect(listStudent, student -> (student.getScore() <= 100 && student.getScore() > 70));
        List<Student> listExpected = List.of (
                new Student("Best", 100),
                new Student("Pop", 80)
        );
        assertThat(listExpected, is(classV));
    }

}