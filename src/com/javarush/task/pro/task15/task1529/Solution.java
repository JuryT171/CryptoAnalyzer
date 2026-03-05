package com.javarush.task.pro.task15.task1529;

import java.io.*;
import java.util.Scanner;

/* 
Пишем символы в файл
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);  // сканнер
             FileWriter fileWriter = new FileWriter(scanner.nextLine())) {  // создаем врайтер для записи чаров(символов)
            char[] chars = new char[]{'j', 'a', 'v', 'a'};  //  массив символов
            for (char aChar : chars) {  // цикл по массиву
                fileWriter.write(aChar);  //записываем символы
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}