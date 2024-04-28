import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        int i = 1;
        int len = nums.length;

        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while (i < len) {
            ArrayList<TreeNode> tmp = new ArrayList<>();
            for (TreeNode n : nodes) {
                if (i == len) break;
                if (nums[i] != null) {
                    n.left = new TreeNode(nums[i]);
                    tmp.add(n.left);
                }
                i++;
                if (i == len) break;
                if (nums[i] != null) {
                    n.right = new TreeNode(nums[i]);
                    tmp.add(n.right);
                }
                i++;
            }
            nodes = tmp;
        }
        return root;
    }
}
