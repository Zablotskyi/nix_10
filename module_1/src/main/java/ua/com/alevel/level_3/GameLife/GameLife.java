package ua.com.alevel.level_3.GameLife;

import java.util.Scanner;

public class GameLife {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите \"у\" для начала игры или \"exit\" для выхода");
        Scanner stepScanner = new Scanner(System.in);
        String step = stepScanner.nextLine();

        while (!"exit".equals(step) && "y".equals(step)) {
            System.out.println("Введите ширину и высоту игрового поля виде двух целых чисел +\n" +
                    "кликом мышки по игровому полю можно добавлять новые фигуры");
            System.out.print("ширина: ");
            int width = scanner.nextInt();
            System.out.print("высота: ");
            int height = scanner.nextInt();

            Window window = new Window();
            window.initConfigParams(width, height);
            javax.swing.SwingUtilities.invokeLater(window);

            step = stepScanner.nextLine();
        }
    }
}
