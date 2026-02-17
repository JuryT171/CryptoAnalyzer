package com.javarush.task.pro.task13.task1314;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void add(String value) {
        Node newNode = new Node();
        newNode.value = value;

        Node prevLast = last.prev;
        prevLast.next = newNode;
        newNode.prev = prevLast;
        newNode.next = last;
        last.prev = newNode;
    }

    public String get(int index) {
        //напишите тут ваш код
        if (index < 0) {
            return null; // Отрицательные индексы недопустимы
        }

        Node current = first.next;
        int currentIndex = 0;


        while (current != last && currentIndex < index) {  // проходимся по списку
            current = current.next;
            currentIndex++;
        }


        if (current == last) {   //  если дошли до последнего, возвращаем null
            return null;
        } else {

            return current.value;  //  возвращаем нужный индекс
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
