package Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDifLevels {
    public class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinaryTreeDifLevels() {
        this.root = null;
    }

    // calculate the difference between sum of
    // odd an even levels of binary tree
    public int difference() {
        int sumOddLevel = 0, sumEvenLevel = 0;

        // counts the num of node in each level
        int nodesLevel = 0;

        Queue<Node> queue = new LinkedList<>();

        if (this.root == null)
            return 0;

        queue.add(root);
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            nodesLevel = queue.size();
            while (nodesLevel > 0) {
                System.out.println("here");
                Node n = queue.poll();
                if (currentLevel % 2 == 0)
                    sumEvenLevel += n.value;
                else
                    sumOddLevel += n.value;
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
                nodesLevel--;
            }
            currentLevel++;
        }

        return Math.abs(sumEvenLevel - sumOddLevel);

    }

    public static void main(String[] args) {
        BinaryTreeDifLevels bt = new BinaryTreeDifLevels();
        bt.root = new BinaryTreeDifLevels().new Node(1);
        bt.root.left = new BinaryTreeDifLevels().new Node(2);
        bt.root.right = new BinaryTreeDifLevels().new Node(3);
        bt.root.left.left = new BinaryTreeDifLevels().new Node(4);
        bt.root.right.left = new BinaryTreeDifLevels().new Node(5);
        bt.root.right.right = new BinaryTreeDifLevels().new Node(6);
        System.out.println("Difference between sum of odd level and even level nodes: " + bt.difference());
    }

}