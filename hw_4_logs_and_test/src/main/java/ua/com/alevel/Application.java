package ua.com.alevel;

import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.BookController;
import java.util.Scanner;

public class Application {
    AuthorController authorController = new AuthorController();
    BookController bookController = new BookController();
    String next = null;

    public void runAuthors() {
        while (true) {
            System.out.println("""
                    Автор:
                    Нажмите 1 + 'enter' чтоб Добавить автора\s
                    Нажмите 2 + 'enter' чтоб Изменить данные автора\s
                    Нажмите 3 + 'enter' для того чтоб Удалить автора\s
                    Нажмите 4 + 'enter' для того чтоб Найти автора по 'ID'\s
                    Нажмите 5 + 'enter' для того чтоб Найти Всех авторов\s
                                    
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
                                System.out.println("Введите имя автора:");
                                String name = scanner.nextLine();
                                System.out.println("Введите фамилию автора:");
                                String lastName = scanner.nextLine();
                                System.out.println("Введите название книги которую написал автор:");
                                String bookName = scanner.nextLine();
                                System.out.println("Автор создан! Для продолжения работы нажмите любую клавишу + 'enter'");
                                next = scanner.nextLine();
                                authorController.create(name, lastName, bookName);
                                runAuthors();
                            }
                            case "2": {
                                System.out.println("Введите имя автора:");
                                String name = scanner.nextLine();
                                System.out.println("Введите фамилию автора:");
                                String lastName = scanner.nextLine();
                                System.out.println("Введите название книги которую написал автор:");
                                String bookName = scanner.nextLine();
                                System.out.println("Автор изменен! Для продолжения работы нажмите любую клавишу + 'enter'");
                                next = scanner.nextLine();
                                authorController.update(name, lastName, bookName);
                                runAuthors();
                            }
                            case "3": {
                                System.out.println("Введите ID автора которого нужно удалить:");
                                long id = scanner.nextLong();
                                System.out.println("Автор удален! Для продолжения работы нажмите любую клавишу + 'enter'");
                                next = scanner.nextLine();
                                authorController.delete(id);
                                runAuthors();
                            }
                            case "4": {
                                System.out.println("Введите ID автора которого нужно найти:");
                                long id = scanner.nextLong();
                                authorController.findById(id);
                                System.out.println("Для продолжения работы нажмите любую клавишу + 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                            }
                            case "5": {
                                authorController.findAll();
                                System.out.println("Для продолжения работы нажмите любую клавишу + 'enter'");
                                next = scanner.nextLine();
                                runAuthors();
                            }
                            case "9": {
                                runBooks();
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
                Автор:
                Нажмите 1 + 'enter' чтоб Добавить книгу\s
                Нажмите 2 + 'enter' чтоб Изменить данные книги\s
                Нажмите 3 + 'enter' для того чтоб Удалить книгу\s
                Нажмите 4 + 'enter' для того чтоб Найти книгу по 'ID'\s
                Нажмите 5 + 'enter' для того чтоб Найти Все книги\s
                                
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
                            int yearOfPrinting = scanner.nextInt();
                            System.out.println("Введите автора который написал книгу:");
                            String authorName = scanner.nextLine();
                            System.out.println("Книга создана! Для продолжения работы нажмите любую клавишу + 'enter'");
                            next = scanner.nextLine();
                            bookController.create(name, yearOfPrinting, authorName);
                            runBooks();
                        }
                        case "2": {
                            System.out.println("Введите название книги:");
                            String name = scanner.nextLine();
                            System.out.println("Введите год издания книги:");
                            int yearOfPrinting = scanner.nextInt();
                            System.out.println("Введите автора который написал книгу:");
                            String authorName = scanner.nextLine();
                            System.out.println("Данные книги изменены! Для продолжения работы нажмите любую клавишу + 'enter'");
                            next = scanner.nextLine();
                            bookController.update(name, yearOfPrinting, authorName);
                            runBooks();
                        }
                        case "3": {
                            System.out.println("Введите ID книги которую нужно удалить:");
                            long id = scanner.nextLong();
                            System.out.println("Книга удалена! Для продолжения работы нажмите любую клавишу + 'enter'");
                            next = scanner.nextLine();
                            authorController.delete(id);
                            runBooks();
                        }
                        case "4": {
                            System.out.println("Введите ID книги которую нужно найти:");
                            long id = scanner.nextLong();
                            authorController.findById(id);
                            System.out.println("Для продолжения работы нажмите любую клавишу + 'enter'");
                            next = scanner.nextLine();
                            runBooks();
                        }
                        case "5": {
                            authorController.findAll();
                            System.out.println("Для продолжения работы нажмите любую клавишу + 'enter'");
                            next = scanner.nextLine();
                            runBooks();
                        }
                        case "9": {
                            runAuthors();
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
