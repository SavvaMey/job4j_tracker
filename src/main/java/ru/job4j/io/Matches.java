package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int igrok = 1;
        int matches = 11;
        int select;
        System.out.println("Спички");
        while (run) {
            System.out.println("Осталось спичек " + matches);
            System.out.print("Игрок " + igrok  + " возьмите от 1 до 3 спичек: ");
            select = Integer.valueOf(input.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                if (matches - select < 0) {
                    System.out.println("нельзя столько взять спичек, спичек будет меньше нуля");
                    continue;
                }
                matches -= select;
                if (matches == 0) {
                    System.out.println(igrok + " игрок выйграл, спичек осталось: " + matches);
                    run = false;
                    break;
                } else {
                    System.out.println("Спичек осталось " + matches);
                }
                igrok = (igrok == 1) ? 2 : 1;
            } else {
                System.out.println("Нельзя брать столько спичек");
            }
        }
    }
}
