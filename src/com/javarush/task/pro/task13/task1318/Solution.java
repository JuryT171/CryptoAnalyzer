package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
    }

    public static Month getNextMonth(Month month) {
        //напишите тут ваш код
        int index = month.ordinal();  //  присваиваем переменной индекс значение енума
        if(month.ordinal()!=11) {  //  если значение не последне
            return Month.values()[index + 1];  //  возвращаем следующий месяц
        }
        else return Month.values()[0];  // если крайнее значение - возвращаем первый
    }
}
