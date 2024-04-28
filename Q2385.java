import java.util.ArrayList;
import java.util.Map;

public class Q2385 {
    public static void main(String[] args) {
        Q2385 s = new Q2385();
        Integer[] nums = {1, 5, 3, null, 4, 10, 6, 9, 2};
        TreeNode root = TreeNode.buildTree(nums);

        int ret = s.amountOfTime(root, 3);
        System.out.println(1);
    }

    public int amountOfTime(TreeNode root, int start) {
        return dfs(root, start, new int[]{Integer.MAX_VALUE});
    }

    private int dfs(TreeNode node, int start, int[] r2sHgt) {
        if (node == null) {
            return 0;
        }
        if (node.val == start) {
            r2sHgt[0] = 0;
            return Math.max(dfs(node.left, start, new int[]{Integer.MAX_VALUE}),
                    dfs(node.right, start, new int[]{Integer.MAX_VALUE}));
        }

        int[] lr2s = {Integer.MAX_VALUE}, rr2s = {Integer.MAX_VALUE};
        int left = dfs(node.left, start, lr2s);
        int right = dfs(node.right, start, rr2s);
        if (lr2s[0] < rr2s[0]) {
            r2sHgt[0] = lr2s[0] + 1;
            return Math.max(left, r2sHgt[0] + right);
        } else if (lr2s[0] > rr2s[0]) {
            r2sHgt[0] = rr2s[0] + 1;
            return Math.max(right, r2sHgt[0] + left);
        } else {
            return Math.max(left + 1, right + 1);
        }
    }
}
