package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;

/* 
Дефрагментация памяти
*/

public class Solution {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        //напишите тут ваш код
        int nonNull = 0;  //  позиция не пустого элемента
        for (int i = 0; i < array.length; i++) {  // перебираем массив
            if(array[i] != null){  //  если значенине не null
                String temp = array[i];   //  присваиваем временной переменной это значение
                array[i]=null;  // заменяем не пустое значение на null
                array[nonNull]=temp;  //  ставим не пустое значение из временной переменной в начало
                nonNull++;
            }
        }
    }
}
