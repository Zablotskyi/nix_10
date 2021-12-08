package ua.com.alevel;

import java.util.Scanner;

public class LogsAndTestMain {

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Автор-Книга:
                    Нажмите 1 + 'enter' для работы с базой авторов\s
                    Нажмите 2 + 'enter' для работы с базой книг\s
                    для выхода введие 'exit'""");
            Scanner scanner = new Scanner(System.in);
            String action = null;

            try {
                action = scanner.nextLine();
                byte step = Byte.parseByte(action);

                if (step == 1) {
                    new Application().runAuthors();
                } else if (step == 2) {
                    new Application().runBooks();
                } else {
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                if (action.equals("exit")) {
                    System.exit(0);
                }
                System.out.println("""
                        Ввод не верный
                        Повторите ввод:
                        """);
            }
        }
    }
}