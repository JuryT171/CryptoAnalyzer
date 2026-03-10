package com.javarush.task.pro.task15.task1539;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Использование Paths
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(joinToPath(Arrays.asList("d:/", "study/", "javarush/", "полезные куски кода.txt")));
    }

    public static Path joinToPath(List<String> partsList) {
        //напишите тут ваш код
        List<String> nonEmptyParts = new ArrayList<>(); //  создаем массив для значений пути
        for (String part : partsList) {
            if (part != null && !part.isEmpty()) { // проверяем, что строка не является пустой
                nonEmptyParts.add(part);
            }
        }
        String[] partsArray = nonEmptyParts.toArray(new String[0]);

        return Paths.get(partsArray[0], Arrays.copyOfRange(partsArray, 1, partsArray.length));
    }
}
