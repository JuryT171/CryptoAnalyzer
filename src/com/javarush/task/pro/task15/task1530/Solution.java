package com.javarush.task.pro.task15.task1530;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/* 
Байты в символы
*/

public class Solution {

    public static void main(String[] args) {
        ByteArrayInputStream stream = new ByteArrayInputStream("O sole, o sole mio!\nSta 'nfronte a te!\n Sta 'nfronte a te!".getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(bytesToChars(stream, 38)));
    }

    //напишите тут ваш код
    public static char[] bytesToChars(ByteArrayInputStream stream, int n){
        byte[] buffer = new byte[n];  //  массив для чтения байтов
        int bytesRead = stream.read(buffer, 0, n);  //  считываем от начало до n

        if (bytesRead > 0) {  // если байты прочитаны
            char[] chars = new char[bytesRead];  // создаем массив символов

            for (int i = 0; i < bytesRead; i++) {  // цикл по массиву
                chars[i] = (char) buffer[i];  // приведение байта к char.
            }
            return chars;
        } else {
            return new char[0];  //  возвращаем пустоту если все прочитано
        }
    }
}
