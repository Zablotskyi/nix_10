package ua.com.alevel;

import ua.com.alevel.level_2.FindMaxDepthOfBinaryTree.FindMaxDepthOfBinaryTree;
import ua.com.alevel.level_1.AreaOfTriangle;
import ua.com.alevel.level_1.CorrectMoveOfKnightOnChessboard;
import ua.com.alevel.level_1.NumberOfUniqueCharacters;
import ua.com.alevel.level_2.InputStringIsValid;
import ua.com.alevel.level_3.GameLife.GameLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTask {

    public void run() throws IOException {
        String s = """
                Перечень задач:
                Уровень 1
                1. Дан массив чисел. Вернуть количество уникальных чисел;
                2. Ход коня по шахматной доске;
                3. Вычислить площадь треугольника ABC;
                Уровень 2
                4. Является ли входная строка допустимой;
                5. По заданному бинарному дереву найти максимальную глубину;
                Уровень 3
                6. Игра Жизни.
                """;

        while (true) {
            System.out.println(s);
            System.out.print("Введите номер задачи которую хотите проверить, для выхода введите \"exit\": ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String enterTask = reader.readLine();

            if (!(enterTask.equals("exit"))) {
                switch (enterTask) {
                    case ("1"): {
                        new NumberOfUniqueCharacters().run();
                    }
                    break;
                    case ("2"): {
                        new CorrectMoveOfKnightOnChessboard().run();
                    }
                    break;
                    case ("3"): {
                        new AreaOfTriangle().run();
                    }
                    break;
                    case ("4"): {
                        new InputStringIsValid().run();
                    }
                    break;
                    case ("5"): {
                        new FindMaxDepthOfBinaryTree().run();
                    }
                    break;
                    case ("6"): {
                        new GameLife().run();
                    }
                    break;
                    default: {
                        System.out.println("Такой задачи не существует");
                    }
                    break;
                }

            } else {
                System.exit(0);
            }
        }
    }
}
