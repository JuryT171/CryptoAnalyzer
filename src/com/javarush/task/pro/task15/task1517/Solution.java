package com.javarush.task.pro.task15.task1517;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файловые операции
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Path.of(scanner.nextLine());
        Path fileNewPath = Path.of(scanner.nextLine());
        //напишите тут ваш код
        if(Files.exists(filePath)== false){  //  если файла 1 нет - создаем его
            Files.createFile(filePath);
        } else if (Files.exists(fileNewPath)== false) {  // если файла 2 нет - копируем из 1го во 2й
            Files.move(filePath,fileNewPath);
        }else {
            Files.delete(filePath);  //или удаляем 1й
        }
    }
}

