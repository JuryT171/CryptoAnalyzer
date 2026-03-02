package com.javarush.task.jdk13.task53.task5303;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int HEIGHT = 15;  //  константы размера поля
    public static final int WIDTH = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple ;

    @Override
    public void initialize() {    // переопределили метод
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    @Override
    public void onKeyPress(Key key) {  //  переопределили метод двжения с клавиатуры
        if (key == Key.LEFT){
             snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
    }

    private void createGame(){
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH/2,HEIGHT/2);
        createNewApple();
        drawScene();
    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKGOLDENROD,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {  //  переопределяем метод ходьбы..
        snake.move(apple); //  запускаем
        if (apple.isAlive==false){  //  если яблоко не живое - создаем новое
            createNewApple();
        }
        drawScene(); //  перерисовываем поле

    }
    private void createNewApple(){
        Apple newApple; //  создаем новый обьект тип Эппл
        int result1 = getRandomNumber(WIDTH); //  получаем рандомное значение
        int result2 = getRandomNumber(HEIGHT);
        newApple = new Apple(result1,result2); //  присваиваем параметры
        apple=newApple; //  присваиваем ссылку
    }
}

