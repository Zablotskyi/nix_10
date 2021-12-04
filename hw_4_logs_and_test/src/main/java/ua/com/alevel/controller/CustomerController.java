package ua.com.alevel.controller;

import ua.com.alevel.entity.Customer;
import ua.com.alevel.entity.GroupOfGoods;
import ua.com.alevel.service.CustomerService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerController {

    private final CustomerService customerService = new CustomerService();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("БАЗА ПОКУПАТЕЛЕЙ");
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
        System.out.println("Если вы хотите перейти к базе магазинов нажмите 9");
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
            case "9":
                new StoreController().run();
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {

        StoreController storeController = new StoreController();

        try {
            System.out.println("Введите свое имя");
            String name = reader.readLine();
            System.out.println("Введите свою фамилию");
            String lastName = reader.readLine();
            System.out.println("Введите свою дату рождения в формате дд-мм-год");
            String birthDay = reader.readLine();
            System.out.println("Введите номер телефона без пробелов в формате 38 *** ххххххх, где * - это код оператора, х - номер телефона");
            long phone = Long.parseLong(reader.readLine());
            System.out.println("Введите через пробел название магазинов в которых покупатель делает покупки \n" +
                    "если предпочтительных магазинов нет нажмите 'enter'");
            storeController.findAllStoreByCustomer(reader);
            String favouriteStores = reader.readLine();

            Customer customer = new Customer();

            customer.setName(name);
            customer.setLastName(lastName);
            customer.setBirthDay(birthDay);
            customer.setId(phone);
            customer.setFavouriteStores(favouriteStores);
            customerService.create(customer);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 38 *** ххххххх, где * - это код оператора, х - номер телефона");
            long phone = Long.parseLong(reader.readLine());
            System.out.println("Введите свое имя");
            String name = reader.readLine();
            System.out.println("Введите свою фамилию");
            String lastName = reader.readLine();
            System.out.println("Введите свою дату рождения в формате дд-мм-год");
            String birthDay = reader.readLine();

            Customer customer = new Customer();
            customer.setName(name);
            customer.setLastName(lastName);
            customer.setBirthDay(birthDay);
            customer.setId(phone);

            customerService.update(customer);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 38 *** ххххххх, где * - это код оператора, х - номер телефона");
            long id = Long.parseLong(reader.readLine());
            customerService.delete(id);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 38 *** ххххххх, где * - это код оператора, х - номер телефона");
            long phone = Long.parseLong(reader.readLine());
            Customer customer = customerService.findById(phone);
            System.out.println("пользователь: = " + customer);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        Customer[] customers = customerService.findAll();
        if (customers != null && customers.length != 0) {
            for (Customer customer : customers) {
                System.out.println("пользователь: = " + customer);
            }
        } else {
            System.out.println("таблица пустая");
        }
    }
}