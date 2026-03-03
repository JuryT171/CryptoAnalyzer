package com.javarush.task.pro.task15.task1524;

import java.io.*;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in); // добавляем сканнер
        String path = scanner.nextLine(); // считываем с консоли путь к файлу
        String path1 = scanner.nextLine();

        try (FileInputStream inputStream = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream(path1)){

            byte[] bytesIn = inputStream.readAllBytes();  // считываем все байты с входного потока
            byte[] bytesOut = new byte[bytesIn.length];  //  создаем массив той же длины что и входной поток

            for (int i = 0; i < bytesIn.length; i += 2) {  //  проходимся по массиву с шагом 2 (пары)
                if (i < bytesIn.length - 1) {  //  проверяем чтобы байт был не последним
                    bytesOut[i] = bytesIn[i + 1];  // меняем байты местами
                    bytesOut[i + 1] = bytesIn[i];
                } else {
                    bytesOut[i] = bytesIn[i];  // нечётный байт не трогаем
                }
            }
            outputStream.write(bytesOut);  //  записываем массив
        }
    }
}