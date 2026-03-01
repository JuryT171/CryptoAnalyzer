package com.javarush.task.jdk13.task53.task5303;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E"; //  константа для хранения смайлика головы змеи
    private static final String BODY_SIGN = "\u26AB"; //  константа для смайлика самой змеи
    public boolean isAlive = true;
    private List<GameObject> snakeParts = new ArrayList<>(); //  создали аррайлист для хранения змейки
    private Direction direction = Direction.LEFT; //  поле с началом движения влево


    public Snake(int x, int y) {
        GameObject gameObjectFirst = new GameObject(x, y);  //  сконструировали с помощью параметров три обьекта
        GameObject gameObjectSecond = new GameObject(x + 1, y);
        GameObject gameObjectThird = new GameObject(x + 2, y);
        snakeParts.add(gameObjectFirst);  //  ддобавилии в аррайлист
        snakeParts.add(gameObjectSecond);
        snakeParts.add(gameObjectThird);
    }

    public void draw(Game game) {
        Color color = isAlive ? Color.BLACK : Color.RED; //  если змея живая - блэк, если нет - красная
        for (int i = 0; i < snakeParts.size(); i++) { //  проходимся циклом по аррайлисту
            GameObject part = snakeParts.get(i);  //  сохраняем каждый обьект
            String smile = (i != 0) ? BODY_SIGN : HEAD_SIGN; // тернарный оператор - если индекс не первый, то смайлик тела,если первый головы
            game.setCellValueEx(part.x, part.y, Color.NONE, smile, color, 75); //  закрашиваем змею

            /* String snake;  // переменная для смайлика
             if (i != 0) {  //  если индекс не ноль
                snake = BODY_SIGN;  //  голова
            } else {
                snake = HEAD_SIGN;  //  иначе тело
            }
            if(isAlive = true) {
                game.setCellValueEx(part.x, part.y, Color.NONE, snake, color, 75);  //  вызываем метод отображения
            } else {
                game.setCellValueEx(part.x, part.y, Color.NONE, snake, color, 75);
            } */
        }
    }

    public void setDirection(Direction direction) {  //  сеттер для движения змеи
        this.direction = direction;
    }
}

