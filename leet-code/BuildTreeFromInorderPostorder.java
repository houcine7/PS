import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPostorder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }

        return buildRecursive(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, mp);
    }

    public TreeNode buildRecursive(int[] inorder, int[] postorder,
            int inorderStart, int inOrderEnd, int postorderStart, int postOrderEnd,
            Map<Integer, Integer> inorderIndexes) {

        if (inorderStart > inOrderEnd || postorderStart > postOrderEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postOrderEnd]);

        int indexCurrentRoot = inorderIndexes.get(root.val);
        buildRecursive(inorder, postorder, inorderStart, indexCurrentRoot - 1,
                postorderStart, postOrderEnd - (inOrderEnd - indexCurrentRoot) - 1, inorderIndexes);

        buildRecursive(inorder, postorder, indexCurrentRoot + 1,
                inOrderEnd, postOrderEnd - (inOrderEnd - indexCurrentRoot), postOrderEnd - 1, inorderIndexes);

        return root;

    }

    public static void main(String[] args) {
        BuildTreeFromInorderPostorder b = new BuildTreeFromInorderPostorder();
        b.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
    }

}
