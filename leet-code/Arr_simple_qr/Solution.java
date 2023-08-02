package Arr_simple_qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int val;
    int ht;
    Node left;
    Node right;

    Node(int d) {
        val = d;
        ht = 0;
        left = null;
        right = null;
    }

    Node() {
        val = 0;
        ht = 0;
        left = null;
        right = null;
    }
}

public class Solution {

    public static Node insert(Node root, int val) {

        Node ins = new Node();
        ins.val = val;

        if (root == null) {

            ins.ht = 1;
            root = ins;
            return root;

        } else if (val < root.val) {

            root.left = insert(root.left, val);

        } else if (val > root.val) {
            root.right = insert(root.right, val);

        }
        root.ht = 1 + Math.max(height(root.left), height(root.right));
        int bf = height(root.left) - height(root.right);
        if (bf > 1 && val < root.left.val)
            return rightRotate(root);
        else if (bf > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        } else if (bf < -1 && val > root.right.val) {

            return leftRotate(root);

        } else if (bf < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static int height(Node root) {
        if (root == null)
            return -1;
        else
            return root.ht;

    }

    public static Node rightRotate(Node z) {
        Node y = z.left;
        z.left = y.right;
        y.right = z;
        z.ht = 1 + Math.max(height(z.left), height(z.right));
        y.ht = 1 + Math.max(height(y.left), height(y.right));
        return y;

    }

    public static Node leftRotate(Node z) {
        Node y = z.right;
        z.right = y.left;
        y.left = z;
        z.ht = 1 + Math.max(height(z.left), height(z.right));
        y.ht = 1 + Math.max(height(y.left), height(y.right));

        return y;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            String sizes = bf.readLine();
            int n = Integer.parseInt(sizes.split(" ")[0]);
            int m = Integer.parseInt(sizes.split(" ")[1]);
            boolean who = true;

            String nums = bf.readLine();
            int[] arr = new int[n];
            int[] tempArr = new int[n];
            for (int i = 0; i < nums.split(" ").length; i++) {
                arr[i] = Integer.parseInt(nums.split(" ")[i]);
            }
            List<List<Integer>> queires = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] str = bf.readLine().split(" ");
                int type = Integer.parseInt(str[0]);
                int start = Integer.parseInt(str[1]) - 1;
                int end = Integer.parseInt(str[2]) - 1;

                if (type == 1) {
                    int k = start;
                    int j = 0;
                    while (k <= end) {

                        if (who) {
                            tempArr[j++] = arr[k++];
                        } else {
                            arr[j++] = tempArr[k++];
                        }

                    }
                    int iter = 0;
                    while (iter < start) {
                        if (who) {
                            tempArr[j++] = arr[iter++];
                        } else {
                            arr[j++] = tempArr[iter++];
                        }
                    }
                    int iter2 = end + 1;
                    while (iter2 < n) {
                        if (who) {
                            tempArr[j++] = arr[iter2++];
                        } else {
                            arr[j] = tempArr[iter2++];
                        }
                    }

                    who = !who;
                } else {
                    int k = 0, j = 0;

                    while (k < start) {
                        if (who) {
                            tempArr[j++] = arr[k++];
                        } else {
                            arr[j++] = tempArr[k++];
                        }
                    }

                    int l = end + 1;
                    while (l < n) {
                        if (who) {
                            tempArr[j++] = arr[l++];
                        } else {
                            arr[j++] = tempArr[l++];
                        }
                    }

                    k = start;
                    while (k <= end) {
                        if (who) {
                            tempArr[j++] = arr[k++];
                        } else {
                            arr[j++] = tempArr[k++];
                        }
                    }
                    who = !who;
                }
                if (who) {
                    System.out.println(Math.abs(arr[0] - arr[n - 1]));
                } else {
                    System.out.println(Math.abs(tempArr[0] - tempArr[n - 1]));
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

// public static void preOrder(Node root) {
// if (root == null) {
// return;
// }
// System.out.print(root.val + ":" + root.ht + " , ");
// preOrder(root.left);
// preOrder(root.right);
// }
