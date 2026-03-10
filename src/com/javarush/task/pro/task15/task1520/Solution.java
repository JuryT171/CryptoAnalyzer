package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перемещение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        //напишите тут ваш код
        try (DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) { //  создаем поток для итерции путей 1
            for (Path path : files){  //  цикл
                if(Files.isRegularFile(path)){  //  проверяем является ли элемент файлом
                    Path resolve = targetDirectory.resolve(path.getFileName()); //  создаем полный путь к файлу, прикрепляя имя
                    Files.move(path,resolve); // перемещаем файл
                }
            }
        }
    }
}

