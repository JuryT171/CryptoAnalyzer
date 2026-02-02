package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    //напишите тут ваш код


    @Override
    public boolean equals(Object o) {//  переопределили метод equals
        if (this==o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;  //  если обьект не из нашего класса или равен null - false
        Iphone iphone = (Iphone) o;
        return this.price == iphone.price   // сравниваем значения обьектов
                && Objects.equals(this.model, iphone.model)
                && Objects.equals(this.color, iphone.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, price);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
