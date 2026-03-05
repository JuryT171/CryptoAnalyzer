package com.javarush.task.pro.task15.task1528;

import java.io.*;
import java.util.Scanner;

/* 
Пишем байты в файл
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);  // сканнер
             FileOutputStream fos = new FileOutputStream(scanner.nextLine()))  //  создаем для записи в файл,которые принимаем с консоли
              {
            byte[] bytes = new byte[]{106, 97, 118, 97};  //  массив байтов
            fos.write(bytes);  // записываем массив в файл
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}