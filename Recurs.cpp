#include <iostream>
using namespace std;

// Класс узла бинарного дерева
class Node {
public:
    int data;
    Node* leftChild;
    Node* rightChild;

    Node(int value) {
        data = value;
        leftChild = nullptr;
        rightChild = nullptr;
    }
};

// Прямой обход (Root → Left → Right)
void printPreOrder(Node* node) {
    if (!node) return;

    cout << node->data << " ";
    printPreOrder(node->leftChild);
    printPreOrder(node->rightChild);
}

// Симметричный обход (Left → Root → Right)
void printInOrder(Node* node) {
    if (!node) return;

    printInOrder(node->leftChild);
    cout << node->data << " ";
    printInOrder(node->rightChild);
}

// Обратный обход (Left → Right → Root)
void printPostOrder(Node* node) {
    if (!node) return;

    printPostOrder(node->leftChild);
    printPostOrder(node->rightChild);
    cout << node->data << " ";
}

int main() {
    // Формируем бинарное дерево вручную:
    //        1
    //       / \
    //      2   3
    //     / \
    //    4   5
    Node* head = new Node(1);
    head->leftChild = new Node(2);
    head->rightChild = new Node(3);
    head->leftChild->leftChild = new Node(4);
    head->leftChild->rightChild = new Node(5);

    cout << "Pre-Order: ";
    printPreOrder(head);
    cout << endl;

    cout << "In-Order: ";
    printInOrder(head);
    cout << endl;

    cout << "Post-Order: ";
    printPostOrder(head);
    cout << endl;

    // Ожидаемый результат:
    // Pre-Order: 1 2 4 5 3
    // In-Order: 4 2 5 1 3
    // Post-Order: 4 5 2 3 1

    // Освобождение памяти (опускается для краткости)
    return 0;
}
