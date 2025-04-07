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
 * <p>
 * Для txt файла дописываем с новой строки введенный текст из консоли
 * Для csv файла дописываем в существующую строку введенный текст из консоли, предварительно добавив "," + "пробел"
 * Для json файла дописываем с новой строки строкю введенный текст из консоли в формате "ключ": "значение". Если запись не первая, то к предыдущей строке добавляем ","
 */
public class MyApp {
    private static final String filesDir = "files";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File folder = new File(filesDir);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            System.out.println("Список существующих файлов:");
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    System.out.println("- " + listOfFile.getName());
                }
            }
        } else {
            System.out.println("Файлов нет, каталог пуст");
        }

        System.out.println("Введите название и формат файла, с которым хотите работать:");
        String selectedFileName = filesDir + "/" + scanner.nextLine();
        if (viewFileByPath(selectedFileName)) {
            String selectedFileFormat = selectedFileName.substring(selectedFileName.indexOf(".") + 1);
            File file = new File(selectedFileName);
            switch (selectedFileFormat) {
                case "txt":
                    System.out.println("\nВведите текст, который нужно добавить в файл:");
                    writeNewRowToTxtFile(selectedFileName, new Scanner(System.in).nextLine());
                    printFile(file);
                    break;
                case "csv":
                    System.out.println("\nВведите текст, который нужно добавить в файл:");
                    writeToCsvFile(selectedFileName, new Scanner(System.in).nextLine());
                    printFile(file);
                    break;
                case "json":
                    System.out.println("\nВведите текст, который нужно добавить в JSON файл в качестве ключа:");
                    String key = new Scanner(System.in).nextLine();
                    System.out.println("Введите текст, который нужно добавить в JSON файл в качестве значения:");
                    String value = new Scanner(System.in).nextLine();
                    Map<String, String> map = new HashMap<>();
                    map.put(key, value);
                    writeToJsonFile(selectedFileName, map);
                    printFile(file);
                    break;
                default:
                    System.out.println("Такого формата не планировалось :)");
            }
        } else {
            System.out.println("Файла не существует и создавать его мы не стали");
        }
    }

    private static boolean viewFileByPath(String filepath) {
        File file = new File(filepath);
        boolean isFileExists = false;
        if (file.isFile()) {
            printFile(file);
            isFileExists = true;
        } else if (!file.exists()) {
            System.out.println("Указанного файла не существует. Создать его? (Y / N)");
            Scanner scanner = new Scanner(System.in);
            String needToCreate = scanner.nextLine();
            switch (needToCreate) {
                case "Y":
                    try (FileWriter fw = new FileWriter(file)) {
                        fw.write("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Файл " + filepath + " создан");
                    printFile(file);
                    isFileExists = true;
                    break;
                case "N":
                    System.out.println("Файл не создан");
                    break;
            }
        }
        return isFileExists;
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

    private static void writeNewRowToTxtFile(String fileNameAndFormat, String textForAddition) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameAndFormat, true))) {
            writer.newLine();
            writer.write(textForAddition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToCsvFile(String fileName, String textForAddition) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            if (fis.read() != -1) {
                try (FileOutputStream out = new FileOutputStream(fileName, true)) {
                    out.write(", ".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (FileOutputStream out = new FileOutputStream(fileName, true)) {
                byte[] buffer = textForAddition.getBytes(StandardCharsets.UTF_8);
                out.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToJsonFile(String fileName, Map<String, String> map) {
        String textForAddition = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            textForAddition = "  \"" + entry.getKey() + "\": \"" + entry.getValue() + "\"";
        }
        try (
                FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);
                InputStreamReader inr = new InputStreamReader(bis)) {
            if (inr.read() != -1) {
                String tmp = new BufferedReader(inr).lines().collect(Collectors.joining("\n"));
                String fileChanged = tmp.substring(0, tmp.length() - 2) + ","; // Удаление "}", переноса строки и добавление запятой
                try (FileWriter fw = new FileWriter(fileName, false)) {
                    fw.write(""); // "Обнуление" файла
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
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
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
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
