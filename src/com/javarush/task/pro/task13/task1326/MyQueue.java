package com.javarush.task.pro.task13.task1326;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyQueue extends AbstractQueue<String> {

    private final List<String> values = new ArrayList<>();

    @Override
    public Iterator<String> iterator() {
        //напишите тут ваш код

        return values.iterator();  // возвращаем итератор
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values.size();  //  возвращаем размер
    }

    @Override
    public boolean offer(String o) {
        //напишите тут ваш код
        values.add(o);  //добавляем новый элемент
        return true;
    }

    @Override
    public String poll() {
        if (values.size() > 0) {  //   если список больше 0
            return values.remove(0);  //  удалем первый объект
        } else {
            return null;
        }
        //напишите тут ваш код
    }

    @Override
    public String peek() {
        if (values.size() > 0) {
            return values.get(0);  //  если список больше 0 получаем первый элемент
        } else {
            return null;
        }
        //напишите тут ваш код
    }
}
