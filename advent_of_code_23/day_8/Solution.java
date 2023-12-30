package day_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static class Node {
        String val;
        Node left;
        Node right;

        public Node(String value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public String toString() {

            return this.left.val + "->" + this.val + "<-" + this.right.val;
        }
    }

    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++)
            result = lcm(result, input[i]);
        return result;
    }

    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    // parentheses
    public static String removeParentheses(String str) {
        return str.replaceAll("\\(", "").replaceAll("\\)", "");
    }

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            List<String> lines = br.lines().toList();

            String directions = lines.get(0);

            Map<String, Node> map_nodes = new HashMap<>();

            List<Node> starting_nodes = new ArrayList<>();
            List<Node> ending_nodes = new ArrayList<>();

            for (int i = 2; i < lines.size(); i++) {
                //
                String item = lines.get(i);
                String node_val = item.split(" = ")[0];

                String temp = removeParentheses(item.split(" = ")[1]);
                String left = temp.split(", ")[0];
                String right = temp.split(", ")[1];

                Node parentNode = map_nodes.computeIfAbsent(node_val, Node::new);

                Node leftChild = map_nodes.computeIfAbsent(left, Node::new);
                Node rightChild = map_nodes.computeIfAbsent(right, Node::new);

                parentNode.left = leftChild;
                parentNode.right = rightChild;

            }

            for (String vl : map_nodes.keySet()) {
                if (vl.endsWith("A")) {
                    starting_nodes.add(map_nodes.get(vl));
                }
                if (vl.endsWith("Z")) {
                    ending_nodes.add(map_nodes.get(vl));
                }
            }

            char[] steps = directions.toCharArray();
            // Node currNode = map_nodes.get("AAA");

            long counter = 0;

            // PART 1: Simple mapping

            /*
             * for (int i = 0; i < steps.length; i++) {
             * counter++;
             * 
             * if (steps[i] == 'L') {
             * currNode = currNode.left;
             * } else {
             * currNode = currNode.right;
             * }
             * 
             * if (currNode.val.equals("ZZZ")) {
             * 
             * System.out.println("THE COUNTER IS: " + counter);
             * break;
             * }
             * 
             * if (i == steps.length - 1) {
             * i = -1;
             * }
             * }
             */

            // PART2 :
            List<Long> result = new ArrayList<>();

            for (int i = 0; i < steps.length; i++) {
                counter++;
                // boolean allInEnding = true;
                List<Node> tmp = new ArrayList<>();

                if (starting_nodes.isEmpty()) {
                    System.out.println(lcm(result.stream().mapToLong(r -> r).toArray()));
                    break;
                }

                for (Node root_nodes : starting_nodes) {
                    if (steps[i] == 'L') {
                        root_nodes = root_nodes.left;
                    } else {
                        root_nodes = root_nodes.right;
                    }

                    if (ending_nodes.contains(root_nodes)) {
                        result.add(counter);
                    } else {
                        tmp.add(root_nodes);

                    }
                }

                starting_nodes = tmp;
                if (i == steps.length - 1) {
                    i = -1;
                }

            }

            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println();

            e.printStackTrace();
        }
    }
}
