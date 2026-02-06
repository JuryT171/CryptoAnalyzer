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



    private void createNewNumber() {
        boolean isCreated = false;  //  переменная маркер
        do {
            int x = getRandomNumber(SIDE);  // переменная с рандомным числом
            int y = getRandomNumber(SIDE);
            if (gameField[y][x] == 0) {  //  если поле пустое
                int randomNumber = getRandomNumber(10);  //переменная с рандомным числом 0-9
                if (randomNumber < 9) {  // если число 0-9  90%  - значение 2
                    randomNumber = 2;
                } else if (randomNumber == 9) {   //если равно 9 то значение 4 (10%)
                    randomNumber = 4;
                }
                gameField[y][x] = randomNumber;  // заносим в поле полученное число
                isCreated = true;  //
            }
        } while (!isCreated); //  завершаем цикл когда все сделано
    }

    private Color getColorByValue(int value) {   //  метод для присваения цвета в клетку по числу
        switch (value) {
            case 0:
                return Color.WHITE;
            case 2:
                return Color.PLUM;
            case 4:
                return Color.CYAN;
            case 8:
                return Color.GREEN;
            case 16:
                return Color.ORANGE;
            case 32:
                return Color.PINK;
            case 64:
                return Color.RED;
            case 128:
                return Color.MAGENTA;
            case 256:
                return Color.YELLOW;
            case 512:
                return Color.LIGHTGRAY;
            case 1024:
                return Color.GRAY;
            case 2048:
                return Color.DARKGRAY;
            default:
                return Color.NONE;
        }

    }

    private void setCellColoredNumber(int x, int y, int value) {  // метод для отображения цвета клетки и значения
        Color cellColor = getColorByValue(value);   // получаем цвет
        String str; // строковая переменная
        if (value > 0) {  //  если значение больше 0
            str = "" + value; //  преобразуем число в строку
        } else {
            str = "";  //  иначе пустая строка
        }
        setCellValueEx(x, y, cellColor, str);  //  Устанавливаем цвет и строковое значение для клетки
    }

    private void drawScene() {   //  метод для закрашивания поля в определенный цвет
        for (int y = 0; y < SIDE; y++) {  //  пробегаемся по массиву клеток
            for (int x = 0; x < SIDE; x++) {
                int cellValue = gameField[y][x];
                setCellColoredNumber(x, y,cellValue);  // Вызываем наш метод для отрисовки клетки
            }
        }
    }
}



