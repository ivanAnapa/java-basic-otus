package ru.otus.homeworks.lesson20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Реализуйте приложение, позволяющее работать с текстовыми файлами
 * При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
 * Далее программа запрашивает имя файла, с которым хочет работать пользователь
 * Содержимое файла выводится в консоль
 * Затем любую введенную пользователем строку необходимо записывать в указанный файл
 */
public class MyApp {
    private static File file1 = new File("file1.txt");
    private static File file2 = new File("file2.csv");
    private static File file3 = new File("file3.json");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список файлов: \n" + file1.getName() + "\n" + file2.getName() + "\n" + file3.getName());

        System.out.println("Введите название и формат файла, с которым хотите работать:");
        String selectedFileName = scanner.nextLine();
        if (selectedFileName.equals(file1.getName())) {
            printFile(file1);
            System.out.println("\nВведите текст, который нужно добавить в файл:");
            writeNewRowToTxtFile(new Scanner(System.in).nextLine());
            printFile(file1);
        } else if (selectedFileName.equals(file2.getName())) {
            printFile(file2);
            System.out.println("\nВведите текст, который нужно добавить в файл:");
            writeToCsvFile(new Scanner(System.in).nextLine());
            printFile(file2);
        } else if (selectedFileName.equals(file3.getName())) {
            printFile(file3);
            System.out.println("\nВведите текст, который нужно добавить в JSON файл в качестве ключа:");
            String key = new Scanner(System.in).nextLine();
            System.out.println("Введите текст, который нужно добавить в JSON файл в качестве значения:");
            String value = new Scanner(System.in).nextLine();
            Map<String, String> map = new HashMap<>();
            map.put(key, value);
            writeToJsonFile(map);
            printFile(file3);
        } else {
            System.out.println("Неверно указано название файла");
        }


    }

    private static void printFile(File file) {
        System.out.println("\nСодержимое выбранного файла " + file.getName() + ":");
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             InputStreamReader inr = new InputStreamReader(bis)) {
            int n = inr.read();
            while (n != -1) {
                System.out.print((char) n);
                n = inr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private static void writeNewRowToTxtFile(String textForAddition) {
        // Для текстового файла дописываем с новой строки введенный текст из консоли
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1, true))) {
            writer.newLine();
            writer.write(textForAddition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToCsvFile(String textForAddition) {
        try (FileInputStream fis = new FileInputStream(file2)) {
            // Есди в csv файле есть записи, то добавляем разделитель с пробелом
            if (fis.read() != -1) {
                try (FileOutputStream out = new FileOutputStream(file2, true)) {
                    out.write(", ".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Дописываем в ту же строку введенный текст из консоли
            try (FileOutputStream out = new FileOutputStream(file2, true)) {
                byte[] buffer = textForAddition.getBytes(StandardCharsets.UTF_8);
                out.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToJsonFile(Map<String, String> map) {
        String textForAddition = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            textForAddition = "  \"" + entry.getKey() + "\": \"" + entry.getValue() + "\"";
        }
        try (
                FileInputStream fis = new FileInputStream(file3);
                BufferedInputStream bis = new BufferedInputStream(fis);
                InputStreamReader inr = new InputStreamReader(bis)) {
            /* Есди в JSON файле есть записи, то переписываем файл:
             1. Вычитываем файл
             2. Удаляем закрывающую фигурную скобку
             3. Добавляем запятую к имеющемуся тексту
             4. Добавляем в новую строку запись
             5. Добавляем закрывающую фигурную скобку в новую строку запись
             */
            if (inr.read() != -1) {
                String tmp = new BufferedReader(inr).lines().collect(Collectors.joining("\n"));
                String fileChanged = tmp.substring(0, tmp.length() - 2) + ","; // Удаление "}", переноса строки и добавление запятой
                try (FileWriter fw = new FileWriter(file3, false)) {
                    fw.write(""); // "Обнуление" файла
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file3, true))) {
                    writer.write("{");
                    writer.write(fileChanged);
                    writer.newLine();
                    writer.write(textForAddition);
                    writer.newLine();
                    writer.write("}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Есди в JSON файле нет записей, то добавляем "{" в первую строку и "}" в последннюю, а между ними текст
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file3, true))) {
                    writer.write("{");
                    writer.newLine();
                    writer.write(textForAddition);
                    writer.newLine();
                    writer.write("}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
