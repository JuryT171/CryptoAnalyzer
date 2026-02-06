package com.javarush.task.jdk13.task53.task5301;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;   // константа размера игрового поля
    private int gameField[][] = new int[SIDE][SIDE];   // создали массив с ячейками 4*4

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);   // переопределили метод,задали размер 4*4
        createGame();  //вызвали метод создание игры
        drawScene();  // вызвали метод для закрашивания поля
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {   //  метод для закрашивания поля в определенный цвет
        for (int x = 0; x < SIDE; x++) {  //  пробегаемся по массиву клеток
            for (int y = 0; y < SIDE; y++) {
                setCellColor(x, y, Color.ORANGE);  // закрашиваем в оранжевый
            }
        }
    }

    private void createNewNumber() {  // создали метод присваения значения клетки
        boolean isCreated = false;  // переменная для понимания было ли создано число
        do {
            int x = getRandomNumber(SIDE);  // получаем рандомное значение клетки
            int y = getRandomNumber(SIDE);
            if (gameField[y][x] == 0) {  //  если ячейка со значением 0
                int randomNumber = getRandomNumber(10); // переменная для рандомного числа
                if (randomNumber < 9) {  // если рандомное число меньше 9 (вероятность 90%)
                    randomNumber = 2;  //  присваиваем значение 2
                }else if (randomNumber == 9) {  // если рандомное число  9 (вероятность 10%)
                    randomNumber = 4;   //  присваиваем значение 4
                }
                gameField[y][x] = randomNumber;  //  заносим в поле полученное число
                isCreated = true;  // маркер для завершения цикла
            }
        }while(!isCreated); //  повторяем цикл пока значение false, то есть пока число не присвоено
    }
}

