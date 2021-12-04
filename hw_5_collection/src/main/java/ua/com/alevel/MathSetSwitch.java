package ua.com.alevel;

import java.util.Scanner;

public class MathSetSwitch {
    MathSetUtility mathSetUtility = new MathSetUtility();

    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                                
                Выберите MathSet который хотите создать:
                нажмите 1 + 'enter' для того чтоб Создать MathSet с "плавающим" размером;
                нажмите 2 + 'enter' для того чтоб Создать MathSet с заданным размером;
                нажмите 3 + 'enter' для того чтоб Создать MathSet с массивом внутри;
                нажмите 4 + 'enter' для того чтоб Создать MathSet с несколькими массивами внутри;
                нажмите 5 + 'enter' для того чтоб Создать MathSet с MathSet-'ом' внутри;
                нажмите 6 + 'enter' для того чтоб Создать MathSet с несколькими MathSet-'ами' внутри;
                                
                Выберите нужное действие с MathSet-'ом':
                нажмите 7 + 'enter' для того чтоб Добавить число в MathSet;
                нажмите 8 + 'enter' для того чтоб Добавить несколько чисел в MathSet;
                нажмите 9 + 'enter' для того чтоб Объеденить два MathSet-'a';
                нажмите 10 + 'enter' для того чтоб Объеденить несколько MathSet-'ов';
                нажмите 11 + 'enter' для того чтоб Найти пересечение с MathSet-'ом';
                нажмите 12 + 'enter' для того чтоб Найти пересечение с несколькими MathSet-'ами';
                нажмите 13 + 'enter' для того чтоб Отсортировать MathSet по Возрастанию;
                нажмите 14 + 'enter' для того чтоб Отсортировать MathSet по Возрастанию от интекса 'n' до индекса 'm';
                нажмите 15 + 'enter' для того чтоб Отсортировать MathSet по Возрастанию с определенного индекса;
                нажмите 16 + 'enter' для того чтоб Отсортировать MathSet по Убыванию;
                нажмите 17 + 'enter' для того чтоб Отсортировать MathSet по Убыванию от интекса 'n' до индекса 'm';
                нажмите 18 + 'enter' для того чтоб Отсортировать MathSet по Убыванию с определенного индекса;
                нажмите 19 + 'enter' для того чтоб Найти Элемент в MathSet-'е' по Индексу;
                нажмите 20 + 'enter' для того чтоб Найти Максимальный элемент в MathSet-'е';
                нажмите 21 + 'enter' для того чтоб Найти Минимальный элемент в MathSet-'е';
                нажмите 22 + 'enter' для того чтоб Найти Среднее значение в MathSet-'е';
                нажмите 23 + 'enter' для того чтоб Найти Медиану в MathSet-'е';
                нажмите 24 + 'enter' для того чтоб весь MathSet Преобразовать в массив;
                нажмите 25 + 'enter' для того чтоб часть MathSet-'a' от 'index' до 'index' Преобразовать в массив;
                нажмите 26 + 'enter' для того чтоб Вырезать элементы от 'index' до 'index';
                нажмите 27 + 'enter' для того чтоб Очистить MathSet;
                нажмите 28 + 'enter' для того чтоб Удалить из MathSet-'а' массив чисел;
                введите 'quit' и нажмите 'enter' для Выхода.""");
        String action = null;

        try {
            action = scanner.nextLine();
            byte step = Byte.parseByte(action);

            while (!(action.equals("quit"))) {
                if (step > 0 && step <= 28) {
                    switch (action) {
                        case "1": {
                            mathSetUtility.create();
                            break;
                        }
                        case "2": {
                            mathSetUtility.createWithSize();
                            break;
                        }
                        case "3": {
                            mathSetUtility.createWithArrayInside();
                            break;
                        }
                        case "4": {
                            mathSetUtility.createWithArraysInside();
                            break;
                        }
                        case "5": {
                            mathSetUtility.createWithMathSetInside();
                            break;
                        }
                        case "6": {
                            mathSetUtility.createWithMathSetsInside();
                            break;
                        }
                        case "7": {

                            mathSetUtility.addNumber();
                            break;
                        }
                        case "8": {
                            mathSetUtility.addNumbers();
                            break;
                        }
                        case "9": {
                            mathSetUtility.joinMathSet();
                            break;
                        }
                        case "10": {
                            mathSetUtility.joinMathSets();
                            break;
                        }
                        case "11": {
                            mathSetUtility.intersectionMathSet();
                            break;
                        }
                        case "12": {
                            mathSetUtility.intersectionMathSets();
                            break;
                        }
                        case "13": {
                            mathSetUtility.sortDesc();
                            break;
                        }
                        case "14": {
                            mathSetUtility.sortDescByIndexes();
                            break;
                        }
                        case "15": {
                            mathSetUtility.sortDescByIndex();
                            break;
                        }
                        case "16": {
                            mathSetUtility.sortAsc();
                            break;
                        }
                        case "17": {
                            mathSetUtility.sortAscByIndexes();
                            break;
                        }
                        case "18": {
                            mathSetUtility.sortAscByIndex();
                            break;
                        }
                        case "19": {
                            mathSetUtility.get();
                            break;
                        }
                        case "20": {
                            mathSetUtility.getMax();
                            break;
                        }
                        case "21": {
                            mathSetUtility.getMin();
                            break;
                        }
                        case "22": {
                            mathSetUtility.getAverage();
                            break;
                        }
                        case "23": {
                            mathSetUtility.getMedian();
                            break;
                        }
                        case "24": {
                            mathSetUtility.toArray();
                            break;
                        }
                        case "25": {
                            mathSetUtility.toArrayByIndex();
                            break;
                        }
                        case "26": {
                            mathSetUtility.cut();
                            break;
                        }
                        case "27": {
                            mathSetUtility.clearAll();
                            break;
                        }
                        case "28": {
                            mathSetUtility.clearByNumbers();
                            break;
                        }
                    }
                } else {
                    System.out.println("Ввод не верный");
                }
                run();
            }
        } catch (NumberFormatException e) {
            if (action.equals("quit")) {
                System.exit(0);
            }
            System.out.println("""
                    Ввод не верный
                    Повторите ввод:
                    """);
            run();
        }
    }
}
