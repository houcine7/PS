package tree_boundaries;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    public class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    Node root;

    // Utils
    public boolean isLeaf(Node node) {
        if (node == null)
            return false;
        return (node.left == null && node.right == null);
    }

    BoundaryTraversal() {
        this.root = null;
    }

    // collect the left boundaries of the tree (excluding the leaves)
    void visitLeftBoundaries(Node root, List<Integer> result) {
        if (root == null)
            return;

        root = root.left;
        while (root != null) {
            if (!isLeaf(root))
                result.add(root.value);
            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    void visitRightBoundaries(Node root, List<Integer> result) {
        // base case
        if (root == null)
            return;

        root = root.right;
        // because the element should be added from end to start not the opposite
        // (reverse Clockwise)
        Stack<Integer> st = new Stack<>();

        while (root != null) {
            if (!isLeaf(root))
                st.push(root.value);
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }

        while (!st.isEmpty()) {
            result.add(st.pop());
        }
    }

    void visitLeaves(Node root, List<Integer> result) {
        if (root == null)
            return;
        if (isLeaf(root))
            result.add(root.value);
        visitLeaves(root.left, result);
        visitLeaves(root.right, result);
    }

    void boundaryTraversal(Node root) {
        if (root == null)
            return;
        List<Integer> ls = new ArrayList<>();

        if (!isLeaf(root))
            ls.add(root.value);

        visitLeftBoundaries(root, ls);
        visitLeaves(root, ls);
        visitRightBoundaries(root, ls);

        System.out.println(ls);
    }

    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = tree.new Node(20);
        tree.root.left = tree.new Node(8);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(12);
        tree.root.left.right.left = tree.new Node(10);
        tree.root.left.right.right = tree.new Node(14);
        tree.root.right = tree.new Node(22);
        tree.root.right.right = tree.new Node(25);

        tree.boundaryTraversal(tree.root);
    }

}
