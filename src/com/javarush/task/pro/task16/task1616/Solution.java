package com.javarush.task.pro.task16.task1616;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        //напишите тут ваш код
        Set<String> allZones = ZoneId.getAvailableZoneIds();  //  получаем все зоны
        TreeSet<String>sortedZones = new TreeSet<>(allZones);  //  treeSet
        return sortedZones;
    }

    static ZonedDateTime getBeijingDateTime() {
        //напишите тут ваш код
        ZoneId beijingDate = ZoneId.of("Asia/Shanghai");  //  получаем временную зону
        ZonedDateTime dateTime = ZonedDateTime.now(beijingDate);  //  объект с текущим временем
        return dateTime;
    }
}
