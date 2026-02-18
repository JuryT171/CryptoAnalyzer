package com.javarush.task.jdk13.task53.task5302;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;  //  переменная константа задающаая размер поля

    public void initialize(){
        setScreenSize(SIDE,SIDE);  // задаем размер игрового поля
    }
}