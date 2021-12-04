package ua.com.alevel.controller;

import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {

    private final UserService userService = new UserService();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите действие");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("Если вы хотите создать пользователя, нажмите 1");
        System.out.println("Если вы хотите обновить данные пользователя, нажмите 2");
        System.out.println("Если вы хотите удалить пользователя, нажмите 3");
        System.out.println("Если вы хотите найти пользователя по номеру телефона, нажмите 4");
        System.out.println("Если вы хотите найти всех пользователей, нажмите 5");
        System.out.println("Выход, нажмите 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            System.out.println("Введите свое имя");
            String name = reader.readLine();
            System.out.println("Введите свой возраст");
            int age = Integer.parseInt(reader.readLine());
            System.out.println("Введите номер телефона без пробелов в формате 3 *** ххххххх, где * - это код оператора, х - номер телефона");
            long phone = Long.parseLong(reader.readLine());

            User user = new User();
            user.setAge(age);
            user.setName(name);
            user.setId(phone);
            userService.create(user);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 3 *** ххххххх, где * - это код оператора, х - номер телефона");
            long phone = Long.parseLong(reader.readLine());
            System.out.println("Введите ваше имя");
            String name = reader.readLine();
            System.out.println("Введите ваш возраст");
            int age = Integer.parseInt(reader.readLine());
            User user = new User();
            user.setId(phone);
            user.setAge(age);
            user.setName(name);
            userService.update(user);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 3 *** ххххххх, где * - это код оператора, х - номер телефона");
            long id = Long.parseLong(reader.readLine());
            userService.delete(id);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 3 *** ххххххх, где * - это код оператора, х - номер телефона");
            long phone = Long.parseLong(reader.readLine());
            User user = userService.findById(phone);
            System.out.println("пользователь: = " + user);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        User[] users = userService.findAll();
        if (users != null && users.length != 0) {
            for (User user : users) {
                System.out.println("пользователь: = " + user);
            }
        } else {
            System.out.println("таблица пустая");
        }
    }
}