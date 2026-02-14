package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Юрий Гагарин", 5.0);  //  с помощью метода put добавляем объект в мапу
        grades.put("Юрий Деточкин", 4.6);
        grades.put("Юрий Пригожин", 4.2);
        grades.put("Юрий Башмет", 3.3);
        grades.put("Юрий Марков", 4.4);

    }
}
