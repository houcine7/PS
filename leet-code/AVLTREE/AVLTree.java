package AVLTREE;

public class AVLTree {
    NodeAVL root;

    int height(NodeAVL ptr) {
        if (ptr == null)
            return 0;
        return ptr.height;
    }

    NodeAVL rotateRight(NodeAVL b) {
        NodeAVL a = b.left;
        NodeAVL c = a.right;
        a.right = b;
        b.left = c;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        return a;
    }

    NodeAVL rotateLeft(NodeAVL a) {
        NodeAVL b = a.right;
        NodeAVL c = b.left;
        b.left = a;
        a.right = c;
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    int getBalance(NodeAVL ptr) {
        if (ptr == null) {
            return 0;
        }
        return height(ptr.left) - height(ptr.right);
    }

    NodeAVL insert(NodeAVL node, int key) {
        if (node == null)
            return (new NodeAVL(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rotateRight(node);
        if (balance < -1 && key > node.right.key)
            return rotateLeft(node);
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    void preOrder(NodeAVL ptr) {
        if (ptr != null) {
            System.out.print(ptr.key + " ");
            preOrder(ptr.left);
            preOrder(ptr.right);
        }
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        System.out.println("Tree Traversal");
        tree.preOrder(tree.root);

    }

}
