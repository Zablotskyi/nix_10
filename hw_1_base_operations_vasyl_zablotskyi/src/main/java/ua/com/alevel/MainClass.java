package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String s1 = "Добрый день!";
        String s2 = "Перечень задач:";
        String s3 = "1. Вычленение всех чисел из строки и возвращение их суммы;";
        String s4 = "2. Вычленение всех символов из строки (латиница/кирилица), сортировка по алфавиту и отображение количества вхождений каждого символа;";
        String s5 = "3. Конец уроков. Программа покажет во сколько заканчивается выбранный урок;";
        System.out.printf("%s%n%s%n%s%n%s%n%s%n", s1, s2, s3, s4, s5);

        while (true) {
            System.out.print("Введите номер задачи которую хотите проверить, для выхода введите \"exit\": ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String enterTask = reader.readLine();

            if (!(enterTask.equals("exit"))) {
                SwitchTask switchTask = new SwitchTask(enterTask);
                switchTask.run();
            }
            else {
                System.exit(0);
            }
        }
    }
}
