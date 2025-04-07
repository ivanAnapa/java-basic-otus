package ru.otus.homeworks.lesson21.server;

import ru.otus.homeworks.lesson21.calcExecutor.CalcExecutor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Сервер: выполняет математические вычисления: +,-,*,/
 * Клиент-серверное взаимодействие:
 * клиент подключается к серверу, получает строку с доступными мат. операциями. Отображает ее пользователю.
 * пользователь вводит два числа и команду в консоль
 * отправляется запрос на сервер, сервер выполняет вычисления, возвращает результат клиенту.
 * клиент отображает результат в консоль
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8081);
        System.out.println("SERVER APPLICATION RUN!");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом :" + client.getPort() + " подключился!");
            String userInput = inputStream.readUTF();
            if (userInput.equals("exit")) {
                System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
                client.close();
                continue;
            }
            List<String> userInputSeparated = new ArrayList(Arrays.asList(userInput.split(" ")));

            Double result = CalcExecutor.calculate(
                    Double.valueOf(userInputSeparated.get(0)),
                    Double.valueOf(userInputSeparated.get(1)),
                    userInputSeparated.get(2).charAt(0));

            outputStream.writeUTF(result.toString());
            outputStream.flush();
            System.out.println("result = " + result);
        }
    }
}