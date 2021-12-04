package ua.com.alevel.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfUniqueCharacters {

    Set<String> number = new TreeSet<>();

    public void run() throws IOException {
        System.out.println("Вводите необходимое количество символов, строк и чисел через пробел, \n" +
                "когда ввод будет окончен, нажмите \"enter\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (!"exit".equals(line)) {
            //заменяем в нашей строке все кроме чисел на пробелы
            String result = line.replaceAll("[^0-9]", " ");
            //получаем массив чисел разделенных пробелом
            String[] onlyNumbers = result.split(" ");
            //проходимся по массиву и добавляем в TreeSet наши числа
            for (String onlyNumber : onlyNumbers) {
                if (!(onlyNumber.equals(""))) {
                    number.add(onlyNumber);
                }
            }
            System.out.println("Уникальных символов (чисел) в строке: " + number.size());
            System.out.println("Введите новую строку или \"exit\" для выхода");
            number.clear();
            line = reader.readLine();
        }
    }
}
