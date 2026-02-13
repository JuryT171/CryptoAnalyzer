package com.javarush.task.pro.task13.task1301;

import java.util.Collections;
import java.util.HashSet;

/* 
Оформляем возврат
*/

public class Solution {
    public static void main(String[] args) {
        String[] array = {"Через", "три", "года", "я", "буду", "Senior", "Java", "Developer"};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("___________________________________");

        HashSet<String> hashSet = arrayToHashSet(array);
        for(String s : hashSet) {
            System.out.println(s);
        }
    }

    public static HashSet<String> arrayToHashSet(String[] strings) {
        //напишите тут ваш код
        HashSet<String>resultHashSet = new HashSet<>(); // создаем пустой хэшсет
        for (String str:strings){  // проходимся циклом по входному массиву Strings
            resultHashSet.add(str);  //  вставляем в новый массив элементы старого
        }
        return resultHashSet;  //  возвращаем новый массив

        /*
           HashSet<String> ResultHashSet = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            ResultHashSet.add(strings[i]);
        }
        return ResultHashSet;
    }
         */
    }
}
