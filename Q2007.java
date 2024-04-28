import java.util.Arrays;
import java.util.HashSet;

public class Q2007 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] changed = {0,0,0,0};

        int[] ret = s.findOriginalArray(changed);
        System.out.println(1);
    }

    private static class Solution {
        public int[] findOriginalArray(int[] changed) {
            int len = changed.length;
            if ((len & 1) == 1) return new int[0];

            Arrays.sort(changed);
            int[] ret = new int[len / 2];
            HashSet<Integer> set = new HashSet<>();
            int i = 0, j = 1, retIdx = 0;

            while (j < len) {
                if (set.contains(i)) {
                    i++;
                    if (i == j) j++;
                    continue;
                }

                int dValue = changed[i] * 2;
                if (dValue == changed[j]) {
                    set.add(j);
                    ret[retIdx] = changed[i];
                    i++;
                    j++;
                    retIdx++;
                } else if (dValue > changed[j]) {
                    j++;
                } else {
                    return new int[0];
                }
            }
            return (retIdx == len / 2) ? ret : new int[0];
        }
    }
}
