package cipherProject.validator;

import cipherProject.exception.FileManagerException;

import java.nio.file.*;
import java.util.List;
import java.util.regex.Pattern;

public class FileValidator {
    private static final List <String> FORBIDDEN_DIR_FILES = List.of(".bash_history","bash_profile",
            ".bashrc","etc","proc","System","Library", "Users","Applications");  //  список запрещенки

    public void validateForReading (String fileName){
        Path path = validatePath(fileName);  // проходим проверку

        if (!Files.exists(path)){  // если файл не существует
            throw new FileManagerException("Файл " + fileName + " не найден");
        }
        if (Files.isDirectory(path)){  // если это директория
            throw new FileManagerException("Указана директория " + fileName + ". Введите имя файла");
        }
        if (!Files.isReadable(path)){  // есть ли разрешение
            throw new FileManagerException("Нет разрешения на чтение файла " + fileName);
        }
    }
    public void validateForWriting (String fileName){
        Path path = validatePath(fileName); //  проходим проверку

        if (Files.exists(path)){  //  существует ли файл
            if(Files.isDirectory(path)){  //  существует ли директория
                throw new FileManagerException("Невозможно записать в директорию: "+ fileName);
            }
            if(!Files.isReadable(path)){  //  есть ли разрешение
                throw new FileManagerException("Нет разрешения на запись в файл: "+fileName);
            }
        }
    }

    //  проверяем введенный путь на корректность
    public Path validatePath (String filename){
        String separator = Pattern.quote(FileSystems.getDefault().getSeparator()); //  получаем разделитель
        for (String line : filename.split(separator)){  //  проходимся циклом
            if(FORBIDDEN_DIR_FILES.contains(line)){  // если введенный путь содержит, что то из запрещенного списка
                throw new FileManagerException("Некорректен введенный путь" + line);
            }
        }
        try {
            return Path.of(filename); // если все ок, возвращаем объект Path
        } catch (InvalidPathException e){
            throw new FileManagerException("некорректный путь"+filename+e);
        }
    }
}
