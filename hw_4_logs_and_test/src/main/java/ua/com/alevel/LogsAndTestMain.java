package ua.com.alevel;

import java.util.Scanner;

public class LogsAndTestMain {

    public static void main(String[] args) {

        System.out.println("""
                База автомобильных номеров Украины
                Нажмите 1 + 'enter' для работы с базой автомобильных номеров\s
                Нажмите 2 + 'enter' для работы с базой зарегистрированых автомобилей\s
                для выхода введие 'exit'""");

        Scanner scanner = new Scanner(System.in);
        String bd = scanner.nextLine();

        while (!(bd.equals("exit"))) {
            if (bd.equals("1")) {

            }
            if (bd.equals("2")) {

            }
        }
        System.exit(0);
    }
}