package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        //напишите тут ваш код
        Set<LocalDateTime> result = new HashSet<>();  // результирующая мапа

        for (Map.Entry<LocalDate, List<LocalTime>> entry : sourceMap.entrySet()) { // проходимся циклом
            LocalDate date = entry.getKey();  // получаем дату
            List<LocalTime> times = entry.getValue();  //  список времени

            for (LocalTime time : times) {  //  перебираем объекты times
                LocalDateTime dateTime = LocalDateTime.of(date, time);  //  объединяем все в 1 объект
                result.add(dateTime);
            }
        }

        return result;
    }


    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}