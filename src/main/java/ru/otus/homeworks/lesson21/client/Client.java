package ru.otus.homeworks.lesson21.client;

import ru.otus.homeworks.lesson21.util.ExampleClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8081)) {
                ExampleClient client = new ExampleClient(socket.getInputStream(), socket.getOutputStream());
                System.out.println("Введи число 1:");
                String clientInput = scanner.nextLine() + " ";
                System.out.println("Введи число 2:");
                clientInput += scanner.nextLine() + " ";
                System.out.println("Введи оператор:");
                clientInput += scanner.nextLine();
                if (clientInput.contains("exit")) {
                    client.send("exit");
                    break;
                }
                client.send(clientInput);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}