package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public String str = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void reverseString() throws IOException {
        System.out.println("Введите строку:");
        str = reader.readLine();
        //преобразовуем строку в массив символов
        char[] array = str.toCharArray();

        if (str.length() <= 1) {
            System.out.println(str);
        }
        else {
            String result = "";
            for (int i = array.length - 1; i >= 0; i --) {
                result += array[i];
            }
            System.out.println(result);
        }
    }

    public void reverseSubstringInString() throws IOException {
        System.out.println("Введите строку:");
        str = reader.readLine();
        System.out.println("Введите подстроку в которой нужно сделать реверс: ");
        String subString = reader.readLine();

        //преобразовуем подстроку в массив символов и делаем реверс
        char[] array = subString.toCharArray();
        String expandedSubString = "";
        for (int i = array.length - 1; i >= 0; i --) {
            expandedSubString += array[i];
        }
        String [] words = str.split(subString);
        String result = words[0] + expandedSubString + words[1];
        System.out.println(result);
    }

    public void reverseStringByIndex() throws IOException {
        System.out.println("Введите строку:");
        str = reader.readLine();

        System.out.println("Введите firstIndex i lastIndex (с которого будет начинатся и заканчиваться реверс:");
        System.out.println("firstIndex: ");
        int firstIndex = Integer.parseInt(reader.readLine());
        System.out.println("lastIndex: ");
        int lastIndex = Integer.parseInt(reader.readLine());
        //преобразовуем строку в массив символов
        char[] array = str.toCharArray();

        if (str.length() <= 1) {
            System.out.println(str);
        }
        else if (firstIndex == lastIndex) {
            System.out.println(str);
        }
        else if (firstIndex < lastIndex) {
            String resultReverse = "";
            for (int i = lastIndex; i >= firstIndex; i --) {
                resultReverse += array[i];
            }
            String result = str.substring(0, firstIndex) + resultReverse + str.substring(lastIndex + 1, str.length());
            System.out.println(result);
        }
        else {
            System.out.println("firstIndex больше чем lastIndex");
        }
    }
}
