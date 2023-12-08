package day_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static class Node {
        String root;
        String left;
        String right;

        public Node(String root, String left, String right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

        public String getLeft() {
            return left;
        }

        public String getRight() {
            return right;
        }

        public String getRoot() {
            return root;
        }

        @Override
        public String toString() {

            return this.left + "->" + this.root + "<-" + this.right;
        }
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

            Map<String, Node> map = new HashMap<>();
            for (int i = 2; i < lines.size(); i++) {
                //

                String item = lines.get(i);
                String root = item.split(" = ")[0];
                String temp = removeParentheses(item.split(" = ")[1]);
                String left = temp.split(", ")[0];
                String right = temp.split(", ")[1];
                map.put(root, new Solution.Node(root, left, right));
            }

            String curr = "AAA";
            int it = 0;
            int counter = 0;
            while (!curr.equals("ZZZ")) {
                // System.out.println(curr);
                if (it >= directions.length()) {
                    it = 0;
                }

                char direction = directions.charAt(it);
                if (direction == 'L') {
                    curr = map.get(curr).left;
                    it++;
                } else if (direction == 'R') {
                    curr = map.get(curr).right;
                    it++;
                }
                counter++;
            }

            System.out.println(map);
            System.out.println(counter);

            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println();
            e.printStackTrace();
        }
    }

}
