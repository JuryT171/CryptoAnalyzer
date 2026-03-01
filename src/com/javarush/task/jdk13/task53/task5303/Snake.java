package com.javarush.task.jdk13.task53.task5303;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject>snakeParts = new ArrayList<>(); //  создали аррайлист для хранения змейки
    public Snake(int x,int y) {
        GameObject gameObjectFirst = new GameObject(x,y);  //  сконструировали с помощью параметров три обьекта
        GameObject gameObjectSecond = new GameObject(x+1,y);
        GameObject gameObjectThird = new GameObject(x+2,y);
        snakeParts.add(gameObjectFirst);  //  ддобавилии в аррайлист
        snakeParts.add(gameObjectSecond);
        snakeParts.add(gameObjectThird);
    }

}
