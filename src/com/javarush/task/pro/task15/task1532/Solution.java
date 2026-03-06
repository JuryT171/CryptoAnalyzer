package com.javarush.task.pro.task15.task1532;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/* 
Шифр
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(encrypt("abcdefghi"));
    }

    public static ByteArrayOutputStream encrypt(String message) {
        //напишите тут ваш код
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  //  создаем поток
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);  //  получаем байты из строки

        int left = 0;  //  две переменные
        int right = messageBytes.length - 1;

        while (left <= right) {  //  цикл пока левый не достигнет правого
            outputStream.write(messageBytes[left]);

            if (left < right) { // пока левый меньше првого значит спрва есть байты
                outputStream.write(messageBytes[right]);
            }
            left ++;
            right--;

        }
        return outputStream;
    }
}
