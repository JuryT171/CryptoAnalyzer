package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //напишите тут ваш код
        boolean abs = Path.of(str).isAbsolute();  // проверряем на абсолютный путь
        if(abs) {  //  если абсолютный - выводим
            System.out.println(str);
        }else{  // если нет то преобразуем к абсолютному
            Path path = Path.of(str).toAbsolutePath();
            System.out.println(path);
        }

    }
}

