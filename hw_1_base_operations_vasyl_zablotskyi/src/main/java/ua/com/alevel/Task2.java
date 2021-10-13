package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public void run() throws IOException {
        //считываем строку с клавиатуры
        System.out.println("Введите строку:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //создаем массив с размерностью количества символов и дерево, куда будем ложить результат
        int[] symbol = new int[1104];
        Map<Character, Integer> result = new TreeMap<>();


        //делаем проверку на наше условие и добавляем по коду в массив
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i ++) {
            char c = stringBuilder.charAt(i);
            int number = (int) c;
            if ((number >= 65 && number <= 90) || (number >= 97 && number <= 122) || (number >= 1040 && number <= 1103)) {
                symbol[number] ++;
            }
        }
        //проходимся по массиву, убираем пустые ячейки, добавляем в дерево, выводим результат
        for (int i = 0; i < symbol.length; i ++) {
            if (symbol[i] > 0) {
                char myChar = (char) i;
                result.put(myChar, symbol[i]);
            }
        }
        System.out.println("Количество повторов всех символов: ");
        int serialNumber = 1;
        for (Map.Entry res : result.entrySet()) {
            System.out.print(serialNumber ++ + ". ");
            System.out.println(res.getKey() + " - " + res.getValue());
        }
    }
}
