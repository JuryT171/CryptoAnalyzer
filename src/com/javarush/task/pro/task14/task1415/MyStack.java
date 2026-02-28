package com.javarush.task.pro.task14.task1415;

import java.util.LinkedList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new LinkedList<>();

    public void push(String s) {
        //напишите тут ваш код
        storage.add (0, s);  //  всиавляем элемент в начало
    }

    public String pop() {
        //напишите тут ваш код
        String result = storage.get(0);  //  получаем первый элемент
        storage.remove(0);  //  удаляем
        return result;
    }

    public String peek() {
        //напишите тут ваш код
        String result = storage.get(0);  //  получаем 1й элемент
        return result;
    }

    public boolean empty() {
        //напишите тут ваш код
        return storage.isEmpty();  //  проверяем на пустоту
    }

    public int search(String s) {
        //напишите тут ваш код
        int index = storage.indexOf(s);  // ищем индекс обьекта
        return index;
    }
}
