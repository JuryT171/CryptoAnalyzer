package cipherProject;

import cipherProject.exception.FileManagerException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileManager {
    // метод для чтения файла
    // сделать метод для работы с большими файлами??
    public List<String> readFile (String fileName){

        try{
            Path path = Path.of(fileName);  //  создаем объект
            return Files.readAllLines(path);     //  считываем объект с файлом
        } catch (IOException | InvalidPathException e) {
            throw new FileManagerException(e.getMessage(), e);
        }
    }
    //  метод для записи файла
    public BufferedWriter openWriter(String fileName){
        try{
            Path path = Path.of(fileName); //  создаем объект
            return Files.newBufferedWriter(path, StandardCharsets.UTF_8);  //создаем файл, записываем в него то что в буффере
        } catch (IOException | InvalidPathException e){
            throw new FileManagerException(e.getMessage(), e);
        }
    }
}
