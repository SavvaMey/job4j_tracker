package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        ball.roll();
        hare.tryEat(ball);
        ball.roll();
        wolf.tryEat(ball);
        ball.roll();
        fox.tryEat(ball);

    }
}
