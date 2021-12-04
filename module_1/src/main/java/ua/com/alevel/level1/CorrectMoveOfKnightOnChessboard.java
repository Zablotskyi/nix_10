package ua.com.alevel.level1;

import java.util.Scanner;

public class CorrectMoveOfKnightOnChessboard {

    static boolean isOnBoardError = false;

    private static boolean isRightPositionOnBoard(char column, int row) {
        if (!((column >= 'a' && column <= 'h') && (row >= 1 && row <= 8))) {
            isOnBoardError = true;
        }
        return (column >= 'a' && column <= 'h') && (row >= 1 && row <= 8);
    }

    private static boolean isRightMove(char columnPosition, int rowPosition, char columnWalks, int rowWalks) {
        return (isRightPositionOnBoard(columnPosition, rowPosition) &&
                isRightPositionOnBoard(columnWalks, rowWalks)) &&
                Math.abs(columnPosition - columnWalks) + Math.abs(rowPosition - rowWalks) == 3;
    }

    public void run() {

        Scanner inputUser = new Scanner(System.in);
        System.out.println("Сделайте ход коня в формате \"g1-f3\" (где g1 стартовая позиция, f3 куда ходит конь), или введите \"exit\" для выхода");

        String position;
        String walks;
        String move = inputUser.next();

        while (!"exit".equals(move)) {
            position = move.split("-")[0].toLowerCase();
            walks = move.split("-")[1].toLowerCase();
            if (isRightMove(position.charAt(0), Character.digit(position.charAt(1), 10),
                    walks.charAt(0), Character.digit(walks.charAt(1), 10))) {
                System.out.println("Ход верный");
            } else {
                if (isOnBoardError) {
                    System.out.println("Такой позиции на шахматной доске не существует!");
                    isOnBoardError = true;
                } else {
                    System.out.println("Конь так не ходит!");
                }
            }
            System.out.println("Сделайте ход коня в формате \"g1-f3\" (где g1 стартовая позиция, f3 куда ходит конь), или введите \"exit\" для выхода");
            move = inputUser.next();
        }
    }
}
