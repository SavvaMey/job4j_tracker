package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", 150);
        Book secondBook = new Book("Garry", 120);
        Book thirdBook = new Book("value", 10);
        Book fourthBook = new Book("gintama", 500);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getCountPages());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getCountPages());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            if (pr.getName() == "Clean code") {
                System.out.println(pr.getName() + " - " + pr.getCountPages());
            }
        }
    }
}
