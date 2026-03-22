package cipherProject.service;

import cipherProject.FileManager;
import cipherProject.alphabets.RuAlphabet;
import cipherProject.cipher.CaesarCipher;
import cipherProject.exception.FileManagerException;
import cipherProject.validator.FileValidator;

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
    public void enCrypt (String inputFail, String outputFile, int key, boolean decryptFlag){
        process(inputFail,outputFile,key,decryptFlag);
    }
    public void deCrypt (String inputFail, String outputFile, int key, boolean decryptFlag){
        process(inputFail,outputFile,key,decryptFlag);
    }


    public void process(String inputFail, String outputFile, int key, boolean decryptFlag){
        fileValidator.validateForReading(inputFail);  //  проверяем файлы
        fileValidator.validateForWriting(outputFile);

        List<String>readLines = fileManager.readFile(inputFail);  //  считываем файл
        List<String>result = new ArrayList<>();

        for(String s : readLines){  // цикл для считанных строк
            if (!decryptFlag){  //  если тру, шифруем
                result.add(caesarCipher.enCrypt(s,key));
            } else{  //  если не тру, расшифровываем
              result.add(caesarCipher.deCrypt(s,key));
            }
        }
        try (BufferedWriter bufferedWriter = fileManager.openWriter(outputFile)){
            for( String s : result) {  //  цикл по считанному, обработанному тексту
                bufferedWriter.write(s);  //  записываем считанное
                bufferedWriter.newLine(); //  перенос строки
            }
        } catch (IOException e) {
            throw new FileManagerException("Произошла ошибка записи в файл "+outputFile+e);
        }
    }
}
