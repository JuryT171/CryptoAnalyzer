package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        JavarushQuest [] quests = JavarushQuest.values();  //  получаем массив констант класса енум
        for (JavarushQuest arrayQuest:quests ){  //  проходимся циклом
            System.out.println(arrayQuest.ordinal());  //  выводим на экран порядковые номера
        }
    }
}
