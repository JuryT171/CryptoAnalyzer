package com.javarush.task.pro.task15.task1502;

import java.util.Scanner;

/* 
Возврат к истокам
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;  //  вынесли переменную сканнер
        try {
            scanner = new Scanner(System.in);  //  переопределили
            String line = scanner.nextLine();
            System.out.println(line.toUpperCase());

        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        } finally {
            scanner.close();  //  закрыли сканнер
        }
    }
}
