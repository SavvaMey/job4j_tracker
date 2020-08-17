package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Igor");
        student.setSurname("Ivanonv");
        student.setFartherName("Alekseevich");
        student.setGroup("AE-19-03");
        student.setDate("2018-11-30");
        System.out.println(student);
    }
}
