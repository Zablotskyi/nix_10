package ua.com.alevel;

import java.util.*;

public class MathSetUtility {
    MathSet mathSet;
    String str = null;

    void create() {
        mathSet = new MathSet();
        System.out.println("Вы создали пустой MathSet с \"плавающим\" размером");
        System.out.println(mathSet);
    }

    void createWithSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность MathSet-'а' равное целому положительному числу большему нуля");

        try {
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("ОШИБКА!!! Введено отрицательное число или 0");
            }
            mathSet = new MathSet(size);
            System.out.println("Вы создали пустой MathSet с размером: " + size + " элементов");
            System.out.println(mathSet);
        } catch (InputMismatchException ime) {
            System.out.println("ОШИБКА!!! Вы ввели не число");
        }
    }

    void createWithArrayInside() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массив чисел через пробел, который хотите положить в MathSet и нажмите 'enter'");
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");
        Number[] numbers = new Number[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            numbers[i] = Integer.parseInt(strArray[i]);
        }
        mathSet = new MathSet(numbers);

        System.out.println("Вы создали MathSet с массивом элементов внутри: ");
        System.out.println(mathSet);
    }

    void createWithArraysInside() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массивы чисел, которые хотите положить в MathSet \n" +
                "Введите один массив чисел через пробел, потом символ '/', потом следующий массив чисел (и так далее) \n" +
                "и нажмите 'enter'");
        String str = scanner.nextLine();
        String[] strArray = str.split("/");

        Number[][] numbers = new Number[strArray.length][];
        for (int i = 0; i < strArray.length; i++) {
            String[] tmpArray = strArray[i].trim().split(" ");
            numbers[i] = new Number[tmpArray.length];
            for (int j = 0; j < tmpArray.length; j++) {
                numbers[i][j] = Integer.parseInt(tmpArray[j]);
            }
        }
        mathSet = new MathSet(numbers);
        System.out.println("Вы создали MathSet с массивами элементов внутри: ");
        System.out.println(mathSet);
    }

    void createWithMathSetInside() {
        if (mathSet != null) {
            mathSet = new MathSet(mathSet);
            System.out.println("Вы создали дубликат MathSet-'а' с элементами внутри: ");
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void createWithMathSetsInside() {
        if (mathSet != null) {
            mathSet = new MathSet(mathSet, mathSet);
            System.out.println("Вы создали дубликат MathSet-'ов' с элементами внутри: ");
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void addNumber() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число которое хотите добавить в MathSet и нажмите 'enter'");
            Number number = scanner.nextInt();
            try {
                mathSet.add(number);
                System.out.println(mathSet);
            } catch (InputMismatchException ime) {
                System.out.println("ОШИБКА!!! Вы ввели не число");
            }
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void addNumbers() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите числа через пробел которые хотите добавить в MathSet и нажмите 'enter'");
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");

            for (int i = 0; i < strArray.length; i++) {
                mathSet.add(Integer.parseInt(strArray[i].trim()));
            }
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void joinMathSet() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите числа через пробел которые хотите объеденить с существующим MathSet-'ом' и нажмите 'enter'");
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");

            Number[] numbers = new Number[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                numbers[i] = Integer.parseInt(strArray[i]);
            }

            MathSet mathSetForJoin = new MathSet(numbers);
            mathSet.join(mathSetForJoin);
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void joinMathSets() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите MathSet-`ы` чисел, которые хотите положить в MathSet \n" +
                    "Введите один MathSet чисел через пробел, потом символ '/', потом следующий MathSet чисел (и так далее) \n" +
                    "и нажмите 'enter'");
            String str = scanner.nextLine();
            String[] strArray = str.split("/");

            Number[][] numbers = new Number[strArray.length][];
            for (int i = 0; i < strArray.length; i++) {
                String[] tmpArray = strArray[i].trim().split(" ");
                numbers[i] = new Number[tmpArray.length];
                for (int j = 0; j < tmpArray.length; j++) {
                    numbers[i][j] = Integer.parseInt(tmpArray[j]);
                }
            }
            MathSet[] mathSets = new MathSet[strArray.length];
            for (int i = 0; i < numbers.length; i++) {
                mathSets[i] = new MathSet(numbers);
            }
            mathSet.join(mathSets);
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void intersectionMathSet() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите числа через пробел пересечение которых нужно найти в существующем MathSet-'е' и нажмите 'enter'");
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            Number[] resArray = new Number[strArray.length];

            for (int i = 0; i < strArray.length; i++) {
                if (mathSet.consistElement(Integer.parseInt(strArray[i]))) {
                    resArray[i] = Integer.parseInt(strArray[i].trim());
                }
            }
            System.out.println(mathSet);
            System.out.println("Числа которые встречаются в MathSet-'е':");
            for (Number number : resArray) {
                if (number != null) {
                    System.out.print(number + " ");
                }
            }
            System.out.println("");
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void intersectionMathSets(MathSet... ms) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите MathSet-`ы` чисел, пересечение которых нужно найти в существующем MathSet-'е' \n" +
                "Введите один MathSet чисел через пробел, потом символ '/', потом следующий MathSet чисел (и так далее) \n" +
                "и нажмите 'enter'");
        String str = scanner.nextLine();
        String[] strArray = str.split("/");

        Number[][] resArray = new Number[strArray.length][];
        for (int i = 0; i < strArray.length; i++) {
            String[] tmpArray = strArray[i].trim().split(" ");
            resArray[i] = new Number[tmpArray.length];
            for (int j = 0; j < tmpArray.length; j++) {
                resArray[i][j] = Integer.parseInt(tmpArray[j].trim());
            }
        }

        if (mathSet != null) {
            int count = 1;
            System.out.println(mathSet);
            System.out.println("Числа которые встречаются c каждого MathSet-'а':");
            for (Number[] number : resArray) {
                System.out.println("\nMathSet-" + count++);
                for (Number element : number) {
                    if (mathSet.consistElement(element)) {
                        System.out.print(element + " ");
                    }
                }
            }
            System.out.println("");
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void sortDesc() {
        if (mathSet != null) {
            mathSet.sortDesc();
            System.out.println("Ваш отсортированный MathSet:");
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void sortDescByIndexes() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите индекс элемента с которого начинаем сортировку MathSet-'а' и нажмите 'enter'");
            int firstIndex = scanner.nextInt();
            System.out.println("Введите индекс элемента по который делаем сортировку MathSet-'а' и нажмите 'enter'");
            int lastIndex = scanner.nextInt();
            mathSet.sortDesc(firstIndex, lastIndex);

            System.out.println("Ваш отсортированный MathSet начиная с индекса элемента: " + firstIndex + " по индекс элемента: " + lastIndex);
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void sortDescByIndex() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите индекс элемента с которого начинаем сортировку MathSet-'а' и нажмите 'enter'");
            int index = scanner.nextInt();
            mathSet.sortDesc(index);

            System.out.println("Ваш отсортированный MathSet начиная с индекса элемента: " + index);
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void sortAsc() {
        if (mathSet != null) {
            mathSet.sortAsc();
            System.out.println("Ваш отсортированный MathSet:");
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void sortAscByIndexes() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите индекс элемента с которого начинаем сортировку MathSet-'а' и нажмите 'enter'");
            int firstIndex = scanner.nextInt();
            System.out.println("Введите индекс элемента по который делаем сортировку MathSet-'а' и нажмите 'enter'");
            int lastIndex = scanner.nextInt();
            mathSet.sortAsc(firstIndex, lastIndex);

            System.out.println("Ваш отсортированный MathSet начиная с индекса элемента: " + firstIndex + " по индекс элемента: " + lastIndex);
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void sortAscByIndex() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите индекс элемента с которого начинаем сортировку MathSet-'а' и нажмите 'enter'");
            int index = scanner.nextInt();
            mathSet.sortAsc(index);

            System.out.println("Ваш отсортированный MathSet начиная с индекса элемента: " + index);
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void get() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите index элемента в MathSet-'е' который нужно найти и нажмите 'enter'");
            int index = scanner.nextInt();
            try {
                System.out.println("искомый элемент по ндексу " + index + " это:");
                Number element = mathSet.getElement(index);
                System.out.println(element);
            } catch (InputMismatchException ime) {
                System.out.println("ОШИБКА!!! Вы ввели не число");
            }
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    Number getMax() {
        if (mathSet != null) {
            System.out.println(mathSet);
            System.out.println("Максимальное значение в MathSet-'е': " + mathSet.getMax());
        } else {
            System.out.println("Вы не создали MathSet");
        }
        return mathSet.getMax();
    }

    Number getMin() {
        if (mathSet != null) {
            System.out.println(mathSet);
            System.out.println("Минимальное значение в MathSet-'е': " + mathSet.getMin());
        } else {
            System.out.println("Вы не создали MathSet");
        }
        return mathSet.getMin();
    }

    Number getAverage() {
        if (mathSet != null) {
            System.out.println(mathSet);
            System.out.println("Среднее арифметическое значение в MathSet-'е': " + mathSet.getAverage());

        } else {
            System.out.println("Вы не создали MathSet");
        }
        return null;
    }

    Number getMedian() {
        if (mathSet != null) {
            System.out.println(mathSet);
            mathSet.sortAsc();
            System.out.println("Медианное значение в MathSet-'е': " + mathSet.getMedian());
        } else {
            System.out.println("Вы не создали MathSet");
        }
        return null;
    }

    void toArray() {
        if (mathSet != null) {
            Number[] resArray = new Number[mathSet.getCountOfElements()];
            for (int i = 0; i < mathSet.getCountOfElements(); i++) {
                resArray[i] = mathSet.getElement(i + 1);
            }
            System.out.println("Вы конвертировани MathSet в массив чисел: ");
            System.out.print("[");
            for (Number number : resArray) {
                if (number != null) {
                    System.out.print(number + " ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    Number[] toArrayByIndex() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите индекс элемента с которого нужно конвертировать MathSet в массив чисел и нажмите 'enter'");
            int firstIndex = scanner.nextInt();
            System.out.println("Введите индекс элемента по который нужно конвертировать MathSet в массив чисел и нажмите 'enter'");
            int lastIndex = scanner.nextInt();


            Number[] resArray = new Number[mathSet.getCountOfElements()];
            for (int i = firstIndex; i <= lastIndex; i++) {
                resArray[i] = mathSet.getElement(i);
            }
            System.out.println("Вы конвертировани MathSet в массив чисел: ");
            System.out.print("[");
            for (Number number : resArray) {
                if (number != null) {
                    System.out.print(number + " ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("Вы не создали MathSet");
        }
        return new Number[0];
    }

    MathSet cut() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите индекс элемента с которого нужно вырезать в MathSet-'е' числа и нажмите 'enter'");
            int firstIndex = scanner.nextInt();
            System.out.println("Введите индекс элемента по который нужно вырезать в MathSet-'е' числа и нажмите 'enter'");
            int lastIndex = scanner.nextInt();

            for (int i = firstIndex - 1; i < lastIndex; i++) {
                mathSet.toArray()[i] = null;
            }
            System.out.println("Ваш вырезали элементы в MathSet-'е' начиная с индекса элемента: " + firstIndex + " по индекс элемента: " + lastIndex);
            System.out.println("\n" + mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
        return null;
    }

    void clearAll() {
        if (mathSet != null) {
            for (int i = 0; i < mathSet.getCountOfElements(); i++) {
                mathSet.toArray()[i] = null;
            }
            System.out.println("Вы очистили MathSet:");
            System.out.println(mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

    void clearByNumbers() {
        if (mathSet != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите массив чисел через пробел, который хотите очистить в MathSet-'е' и нажмите 'enter'");
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            Number[] tmpArray = new Number[strArray.length];

            for (int i = 0; i < tmpArray.length; i++) {
                tmpArray[i] = Integer.parseInt(strArray[i]);
            }
            System.out.println("Вы очистили MathSet от номеров: ");
            for (String element : strArray) {
                if (mathSet.consistElement(Integer.parseInt(element))) {
                    System.out.print(element + " ");
                }
            }
            for (int i = 0; i < mathSet.getCountOfElements(); i++) {
                for (int j = 0; j < tmpArray.length; j++) {
                    if (mathSet.toArray()[i] == tmpArray[j]) {
                        mathSet.toArray()[i] = null;
                    }
                }
            }
            System.out.println("\n" + mathSet);
        } else {
            System.out.println("Вы не создали MathSet");
        }
    }

//    Number[] removingDuplicateNumbers(Number[] array) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        if (array == null || array.length == 0) {
//            return array;
//        }
//        int n = 1;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] != array[i - 1]) n++;
//        }
//        Number[] resArray = new Number[n];
//        resArray[0] = array[0];
//        n = 1;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] != array[i - 1]) resArray[n++] = array[i];
//        }
//        return resArray;
//    }
//
//    Number[] copyingArrayToArray(Number[] array1, Number[] array2) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        if (array1.length >= array2.length) {
//            array1 = array2;
//        } else {
//            for (int i = 0; i < array1.length; i++) {
//                array1[i] = array2[i];
//            }
//
//        }
//        return array1;
//    }
//
//    Number[] joinTwoArray(Number[] array1, Number[] array2) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        int count = 0;
//        Number[] twoArray = new Number[array1.length + array2.length];
//        Number[] resArray = new Number[array1.length + array2.length];
//
//        for (int i = 0; i < array1.length; i++) {
//            twoArray[i] = array1[i];
//            count++;
//        }
//        for (int j = 0; j < array2.length; j++) {
//            twoArray[count++] = array2[j];
//        }
//        return resArray;
//    }
}