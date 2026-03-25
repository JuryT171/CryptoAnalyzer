package cipherProject.alphabets;

import cipherProject.exception.AlphabetException;

import java.util.*;

public class RuAlphabet {
    private static final Character[] RU_CHARACTERS = {
            'а', 'б',
            'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я'
    };
    private static final Character[] SYMBOLS = {
            '.', ',', '«', '»',
            ':', '!', '?', ' ','\'', '"'
    };

    private final List<Character> characterList;
    private final Map<Character, Integer> characterIntegerMap;

    public RuAlphabet(){  //  конструктор
        this.characterList = new ArrayList<>();    //  создаем аррайлист
        this.characterList.addAll(Arrays.asList(RU_CHARACTERS));  //  помещаем алфавит
        this.characterList.addAll(Arrays.asList(SYMBOLS));  //  помещаем символы

        this.characterIntegerMap = new HashMap<>(); // создаем мапу
        for (int i = 0; i < this.characterList.size(); i++) {  //  проходимся циклом
            characterIntegerMap.put(characterList.get(i),i);  //  заносим значение и индекс
        }
    }

    public int getSize(){  //  размер

        return characterList.size();
    }

    public Character getCharByIndex(int index){ //  метод для получения символа по индексу
        if (index <0 || index >= characterList.size()){
            throw new AlphabetException("Некорректный индекс символа "+ index+
                    ".Допустимое значение индекса от 0 до "+(characterList.size()-1));
        }
        return characterList.get(index);
    }
    public int getIndexByChar (Character character){  //  получаем индекс по символу
        Integer integer = characterIntegerMap.get(character);  // get получает индекс
        if (integer == null){  //  если символ отсутствует в алфавите
            throw new AlphabetException("Введен некорректный символ "+ character);
        }
        return integer;
    }
}
