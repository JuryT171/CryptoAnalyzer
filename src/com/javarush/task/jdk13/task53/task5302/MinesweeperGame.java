package com.javarush.task.jdk13.task53.task5302;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;  //  переменная константа задающаая размер поля
    private GameObject gameField[][] = new GameObject [SIDE][SIDE];  //  масиив ячеек
    private int countMinesOnField; //  счетчик мин

    private void createGame () {  //  создали метод
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) { //  прошлись циклом по массиву
               int randomNumber = getRandomNumber(10); //  генерируем рандом
                boolean isMine = randomNumber < 1;  //  вероятность 10%
                if (isMine){
                    countMinesOnField++;  //  счетчик мин
                }
                gameField [y][x] = new GameObject(x,y, isMine);  //  присвоили значения ячейкам
                setCellColor(x,y, Color.ORANGE);  //  закрасили ячейки
            }
        }
    }


    public void initialize(){
        setScreenSize(SIDE,SIDE);  // задаем размер игрового поля
        createGame();
    }

}