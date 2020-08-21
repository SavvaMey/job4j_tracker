package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            String s = value[i];
            if (s == key) {
                rsl = i;
            }

        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl ;
    }

    public static void main(String[] args) {
        try {
            String[] s  = {"gul", "gal", "guyazo"};
            indexOf(s, "h");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}



