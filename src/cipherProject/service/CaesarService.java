package cipherProject.service;

import cipherProject.FileManager;
import cipherProject.alphabets.RuAlphabet;
import cipherProject.cipher.CaesarCipher;
import cipherProject.exception.FileManagerException;
import cipherProject.validator.FileValidator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class CaesarService {
    FileManager fileManager;
    FileValidator fileValidator;
    CaesarCipher caesarCipher;

    public CaesarService(){
        this.fileManager = new FileManager();
        this.fileValidator = new FileValidator();
        this.caesarCipher = new CaesarCipher(new RuAlphabet());
    }

        //  вызываем их в главном меню
    public void enCrypt (String inputFile, String outputFile, int key, boolean decryptFlag){
        process(inputFile,outputFile,key,decryptFlag);
    }
    public void deCrypt (String inputFile, String outputFile, int key, boolean decryptFlag){
        process(inputFile,outputFile,key,decryptFlag);
    }


    public void process(String inputFile, String outputFile, int key, boolean decryptFlag){
        fileValidator.validateForReading(inputFile);  //  проверяем файлы
        fileValidator.validateForWriting(outputFile);

        try (BufferedReader reader = fileManager.readFile(inputFile);
             BufferedWriter writer = fileManager.openWriter(outputFile)) {

            String line;
            int lineCount = 0;

            // Читаем файл построчно
            while ((line = reader.readLine()) != null) {
                String processedLine;

                // Обрабатываем строку в зависимости от флага
                if (!decryptFlag) {
                    processedLine = caesarCipher.enCrypt(line, key);
                } else {
                    processedLine = caesarCipher.deCrypt(line, key);
                }

                // Записываем обработанную строку
                writer.write(processedLine);
                writer.newLine();

                lineCount++;
            }

        } catch (IOException e) {
            throw new FileManagerException("Произошла ошибка записи в файл "+outputFile+e);
        }
    }
} /////kkk
