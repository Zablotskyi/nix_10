package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.BookController;
import java.util.Scanner;
import static ua.com.alevel.Main.LOGGER_INFO;

public class Application {
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    AuthorController authorController = new AuthorController();
    BookController bookController = new BookController();
    String next = null;

    public void runAuthors() {
        while (true) {
            System.out.println("""
                    Автор:
                    Нажмите 1 + 'enter' чтоб Добавить автора\s
                    Нажмите 2 + 'enter' чтоб Изменить данные автора\s
                    Нажмите 3 + 'enter' чтоб Удалить автора\s
                    Нажмите 4 + 'enter' чтоб Найти автора по 'ID'\s
                    Нажмите 5 + 'enter' чтоб Найти Всех авторов\s
                                    
                    Нажмите 9 + 'enter' для работы с Базой Книг\s
                    для выхода введие 'exit'""");
            Scanner scanner = new Scanner(System.in);
            String action = null;

            try {
                action = scanner.nextLine();
                byte step = Byte.parseByte(action);

                while ((!(action.equals("exit")))) {
                    if ((step > 0 && step <= 5) || (step == 9)) {
                        switch (action) {
                            case "1": {
                                System.out.println("Введите имя и фамилию автора:");
                                String nameAndLastName = scanner.nextLine();
                                System.out.println("Введите название книги которую написал автор (если книги нет, нажмите 'enter'):");
                                String bookName = scanner.nextLine();
                                try {
                                    if (bookName.equals("")) {
                                        authorController.create(nameAndLastName);
                                    } else {
                                        authorController.create(nameAndLastName, bookName);
                                        bookController.create(bookName, nameAndLastName);
                                    }
                                } catch (Exception e) {
                                    System.out.println("Вы неправильно ввели данные автора. Повторите попытку");
//                                    System.out.println("Если книга отсутвует нажмите 'enter'");
                                    runAuthors();
                                }
                                LOGGER_INFO.info("Автор " + nameAndLastName + " создан");
                                System.out.println("Для продолжения работы нажмите 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                                break;
                            }
                            case "2": {
                                System.out.println("Введите ID автора данные которого нужно изменить:");
                                long id = Long.parseLong(scanner.nextLine());
                                System.out.println("Введите имя и фамилию автора:");
                                String nameAndLastName = scanner.nextLine();
                                System.out.println("Введите название книгу которую написал автор (если книги нет, нажмите 'enter'):");
                                String bookName = scanner.nextLine();
                                try {
                                    if (bookName.equals("")) {
                                        authorController.update(id, nameAndLastName);
                                    } else {
                                        authorController.update(id, nameAndLastName, bookName);
                                        bookController.create(bookName, nameAndLastName);
                                    }
                                } catch (Exception e) {
                                    System.out.println("Вы неправильно ввели данные автора. Повторите попытку");
//                                    System.out.println("Если книга отсутвует нажмите 'enter'");
                                    runAuthors();
                                }
                                LOGGER_INFO.info("Автор " + nameAndLastName + " изменен");
                                System.out.println("Для продолжения работы нажмите 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                                break;
                            }
                            case "3": {
                                System.out.println("Введите ID автора которого нужно удалить:");
                                long id = Long.parseLong(scanner.nextLine());
                                authorController.delete(id);
                                LOGGER_WARN.warn("Автор с ID " + id + " удален");
                                System.out.println("Для продолжения работы нажмите 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                                break;
                            }
                            case "4": {
                                System.out.println("Введите ID автора которого нужно найти:");
                                long id = Long.parseLong(scanner.nextLine());
                                System.out.println(authorController.findById(id).toString());
                                LOGGER_WARN.warn("Был запрос на автора с ID " + id);
                                System.out.println("Для продолжения работы нажмите 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                                break;
                            }
                            case "5": {
                                authorController.findAll();
                                System.out.println("Для продолжения работы нажмите 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                                break;
                            }
                            case "9": {
                                LOGGER_INFO.info("Подключение к базе данных книг");
                                runBooks();
                                break;
                            }
                        }
                    } else {
                        System.out.println("""
                                Ввод не верный
                                Повторите ввод:
                                """);
                        runAuthors();
                    }
                }
            } catch (NumberFormatException e) {
                if (action.equals("exit")) {
                    System.exit(0);
                }
                System.out.println("""
                        Ввод не верный
                        Повторите ввод:
                        """);
                runAuthors();
            }
        }
    }

    public void runBooks() {
        System.out.println("""
                Книги:
                Нажмите 1 + 'enter' чтоб Добавить книгу\s
                Нажмите 2 + 'enter' чтоб Изменить данные книги\s
                Нажмите 3 + 'enter' чтоб Удалить книгу\s
                Нажмите 4 + 'enter' чтоб Найти книгу по 'ID'\s
                Нажмите 5 + 'enter' чтоб Найти Все книги\s
                                
                Нажмите 9 + 'enter' для работы с Базой Авторов\s
                для выхода введие 'exit'""");
        Scanner scanner = new Scanner(System.in);
        String action = null;

        try {
            action = scanner.nextLine();
            byte step = Byte.parseByte(action);

            while ((!(action.equals("exit")))) {
                if ((step > 0 && step <= 5) || (step == 9)) {
                    switch (action) {
                        case "1": {
                            System.out.println("Введите название книги:");
                            String name = scanner.nextLine();
                            System.out.println("Введите год издания книги:");
                            int yearOfPrinting = Integer.parseInt(scanner.nextLine());
                            System.out.println("Введите автора который написал книгу (если авторов несколько введите их через '/' " +
                                    "Пример: Альфред Ахо / Моника Лам / Рави Сети + 'enter'");
                            String authorNameAndLastName = scanner.nextLine();
                            bookController.create(name, yearOfPrinting, authorNameAndLastName);
                            LOGGER_INFO.info("Книга " + name + " создана");
                            System.out.println("Для продолжения работы нажмите 'enter'");
                            next = scanner.nextLine();
                            runBooks();
                            break;
                        }
                        case "2": {
                            System.out.println("Введите ID книги данные которой нужно изменить:");
                            long id = Long.parseLong(scanner.nextLine());
                            System.out.println("Введите название книги:");
                            String name = scanner.nextLine();
                            System.out.println("Введите год издания книги:");
                            int yearOfPrinting = Integer.parseInt(scanner.nextLine());
                            System.out.println("Введите имя и фамилию автора который написал книгу (если авторов несколько введите их через '/' " +
                                    "Пример: Альфред Ахо / Моника Лам / Рави Сети + 'enter'");
                            String authorNameAndLastName = scanner.nextLine();
                            bookController.update(id, name, yearOfPrinting, authorNameAndLastName);
                            LOGGER_INFO.info("Книга " + name + " изменена");
                            System.out.println("Для продолжения работы нажмите 'enter'");
                            next = scanner.nextLine();
                            runBooks();
                            break;
                        }
                        case "3": {
                            System.out.println("Введите ID книги которую нужно удалить:");
                            long id = scanner.nextLong();
                            LOGGER_WARN.warn("Книга с ID " + id + " удалена");
                            System.out.println("Для продолжения работы нажмите 'enter'");
                            next = scanner.nextLine();
                            bookController.delete(id);
                            runBooks();
                            break;
                        }
                        case "4": {
                            System.out.println("Введите ID книги которую нужно найти:");
                            long id = Long.parseLong(scanner.nextLine());
                            System.out.println(bookController.findById(id).toString());
                            LOGGER_WARN.warn("Был запрос на книгу с ID " + id);
                            System.out.println("Для продолжения работы нажмите 'enter'");
                            next = scanner.nextLine();
                            runBooks();
                            break;
                        }
                        case "5": {
                            bookController.findAll();
                            System.out.println("Для продолжения работы нажмите 'enter'");
                            next = scanner.nextLine();
                            runBooks();
                            break;
                        }
                        case "9": {
                            LOGGER_INFO.info("Подключение к базе данных авторов");
                            runAuthors();
                            break;
                        }
                    }
                } else {
                    System.out.println("""
                            Ввод не верный
                            Повторите ввод:
                            """);
                    runBooks();
                }
            }
        } catch (NumberFormatException e) {
            if (action.equals("exit")) {
                System.exit(0);
            }
            System.out.println("""
                    Ввод не верный
                    Повторите ввод:
                    """);
            runBooks();
        }
    }
}