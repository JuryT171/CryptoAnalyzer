package cipherProject.cipher;

import cipherProject.alphabets.RuAlphabet;


public class CaesarCipher {
    private final RuAlphabet ruAlphabet;

    public CaesarCipher(RuAlphabet ruAlphabet){
        this.ruAlphabet = ruAlphabet;
    }

    public String enCrypt(String text, int key){   //  метод шифрования
        String result ="";  // пустая строка для склейки
        int alphabetSize = ruAlphabet.getSize();  //  разммер алфавита

        for (int i = 0; i < text.length(); i++) {  // проходимся циклом по тексту
            char c = Character.toLowerCase(text.charAt(i));  //  получаем символы
            int indexOriginalChar = ruAlphabet.getIndexByChar(c); //  получаем индекс с помощью метода гетиндекс
            int newIndex = (indexOriginalChar + key) % alphabetSize; //  формула шифровки
            if (newIndex<0){
                newIndex=newIndex+alphabetSize;  //  если индекс меньше нуля прибавляем размер алфавита
            }
            char newChar = ruAlphabet.getCharByIndex(newIndex);  // находим символ по индексу
            result = result+newChar; // заносим его в строку
        }
        return result;
    }

    public String deCrypt(String text, int key){   //  метод расшифровки
        String result ="";  // пустая строка для склейки
        int alphabetSize = ruAlphabet.getSize();  //  разммер алфавита

        for (int i = 0; i < text.length(); i++) {  // проходимся циклом по тексту
            char c = Character.toLowerCase(text.charAt(i));  //  получаем символы
            int indexOriginalChar = ruAlphabet.getIndexByChar(c); //  получаем индекс с помощью метода гетиндекс
            int newIndex = (indexOriginalChar - key) % alphabetSize;  //формула получения индекса для расшифровки
            if (newIndex<0){
                newIndex=newIndex+alphabetSize;  //  если индекс меньше нуля прибавляем размер алфавита
            }
            char newChar = ruAlphabet.getCharByIndex(newIndex);  // находим символ по индексу
            result = result+newChar; // заносим его в строку
        }
        return result;
    }
}
