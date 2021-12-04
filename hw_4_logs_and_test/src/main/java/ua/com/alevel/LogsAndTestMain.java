package ua.com.alevel;

import ua.com.alevel.controller.CustomerController;
import ua.com.alevel.controller.StoreController;
import ua.com.alevel.entity.Store;
import ua.com.alevel.service.StoreService;

import java.util.Scanner;

public class LogsAndTestMain {

    public static void main(String[] args) {

        StoreService storeService = new StoreService();

        System.out.println("""
                Введите 1 если хотите работать с базой покупателей\s
                Введите 2 если хотите работать с базой магазинов\s
                для выхода введие 'exit'""");

        Scanner scanner = new Scanner(System.in);
        String bd = scanner.nextLine();

        while (!(bd.equals("exit"))) {
            if (bd.equals("1")) {
                if (storeService.findAll() != null && storeService.findAll().length != 0) {
                    new CustomerController().run();
                }
            }
            if (bd.equals("2")) {
                new StoreController().run();
            } else {
                System.out.println("Для начала работы с базой покупателей добавьте хотябы один магазин");
                System.out.println("""
                        Введите 1 если хотите работать с базой покупателей\s
                        Введите 2 если хотите работать с базой магазинов\s
                        для выхода введие 'exit'""");
                bd = scanner.nextLine();
            }
        }
    }
}