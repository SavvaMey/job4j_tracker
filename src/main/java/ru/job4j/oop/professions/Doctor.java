package ru.job4j.oop.professions;

public class Doctor extends Profession {
    private int experience;

    public  Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
