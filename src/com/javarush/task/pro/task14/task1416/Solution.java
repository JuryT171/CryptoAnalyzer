package com.javarush.task.pro.task14.task1416;

/* 
Логирование стектрейса
*/

public class Solution {

    public static void main(String[] args) {
        try {
            dangerousMethod();  //  оборачиваем в try метод
        } catch (Exception e) {  //  ловим
            e.printStackTrace();  //  выводим на экран
        }

    }

    static void dangerousMethod() throws Exception {
        throw new Exception("Mu-ha-ha!");
    }
}
