package com.javarush.task.pro.task15.task1526;

import java.io.*;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);  //создаем сканнер
        String path = scanner.nextLine();  //  записываем путь к файлу
        try {
            FileReader fileReader = new FileReader(path);  //  создаем ридер
            int character;  //  вводим переменную
            while ((character = fileReader.read()) != -1) { // Читаем по одному символу до конца файла
                char c = (char) character;  //преобразуем инт в чар
                if (c != '.' && c != ',' && c != ' ') { // Проверяем на символы
                    System.out.print(c);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }
}