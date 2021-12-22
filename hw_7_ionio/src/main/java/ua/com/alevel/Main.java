package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy _ hh:mm:ss");
        String date = sdf.format(new Date());
        LOGGER_INFO.info(String.format("Старт программы: " + date));
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
                    LOGGER_INFO.info("Подключение к базе данных авторов");
                } else if (step == 2) {
                    new Application().runBooks();
                    LOGGER_INFO.info("Подключение к базе данных книг");
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