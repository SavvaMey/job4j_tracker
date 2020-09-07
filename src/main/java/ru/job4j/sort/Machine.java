package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int balance = money - price;
        int index = 0;
        for (int coin : coins) {
            while (balance - coin >= 0) {
                balance -= coin;
                rsl[index] = coin;
                size++;
                index++;
            }
        }

        return Arrays.copyOf(rsl, size);
    }
}
