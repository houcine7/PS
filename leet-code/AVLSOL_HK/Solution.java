package AVLSOL_HK;

public class Solution {

    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node();

            root.val = val;
            root.ht = getHeight(root);
            return root;
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        }

        int bf = getHeight(root.left) - getHeight(root.right);
        if (bf > 1) {
            int childBf = getHeight(root.left.left) - getHeight(root.left.right);

            if (childBf > 0) {
                root = rotateRight(root);
            } else if (childBf < 0) {
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
            }
        } else if (bf < -1) {
            int childBf = getHeight(root.right.left) - getHeight(root.right.right);
            if (childBf > 0) {
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
            } else if (childBf < 0) {
                root = rotateLeft(root);
            }
        } else {
            root.ht = getHeight(root);
        }
        return root;
    }

    static Node rotateRight(Node root) {
        Node newNode = root.left;
        Node temp = newNode.right;

        newNode.right = root;
        root.left = temp;

        root.ht = getHeight(root);
        newNode.ht = getHeight(newNode);
        return newNode;
    }

    static Node rotateLeft(Node root) {
        Node newNode = root.right;
        Node temp = newNode.left;
        newNode.left = root;
        root.right = temp;
        root.ht = getHeight(root);
        newNode.ht = getHeight(newNode);
        return newNode;
    }

    static int getHeight(Node node) {
        if (node == null)
            return -1;
        return Math.max(getHeight(node.right), getHeight(node.left)) + 1;
    }
}
