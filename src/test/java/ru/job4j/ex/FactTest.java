package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcWhenMinus1thenEx() {
        Fact.calc(-3);
    }

    @Test
    public void calcWhen1then1() {
        Fact.calc(1);
    }
}