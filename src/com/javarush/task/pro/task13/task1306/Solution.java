package com.javarush.task.pro.task13.task1306;

import java.util.ArrayList;
import java.util.Collections;

/* 
Изучаем методы класса Collections, часть 1
*/

public class Solution {

    public static void copy(ArrayList<String> destination, ArrayList<String> source) {
        Collections.copy(destination,source);  //  копируем из дестинайшн в соурс
    }

    public static void addAll(ArrayList<String> list, String... strings) {
        Collections.addAll(list,strings);  //  вставляем в лист стрингс
        }


    public static void replaceAll(ArrayList<String> list, String oldValue, String newValue) {
        Collections.replaceAll(list,oldValue,newValue );  //  заменаяем в листе элементы олдвалью на ньювалью
    }
}
