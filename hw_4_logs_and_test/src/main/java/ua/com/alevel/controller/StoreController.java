package ua.com.alevel.controller;

import ua.com.alevel.entity.GroupOfGoods;
import ua.com.alevel.entity.Store;
import ua.com.alevel.service.StoreService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreController {

    private final StoreService storeService = new StoreService();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("БАЗА МАГАЗИНОВ \n Выберите действие");
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
        System.out.println("Если вы хотите добавить магази, нажмите 1");
        System.out.println("Если вы хотите обновить данные магазина, нажмите 2");
        System.out.println("Если вы хотите удалить магазин, нажмите 3");
        System.out.println("Если вы хотите найти магазин по категории, нажмите 4");
        System.out.println("Если вы хотите найти все магазины, нажмите 5");
        System.out.println("Если вы хотите перейти к базе покупателей нажмите 9");
        System.out.println("Выход, нажмите 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll(reader);
            case "9" -> new CustomerController().run();
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {

        StoreService storeService = new StoreService();

        try {
            System.out.println("Ведите название магазина");
            String name = reader.readLine();
//            store.setName(reader.readLine());
            System.out.println("""
                    Выбирите категорию магазина:
                    нажмите 1 для родукты;
                    нажмите 2 Хозяйственные товары;
                    нажмите 3 Одежда;
                    нажмите 4 Аптека;
                    нажмите 5 Инструмент;
                    нажмите 6 Автозапчасти;
                    нажмите 7 Зоомагазин.""");
            String categories = reader.readLine();

            Store store = new Store();
            store.setName(name);
            store.setType(setCategoriesStore(categories));
            store.setId(storeService.generateId(store));
            storeService.create(store);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Введите название магазина");
            String name = reader.readLine();
            System.out.println("""
                    Выбирите категорию магазина:
                    нажмите 1 для родукты;
                    нажмите 2 Хозяйственные товары;
                    нажмите 3 Одежда;
                    нажмите 4 Аптека;
                    нажмите 5 Инструмент;
                    нажмите 6 Автозапчасти;
                    нажмите 7 Зоомагазин.""");
            String categories = reader.readLine();

            Store store = new Store();
            store.setName(name);
            store.setType(setCategoriesStore(categories));
            store.setId(storeService.generateId(store));

            storeService.update(store);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 38 *** ххххххх, где * - это код оператора, х - номер телефона");
            String id = reader.readLine();
            storeService.delete(id);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Введите номер телефона без пробелов в формате 38 *** ххххххх, где * - это код оператора, х - номер телефона");
            String id = reader.readLine();
            Store store = storeService.findById(id);
            System.out.println("магазин: = " + store);
        } catch (IOException e) {
            System.out.println("ошибка: = " + e.getMessage());
        }
    }

    public void findAll(BufferedReader reader) {
        Store[] stores = storeService.findAll();
        if (stores != null && stores.length != 0) {
            for (Store store : stores) {
                System.out.println("магазин: = " + store);
            }
        } else {
            System.out.println("таблица пустая");
        }
    }

    public void findAllStoreByCustomer(BufferedReader reader) {
        Store[] stores = storeService.findAll();
        if (stores != null && stores.length != 0) {
            System.out.println("перечень магазинов:");
            for (Store store : stores) {
                System.out.println(store.getName());
            }
        } else {
            System.out.println("таблица пустая");
        }
    }

    private String setCategoriesStore(String categories) {
        switch (categories) {
            case "1" -> categories = GroupOfGoods.FOOD.name();
            case "2" -> categories = GroupOfGoods.HOUSEHOLD_GOODS.name();
            case "3" -> categories = GroupOfGoods.CLOTHES.name();
            case "4" -> categories = GroupOfGoods.PHARMACY.name();
            case "5" -> categories = GroupOfGoods.TOOLS.name();
            case "6" -> categories = GroupOfGoods.AUTO_PARTS.name();
            default -> categories = GroupOfGoods.PET_SHOP.name();
        }
        return categories;
    }
}
