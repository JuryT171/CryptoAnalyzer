package com.javarush.task.pro.task10.task1003;

/* 
Построим новый бизнес-комплекс JavaRush Business Center
*/

public class Skyscraper {
    private int floorsCount;
    private String developer;

    //напишите тут ваш код

    public Skyscraper(){    //  инициализировали поля согласно условию задачи
        this.floorsCount = 5;
        this.developer = "JavaRushDevelopment";
    }
    public Skyscraper(int floorsCount,String developer ){   // инициализировали поля аргументами этого конструктора
        this.floorsCount = floorsCount;
        this.developer = developer;
    }

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperUnknown = new Skyscraper(50, "Неизвестно");
    }
}
