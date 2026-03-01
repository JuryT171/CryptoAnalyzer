package com.javarush.task.jdk13.task53.task5303;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int HEIGHT = 15;  //  константы размера поля
    public static final int WIDTH = 15;
    private Snake snake;
    private int turnDelay;

    @Override
    public void initialize() {    // переопределили метод
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void createGame(){
        Snake snakeGame = new Snake(WIDTH/2,HEIGHT/2);
        snake = snakeGame;
        drawScene();
        turnDelay = 300;  //  задали значение переменной
        setTurnTimer(turnDelay); // вызвали метод со значением
    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.BLUE);
            }
        }
        snake.draw(this);
    }

    @Override
    public void onTurn(int step) {  //  переопределяем метод ходьбы..
        snake.move(); //  запускаем
        drawScene(); //  перерисовываем поле
    }
}

