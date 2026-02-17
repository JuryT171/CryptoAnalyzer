package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement != null) && (currentElement != last)) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код
        Node newNode = new Node();  //   создаем новую ноду

        if (first.next != null) {  //  проверяем что первый нод не равен null
            Node preNewNode = last.prev;  // получаем предыдущий последний нод
            preNewNode.next = newNode;  //  предидущий ссылается на новый
            newNode.prev = preNewNode;  //  новая нода ссылается на предидущую
        } else {
            first.next = newNode; // 1я нода ссылаетрся на последнюю новую
            newNode.prev=first;  //  еновая ссылается на предидущую, 1ю
        }
        newNode.value = value;  //  присваиваем ей значение
        newNode.next = last;  //  новая нода ссылается на последний элемент
        last.prev = newNode; //  последний элемент ссылается на новый,т.к он стал последним
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
