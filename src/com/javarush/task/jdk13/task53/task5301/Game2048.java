package com.javarush.task.jdk13.task53.task5301;
import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE =4;

    @Override
    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();
    }

    private int gameField [][] = new int[SIDE][SIDE];
    private void createGame(){
    }
}
