package com.javarush.task.pro.task10.task1016;

/* 
Прогноз погоды
*/

public class Solution {


    public static void showWeather(City city) {
        //напишите тут ваш код

        System.out.println("В городе"+" "+city.getName()+" "+"сегодня температура воздуха"+" "+ city.getTemperature());
    }  //  вывод в консоль согласно условию

    public static void main(String[] args) {
        //напишите тут ваш код
        City city = new City("Дубай",40);  //  создаем обьект с параметрами
        showWeather(city);  //  вызываем метод для вывода в консоль
    }

}
