package com.javarush.task.pro.task12.task1210;

import java.util.ArrayList;

/* 
Переворачивание данных
*/

public class Solution {
    static ArrayList<Integer> numbers = new ArrayList<Integer>(10);

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);  //  заполняем массив числами
        }
    }

    public static void reverse() {
        int n = numbers.size()-1;  //  индекс последнего элемента
        for (int i = 0; i < numbers.size() / 2; i++) {  // начинаем цикл с середины
            int temp = numbers.get(i);  //  временной переменной присваиваем значение 1го элемента
            numbers.set(i, numbers.get(n-i));  // ставим значение i на последнее
            numbers.set((n - i), temp); //  ставим значение последнее в начало
        }
    }

    private static void print() {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
