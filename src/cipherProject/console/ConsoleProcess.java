package cipherProject.console;

import cipherProject.cipher.CaesarCipher;
import cipherProject.service.CaesarService;

import java.util.Scanner;

public class ConsoleProcess {
    //  приветсвие,опции,обработать исключения
    //  при вызове цезарьсервиса егт обернуть в трайкэтч
    public void start(){
        try (Scanner scanner = new Scanner(System.in)){
            while (true){
                System.out.println("\"\uD83D\uDD10 ШИФР ЦЕЗАРЯ\"");
                System.out.println("1. Шифровать файл");
                System.out.println("2. Расшифровать файл");
                System.out.println("3. Brute force (перебор всех ключей)");
                System.out.println("4. Выйти");
                System.out.print("Выберите действие (1-4): ");

                try{
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            System.out.print("Введите ключ шифрования (число): ");
                            int encryptKey = Integer.parseInt(scanner.nextLine());
                            CaesarCipher.
                    }
                }
            }
        }
    }
}
