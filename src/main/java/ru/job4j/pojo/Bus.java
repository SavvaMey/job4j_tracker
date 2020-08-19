package ru.job4j.pojo;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("driving");
    }

    @Override
    public void passanger(int passangers) {
        System.out.println("count passsengers:" + passangers);
    }

    @Override
    public double fillUp(double fuel) {

        return fuel * 24.3;
    }
}
