package com.javarush.task.pro.task15.task1527;

import java.io.*;
import java.util.Scanner;

/* 
 Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try (Scanner scanner = new Scanner(System.in);  //создаем сканнер
             FileReader in = new FileReader(scanner.nextLine());  // передаем в файл ридер считанное со сканера имя
             BufferedReader reader = new BufferedReader(in)) { //  передаем в буффер
            int counter = 0;  // создаем счетчик
            while (reader.ready()) {  // цикл по буфферы,пока в нем есть данные
                String line = reader.readLine(); // считываем каждую строку
                if (counter % 2 == 0) {  //  четную строку выводим на экран
                    System.out.println(line);
                }
                counter++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}