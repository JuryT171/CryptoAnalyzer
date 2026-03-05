package com.javarush.task.pro.task15.task1508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Читаем из консоли
*/

public class Solution {
    public static void main(String[] args) {
        try (InputStream stream = System.in;  //  ввод с консоли
             InputStreamReader reader = new InputStreamReader(stream); //  оборачиваем для чтения символов
             BufferedReader buff = new BufferedReader(reader))  //  добавляем в буффер
              {
                  String line = buff.readLine();  //  записываем строку
            char[] chars = line.toCharArray();  //  преоьразуем строку в массив символов
            for (int i = 0; i < chars.length; i++) {  //  цикл
                if (i % 2 == 1) {  //  если нечетное то верхний регистр
                    System.out.print(String.valueOf(chars[i]).toUpperCase());
                } else {
                    System.out.print(String.valueOf(chars[i]).toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

