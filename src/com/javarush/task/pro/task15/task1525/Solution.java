package com.javarush.task.pro.task15.task1525;

import java.io.*;
import java.util.Scanner;

/* 
Что-то не копируется...
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fis = new FileInputStream(scanner.nextLine());
             FileOutputStream fos = new FileOutputStream(scanner.nextLine())) {
            int size = 1024;
            byte[] buffer = new byte[size];  //  создаем массив
            while (fis.available() > 0) {  // работаем пока есть байты для чтения
                int read = fis.read(buffer);  //  считываем байты
                fos.write(buffer, 0, read);  // записываем байты из буфера в выходной поток
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}