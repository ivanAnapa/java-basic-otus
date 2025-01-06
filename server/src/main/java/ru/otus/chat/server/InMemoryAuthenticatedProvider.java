package ru.otus.chat.server;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.otus.chat.server.UserRole.Admin;
import static ru.otus.chat.server.UserRole.Customer;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {

    private class User {
        private String login;
        private String password;
        private String username;
        private UserRole role;

        public User(String login, String password, String username, UserRole role) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.role = role;
        }

        public User(String login, String password, String username) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.role = Customer;
        }
    }

    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        this.users = new CopyOnWriteArrayList<>();
        users.add(new User("qwe", "qwe", "qwe1", Admin));
        users.add(new User("asd", "asd", "asd1", Customer));
        users.add(new User("zxc", "zxc", "zxc1", Customer));
    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUsernameByLoginAndPassword(String login, String password) {
        for (User u : users) {
            if (u.login.equals(login) && u.password.equals(password)) {
                return u.username;
            }
        }
        return null;
    }

    private UserRole getUserRoleByUsername(String username) {
        for (User u : users) {
            if (u.username.equals(username)) {
                return u.role;
            }
        }
        return null;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        if (authUsername == null) {
            clientHandler.sendMsg("Неверный логин/пароль");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        clientHandler.setUsername(authUsername);
        clientHandler.setUserRole(getUserRoleByUsername(authUsername));
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);

        return true;
    }

    private boolean isLoginAlreadyExists(String login) {
        for (User u : users) {
            if (u.login.equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyExists(String username) {
        for (User u : users) {
            if (u.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username) {
        if (login.length() < 3 || password.length() < 3 || username.length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }
        if (isUsernameAlreadyExists(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }
        users.add(new User(login, password, username));
        clientHandler.setUsername(username);
        clientHandler.setUserRole(getUserRoleByUsername(username));
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);
        return true;
    }

    @Override
    public boolean kickUsername(ClientHandler clientHandler, String username) {
        for (User u : users) {
            if (u.username.equals(username)) {
                server.kick(clientHandler);
                return true;
            } else {
                clientHandler.sendMsg("Такого пользователя нет");
            }
        }
        return false;
    }
}
