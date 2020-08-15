package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummydic = new DummyDic();
        String s = dummydic.engToRus("hello");
        System.out.println(s);
    }
}
