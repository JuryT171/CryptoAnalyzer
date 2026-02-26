package com.javarush.task.pro.task14.task1418;

public class ChildrenNotInitializedException extends RuntimeException{  // создаем свой класс исключения
    public ChildrenNotInitializedException(String message) {  //  метод принимающий параметр мессадж
        System.out.println(message);  //  выводим на экран
    }
}
