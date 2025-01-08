package ru.otus.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    protected String username;
    private UserRole userRole;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился на порту: " + socket.getPort());
                //цикл аутентификации
                while (true) {
                    sendMsg("Для начала работы надо пройти аутентификацию или регистрацию" +
                            "\nФормат команды для аутентификации: /auth login password" +
                            "\nФормат команды для регистрации: /reg login password username");

                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        // /auth login password
                        if (message.startsWith("/auth ")) {
                            String[] element = message.split(" ");
                            if (element.length != 3) {
                                sendMsg("Неверный формат команды /auth");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .authenticate(this, element[1], element[2])) {
                                break;
                            }
                        }
                        // /reg login password username
                        if (message.startsWith("/reg ")) {
                            String[] element = message.split(" ");
                            if (element.length != 4) {
                                sendMsg("Неверный формат команды /reg");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .registration(this, element[1], element[2], element[3])) {
                                break;
                            }
                        }
                    }
                }
                //цикл работы
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        // /kick username
                        if (message.startsWith("/kick")) {
                            String[] element = message.split(" ");
                            if (element.length != 2) {
                                sendMsg("Неверный формат команды /kick");
                                continue;
                            }
                               if (this.userRole.equals(UserRole.Admin)) {
                                   server.getAuthenticatedProvider().kickUsername(this, element[1]);
                                   sendMsg("Пользователь " + element[1] + " отключен от чата");
                               }
                               else {
                                sendMsg("Отключать других пользователей может только админ");
                            }
                        }
                    } else {
                        server.broadcastMessage(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRole(UserRole role) {
        this.userRole = role;
    }
}
