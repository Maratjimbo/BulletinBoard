package board.model;

import board.util.UserIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private static User instance;
    private ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();

    private User() {
        try {
            users = UserIO.getUsers("C:\\java\\lab15\\users.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public synchronized void addUser(String name, String password) {
        users.put(name, password);
    }

    public synchronized boolean containsKey(String name) {
        return users.containsKey(name);
    }

    public synchronized String get(String name) {
        return users.get(name);
    }

    public synchronized ConcurrentHashMap<String, String> getUsers() {
        return users;
    }
}
