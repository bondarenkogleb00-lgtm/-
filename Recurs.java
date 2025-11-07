// Класс узла бинарного дерева
class Node {
    int data;
    Node leftChild;
    Node rightChild;

    Node(int value) {
        this.data = value;
    }
}

public class TreeTraversalDemo {

    // Обход дерева в прямом порядке (Root → Left → Right)
    public static void traversePreOrder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    // Обход дерева в симметричном порядке (Left → Root → Right)
    public static void traverseInOrder(Node node) {
        if (node == null) return;

        traverseInOrder(node.leftChild);
        System.out.print(node.data + " ");
        traverseInOrder(node.rightChild);
    }

    // Обход дерева в обратном порядке (Left → Right → Root)
    public static void traversePostOrder(Node node) {
        if (node == null) return;

        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        // Формируем пример бинарного дерева вручную
        Node rootNode = new Node(1);
        rootNode.leftChild = new Node(2);
        rootNode.rightChild = new Node(3);
        rootNode.leftChild.leftChild = new Node(4);
        rootNode.leftChild.rightChild = new Node(5);

        System.out.print("Pre-Order Traversal: ");
        traversePreOrder(rootNode);
        System.out.println();

        System.out.print("In-Order Traversal: ");
        traverseInOrder(rootNode);
        System.out.println();

        System.out.print("Post-Order Traversal: ");
        traversePostOrder(rootNode);
        System.out.println();

        // Ожидаемый результат:
        // Pre-Order Traversal: 1 2 4 5 3
        // In-Order Traversal: 4 2 5 1 3
        // Post-Order Traversal: 4 5 2 3 1
    }
}
