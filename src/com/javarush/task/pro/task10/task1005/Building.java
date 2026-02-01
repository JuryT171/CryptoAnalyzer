package com.javarush.task.pro.task10.task1005;

/* 
Многосерийный предприниматель
*/

import java.lang.reflect.Type;

public class Building {
    private String type;

  //  public Building(String type) {
  //      this.type = type;
  //  }

    //напишите тут ваш код

    public void initialize(String type){   //  создали метод который присваивает значение полю type
        this.type = type;
    }

    public static void main(String[] args) {
        Building building = new Building();  // обьект билдинг без параметров
        building.initialize("Барбершоп");  // присвоили параметр с помощью вызова метода initialize
    }
}
