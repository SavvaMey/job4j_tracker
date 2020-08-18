package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int kon = 1;
        int matches = 11;
        int select;
        System.out.println("Спички");
        while (run) {
            System.out.println("Кон " + kon);
            System.out.println("Осталось спичек " + matches);
            System.out.print("Игрок 1 возьмите от 1 до 3 спичек: ");
            select = Integer.valueOf(input.nextLine());
                matches -= select;
                if (matches == 0) {
                    System.out.println("1 игрок выйграл, спичек осталось: " + matches);
                    run = false;
                    break;
                } else {
                    System.out.println("Спичек осталось " + matches);
                }
            System.out.print("Игрок 2 возьмите от 1 до 3 спичек: ");
            select = Integer.valueOf(input.nextLine());
            matches -= select;
            if (matches == 0) {
                System.out.println("2 игрок выйграл, спичек осталось: " + matches);
                run = false;
                break;
            } else {
                System.out.println("Спичек осталось " + matches);
            }
            kon++;
        }
    }
}
