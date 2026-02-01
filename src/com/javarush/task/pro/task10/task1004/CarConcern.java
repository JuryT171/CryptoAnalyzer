package com.javarush.task.pro.task10.task1004;

/* 
Жажда скорости
*/

public class CarConcern {
    private final String manufacturer = "Lamborghini";
    private final String model;
    private final int year;
    private final String color;

    public CarConcern(String model, int year, String color) {  //  в этом конструкторе переданы 3 параметра
        //напишите тут ваш код
        this.model = model;
        this.year = year;
        this.color = color;

    }

    public CarConcern(String model, int year) {  //здес 2 параметра
        //напишите тут ваш код
        this.model = model;
        this.year = year;
        this.color = "Оранжевый";  // инициализируем параметр, который не передан т.к. он обьявлен в классе final

    }

    public CarConcern(String model) {
        //напишите тут ваш код
        this.model = model;
        this.year = 4321;   // инициализируем параметр, который не передан т.к. он обьявлен в классе final
        this.color = "Оранжевый";    // инициализируем параметр, который не передан т.к. он обьявлен в классе final
    }
}
