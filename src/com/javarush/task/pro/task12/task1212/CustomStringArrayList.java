package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишите тут ваш код
        capacity = (int) (capacity*1.5);  //  значение вместимости нового массива
        String [] result = new String[capacity];  // создали новый массив с новой вместимостью
        for (int i = 0; i < elements.length; i++) {  // прошлись циклом
            result[i]= elements[i];  // записали значения в новый массив
        }
        elements = result;  //  присвоили старому объекту новую ссылку
    }
}
