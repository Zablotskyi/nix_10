package ua.com.alevel.level_2.FindMaxDepthOfBinaryTree;

import java.util.Scanner;

public class FindMaxDepthOfBinaryTree {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите \"у\" для рандомного заполнение дерева и отрисовки его в консоли или \"exit\" для выхода");
        String drawTree = scanner.nextLine();

        while (!"exit".equals(drawTree) && "y".equals(drawTree)) {

            BinaryTree tree = new BinaryTree();
            //создаем дерево
            tree.createBinaryTree();
            //отображение дерева в консоли
            tree.printTree();
            System.out.println("Максимальная глубина бинарного дерева: " + maxDepth(tree.getRootBinaryTree()));
            System.out.println("введите \"у\" для рандомного заполнение дерева и отрисовки его в консоли или \"exit\" для выхода");
            drawTree = scanner.nextLine();
        }
    }

    public int maxDepth(BinaryTree tree) {
        if (tree == null) {
            return -1;
        }
        int nLeft = maxDepth(tree.getLeftChild());
        int nRight = maxDepth(tree.getRightChild());
        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }
}
