class TreeNode:
    def __init__(self, val=0):
        self.val = val
        self.left = None
        self.right = None

# Preorder: корень → левое → правое
def preorder(root):
    if root is None:
        return
    print(root.val, end=" ")  # Обрабатываем корень
    preorder(root.left)          # Рекурсия влево
    preorder(root.right)         # Рекурсия вправо

# Inorder: левое → корень → правое
def inorder(root):
    if root is None:
        return
    inorder(root.left)           # Рекурсия влево
    print(root.val, end=" ")     # Обрабатываем корень
    inorder(root.right)          # Рекурсия вправо

# Postorder: левое → правое → корень
def postorder(root):
    if root is None:
        return
    postorder(root.left)         # Рекурсия влево
    postorder(root.right)        # Рекурсия вправо
    print(root.val, end=" ")    # Обрабатываем корень

# Пример использования
if __name__ == "__main__":
    # Создаём дерево (аналогично предыдущим примерам)
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)

    print("Preorder: ", end="")
    preorder(root)
    print()

    print("Inorder: ", end="")
    inorder(root)
    print()

    print("Postorder: ", end="")
    postorder(root)
    print()
    # Результат вывода
    # Preorder: 1 2 4 5 3
    # Inorder: 4 2 5 1 3
    # Postorder: 4 5 2 3 1
