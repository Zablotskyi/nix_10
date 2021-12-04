package ua.com.alevel.levelTwo.FindMaxDepthOfBinaryTree;

import java.util.Stack;

class BinaryTree {

    private int value; //ключ узла
    private BinaryTree leftChild; //левый узел потомок
    private BinaryTree rightChild; //правый узел потомок
    private BinaryTree rootBinaryTree; //корневой узел

//    public BinaryTree(int value, BinaryTree leftChild, BinaryTree rightChild) {
//        this.value = value;
//        this.leftChild = leftChild;
//        this.rightChild = rightChild;
//    }

    public BinaryTree(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTree getRootBinaryTree() {
        return rootBinaryTree;
    }

    public void setRootBinaryTree(BinaryTree rootBinaryTree) {
        this.rootBinaryTree = rootBinaryTree;
    }

    public BinaryTree() { //Пустое дерево
        rootBinaryTree = null;
    }

    public void createBinaryTree() {
        //вставляем узлы в дерево:
        for (int i = 0; i < 10; i++) {
            insertBinaryTree((int) (Math.random() * 10));
        }
    }

    public void insertBinaryTree(int value) { //метод вставки нового элемента
        BinaryTree newBinaryTree = new BinaryTree(); //создание нового узла
        newBinaryTree.setValue(value); //вставка данных
        if (rootBinaryTree == null) { //если корневой узел не существует
            rootBinaryTree = newBinaryTree; //то новый элемент и есть корневой узел
        } else { //корневой узел занят
            BinaryTree currentBinaryTree = rootBinaryTree; //начинаем с корневого узла
            BinaryTree parentBinaryTree;
            while (true) //мы имеем внутренний выход из цикла
            {
                parentBinaryTree = currentBinaryTree;
                if (value == currentBinaryTree.getValue()) { //если такой элемент в дереве уже есть, не сохраняем его
                    return; //просто выходим из метода
                } else if (value < currentBinaryTree.getValue()) { //движение влево?
                    currentBinaryTree = currentBinaryTree.getLeftChild();
                    if (currentBinaryTree == null) { //если был достигнут конец цепочки,
                        parentBinaryTree.setLeftChild(newBinaryTree); //то вставить слева и выйти из методы
                        return;
                    }
                } else { //Или направо?
                    currentBinaryTree = currentBinaryTree.getRightChild();
                    if (currentBinaryTree == null) { //если был достигнут конец цепочки,
                        parentBinaryTree.setRightChild(newBinaryTree);  //то вставить справа
                        return; //и выйти
                    }
                }
            }
        }
    }

    public void printTree() { //метод для вывода дерева в консоль
        Stack globalStack = new Stack(); //общий стек для значений дерева
        globalStack.push(rootBinaryTree);
        int gaps = 32; //начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/";
        System.out.println(separator);//черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); //локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { //окуда в общем стеке есть элементы
                BinaryTree temp = (BinaryTree) globalStack.pop(); //берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); //выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); //соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");//если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;//при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); //перемещаем все элементы из локального стека в глобальный
        }
        System.out.println("\n" + separator);//подводим черту
    }

}
