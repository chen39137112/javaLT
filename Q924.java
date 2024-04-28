import java.util.*;
import static java.util.Arrays.stream;

public class Q924 {
    public static void main(String[] args) {
        Q924 s = new Q924();
        int[][] graph = {{1,0,0,0,1,0,0,0,0,0,1},
                         {0,1,0,1,0,0,0,0,0,0,0},
                         {0,0,1,0,0,0,0,1,0,0,0},
                         {0,1,0,1,0,1,0,0,0,0,0},
                         {1,0,0,0,1,0,0,0,0,0,0},
                         {0,0,0,1,0,1,0,0,1,1,0},
                         {0,0,0,0,0,0,1,1,0,0,0},
                         {0,0,1,0,0,0,1,1,0,0,0},
                         {0,0,0,0,0,1,0,0,1,0,0},
                         {0,0,0,0,0,1,0,0,0,1,0},
                         {1,0,0,0,0,0,0,0,0,0,1}};
        int[] initial = {7,8,6,2,3};
        int ret = s.minMalwareSpread(graph, initial);
        System.out.println(1);
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        HashMap<Integer, HashSet<Integer>> mp = new HashMap<Integer, HashSet<Integer>>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            for (int j = 0; j < i; j++) {
                if (graph[i][j] != 1) {
                    continue;
                }
                set.addAll(mp.get(j));
                for (int p : mp.get(j)) {
                    mp.replace(p, set);
                }
            }
            mp.put(i, set);
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int ret = 301;
        int count = 0;
        for (int p : initial) {
            if (ret > p) {
                ret = p;
            }
            set.add(p);
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(i) || mp.get(i).size() <= count || hasDuplicates(set, mp.get(i))) {
                continue;
            }
            ret = i;
            count = mp.get(i).size();
        }
        return ret;
    }

    public static boolean hasDuplicates(Set<?> set1, Set<?> set2) {
        Set<Object> combinedSet = new HashSet<>(set1);
        combinedSet.addAll(set2);
        return combinedSet.size() + 1 != (set1.size() + set2.size());
    }
}
