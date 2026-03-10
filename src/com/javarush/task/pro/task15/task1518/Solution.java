package com.javarush.task.pro.task15.task1518;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
А что же внутри папки?
*/

public class Solution {

    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path directory = Path.of(scanner.nextLine());
        //напишите тут ваш код
        try {
            DirectoryStream<Path> files = Files.newDirectoryStream(directory);  //  создаем поток данных хранящий директории
            for(Path path : files){  // цикл по содержимому
                if(Files.isRegularFile(path)){  //  если это файл
                    System.out.println(path+THIS_IS_FILE);
                } else if (Files.isDirectory(path)){  // если директория
                    System.out.println(path+THIS_IS_DIR);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

