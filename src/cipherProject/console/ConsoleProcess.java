package cipherProject.console;

import cipherProject.FileManager;
import cipherProject.cipher.CaesarCipher;
import cipherProject.service.CaesarService;
import cipherProject.exception.FileManagerException;
import cipherProject.exception.AlphabetException;
import cipherProject.alphabets.RuAlphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ConsoleProcess {
    //  приветсвие,опции,обработать исключения
    //  при вызове цезарьсервиса егт обернуть в трайкэтч
    private final CaesarService caesarService;
    private final RuAlphabet ruAlphabet;
    private final FileManager fileManager;

    private static final String INPUT_FILE = "src/cipherProject/files/text.txt";
    private static final String ENCRYPT_FILE = "src/cipherProject/files/encrypt.txt";
    private static final String DECRYPT_FILE = "src/cipherProject/files/decrypt.txt";


    public ConsoleProcess() {
        this.caesarService = new CaesarService();
        this.ruAlphabet = new RuAlphabet();
        this.fileManager = new FileManager();
    }


    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("🔐 Добро пожаловать в программу шифрования Цезаря!");
            System.out.println("Поддерживается русский алфавит и знаки препинания\n");
            System.out.println("Используемые файлы:");
            System.out.println("  📄 Исходный файл: " + INPUT_FILE);
            System.out.println("  🔒 Зашифрованный: " + ENCRYPT_FILE);
            System.out.println("  🔓 Расшифрованный: " + DECRYPT_FILE);
            System.out.println();
            while (true) {
                System.out.println("\"\uD83D\uDD10 ШИФР ЦЕЗАРЯ\"");
                System.out.println("1. Шифровать файл");
                System.out.println("2. Расшифровать файл");
                System.out.println("3. Brute force (перебор всех ключей)");
                System.out.println("4. Выйти");
                System.out.print("Выберите действие (1-4): ");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        encryptFile(scanner);
                        break;
                    case "2":
                        decryptFile(scanner);
                        break;
                    case "3":
                        bruteForce(scanner);
                        break;
                    case "4":
                        System.out.println("До свидания!");
                        return;  // Выходим из метода start
                    default:
                        System.out.println("Ошибка! Введите число от 1 до 4");
                }

                System.out.println(); // Пустая строка для разделения
            }
        }
    }

    private void encryptFile(Scanner scanner) {   //  шифрование файла
        System.out.println("\n--- Шифрование ---");
        System.out.println("Читаю файл: " + INPUT_FILE);

        try {
            // Запрашиваем данные у пользователя

            System.out.print("Введите ключ (целое число): ");
            int key = Integer.parseInt(scanner.nextLine());

            // Выполняем шифрование
            caesarService.enCrypt(INPUT_FILE, ENCRYPT_FILE, key, false);

            System.out.println("Готово! Файл зашифрован.");

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: ключ должен быть числом!");
        } catch (FileManagerException | AlphabetException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void decryptFile(Scanner scanner) {  //  расшифровка файла
        System.out.println("\n--- Расшифровка ---");
        System.out.println("Читаю файл: " + ENCRYPT_FILE);

        try {
            System.out.print("Введите ключ (целое число): ");
            int key = Integer.parseInt(scanner.nextLine());

            // Выполняем расшифровку
            caesarService.deCrypt(ENCRYPT_FILE, DECRYPT_FILE, key, true);

            System.out.println("Готово! Файл расшифрован.");

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: ключ должен быть числом!");
        } catch (FileManagerException | AlphabetException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Подбор ключа
    private void bruteForce(Scanner scanner) {
        System.out.println("\n--- Подбор ключа ---");
        System.out.println("Читаю зашифрованный файл: " + ENCRYPT_FILE);

        try {
            // Читаем файл encrypt.txt
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = fileManager.readFile(ENCRYPT_FILE)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            int alphabetSize = ruAlphabet.getSize();
            System.out.println("Размер алфавита: " + alphabetSize);
            System.out.println("Начинаю перебор ключей от 0 до " + (alphabetSize - 1));
            System.out.println();

            // Перебираем все ключи
            for (int key = 0; key < alphabetSize; key++) {
                System.out.println("=== Ключ " + key + " ===");

                // Расшифровываем каждую строку
                CaesarCipher cipher = new CaesarCipher(ruAlphabet);
                StringBuilder decryptedText = new StringBuilder();

                for (String line : lines) {
                    String decrypted = cipher.deCrypt(line, key);
                    decryptedText.append(decrypted).append("\n");
                    System.out.println(decrypted);
                }

                System.out.println();
                System.out.print("Этот текст похож на русский? (да/нет/выход): ");
                String answer = scanner.nextLine().toLowerCase();

                switch (answer) {
                    case "да":
                    case "yes":
                    case "y":
                        System.out.println("✅ Найден ключ: " + key);

                        // Спрашиваем про сохранение
                        System.out.print("Сохранить результат в " + DECRYPT_FILE + "? (да/нет): ");
                        String save = scanner.nextLine().toLowerCase();

                        if (save.equals("да") || save.equals("yes") || save.equals("y")) {
                            // Сохраняем в decrypt.txt
                            try (java.io.BufferedWriter writer = new java.io.BufferedWriter(
                                    new java.io.FileWriter(DECRYPT_FILE))) {
                                writer.write(decryptedText.toString());
                                System.out.println("✅ Результат сохранен в: " + DECRYPT_FILE);
                            } catch (java.io.IOException e) {
                                System.out.println("❌ Ошибка при сохранении: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Результат не сохранен.");
                        }
                        return;

                    case "выход":
                    case "exit":
                    case "q":
                        System.out.println("Поиск прерван.");
                        return;

                    default:
                        System.out.println("Пробуем следующий ключ...\n");
                }
            }

            System.out.println("Подходящий ключ не найден.");

        } catch (FileManagerException | AlphabetException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}/////
