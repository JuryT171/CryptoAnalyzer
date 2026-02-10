package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        //напишите тут ваш код
        int countDigits=0;   //  счетчик
        char[] array = string.toCharArray();   //  создаем массив из строки преобразуя в чар
        for (int i = 0; i < string.length(); i++) {  //  проверяем массив
            if(Character.isDigit(array[i])){  //  если  в элементах есть цифры
                countDigits++;  // прибавляем счетчик
            }
        }
        return countDigits;  //  возвращаем счетчик
    }

    public static int countLetters(String string) {
        //напишите тут ваш код
        int countLetters = 0;
        char[] array = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if(Character.isLetter(array[i])){
                countLetters++;
            }
        }
        return countLetters;
    }

    public static int countSpaces(String string) {
        //напишите тут ваш код
        int countSpaces = 0;
        char [] array = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isSpaceChar(array[i])){
                countSpaces++;
            }
        }
        return countSpaces;
    }
}
