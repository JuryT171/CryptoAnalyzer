package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        //напишите тут ваш код
        double result;  // создали переменную для конвертации
        result = Double.parseDouble(string);  //  сконвертировали
        long newResult = Math.round(result); // округлили и сохарнили в новую переменную
        System.out.println(newResult);
    }
}
