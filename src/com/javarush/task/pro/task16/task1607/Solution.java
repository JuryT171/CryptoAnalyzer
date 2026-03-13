package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }
    public static LocalDate date = LocalDate.of(2020,9,12);

    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate today = LocalDate.now();

        return today;
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate date1 = LocalDate.of(2020,9,12);
        return date1;
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        int date22 = date.getDayOfYear();  //  получаем число дня
        LocalDate date2 = LocalDate.ofYearDay(2020,date22);  //возвращаем дату по номеру дня
        return date2;
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        long days = date.toEpochDay();  // получаем дни от 01.01.1970 до нашей даты
        LocalDate date3 = LocalDate.ofEpochDay(days);  // получаем дату отсчитывая днт от 01011970
        return date3;
    }
}
