package ua.com.alevel.levelOne;

import java.util.Scanner;

public class AreaOfTriangle {

    public void run() {

        double x1, x2, x3, y1, y2, y3, sideAB, sideBC, sideCA;

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите \"у\" для ввода числовых координат или \"exit\" для выхода");
        Scanner stepScanner = new Scanner(System.in);
        String step = stepScanner.nextLine();

        while (!"exit".equals(step) && "y".equals(step)) {
            System.out.println("Введите первую координату вернишы треугольника");
            System.out.print("x1: ");
            x1 = scanner.nextDouble();
            System.out.print("y1: ");
            y1 = scanner.nextDouble();
            System.out.println("Введите вторую координату вернишы треугольника");
            System.out.print("x2: ");
            x2 = scanner.nextDouble();
            System.out.print("y2: ");
            y2 = scanner.nextDouble();
            System.out.println("Введите третью координату вернишы треугольника");
            System.out.print("x3: ");
            x3 = scanner.nextDouble();
            System.out.print("y3: ");
            y3 = scanner.nextDouble();

            //находим длинну сторон треугольника
            sideAB = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            sideBC = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
            sideCA = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
            //находим площадь треугольника
            double area = (1 / 4.0) * Math.sqrt((sideAB + sideBC + sideCA) * (sideBC + sideCA - sideAB) * (sideAB + sideCA - sideBC) * (sideAB + sideBC - sideCA));

            if (area == 0) {
                System.out.println("Введенные координаты находятся на одной линии!");
            } else {
                System.out.println("Площадь треугольника равна: " + area + " ед. квадратных");
            }
            System.out.println("нажмите \"у\" для ввода координат или \"exit\" для выхода");
            step = stepScanner.nextLine();
        }
    }
}
