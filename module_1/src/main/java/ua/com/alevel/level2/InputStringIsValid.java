package ua.com.alevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InputStringIsValid {

    public void run() throws IOException {

        System.out.println("Вводите строку с использованием скобок '(', ')', '{', '}', '[' и ']', в произвольном порядке:\n" +
                "когда ввод будет окончен, нажмите \"enter\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (!"exit".equals(line)) {
            if (checkBrackets(line)) {
                System.out.println("строка допустима");
            } else {
                System.out.println("строка не допустима, проверьте правильность расстановки открывающих и закрывающих скобок");
            }
            System.out.println("Введите новую строку или \"exit\" для выхода");
            line = reader.readLine();
        }
    }

    static boolean checkBrackets(String line) {
        //создаем стек, в который будем помещать наши скобки
        Stack<Character> brackets = new Stack<>();
        //цикл проходися по строке, записывает в стек скобки и и делает проверку их очередности
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '{') {
                brackets.push('{');
            } else if (line.charAt(i) == '[') {
                brackets.push('[');
            } else if (line.charAt(i) == '(') {
                brackets.push('(');

            } else if (line.charAt(i) == '}') {
                if (!brackets.isEmpty() && brackets.peek() == '{') {
                    brackets.pop();
                } else {
                    return false;
                }
            } else if (line.charAt(i) == ']') {
                if (!brackets.isEmpty() && brackets.peek() == '[') {
                    brackets.pop();
                } else {
                    return false;
                }
            } else if (line.charAt(i) == ')') {
                if (!brackets.isEmpty() && brackets.peek() == '(') {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }
        //если строка пустая, то она тоже допустима
        if (brackets.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}