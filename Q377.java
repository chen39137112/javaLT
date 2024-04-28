import java.util.HashMap;

public class Q377 {
    public static void main(String[] args) {
        Q377 s = new Q377();
        int[] nums = {1,2,3};

        int ret = s.combinationSum4(nums,4);
        System.out.println(1);
    }

    private HashMap<Integer, Integer> cache;
    private int[] nums;
    public int combinationSum4(int[] nums, int target) {
        cache = new HashMap<>();
        this.nums = nums;
        return dfs(target);
    }

    private int dfs(int target) {
        if (cache.containsKey(target)) return cache.get(target);
        int ret = 0;
        for (int n : nums) {
            if (target > n) {
                ret += dfs(target - n);
            } else if (target == n) {
                ret++;
            } else continue;
        }

        cache.put(target, ret);
        return ret;
    }
}
