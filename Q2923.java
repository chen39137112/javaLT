import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q2923 {
    public static void main(String[] args) {
        Q2923 s = new Q2923();
        int[][] grid = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        int ret = s.findChampion(grid);
        System.out.println(1);
    }

    private static void dfs(Map<Integer, List<Integer>> hashMap, int key) {
        List<Integer> teams = hashMap.getOrDefault(key, null);
        if (teams == null) {
            return;
        }
        for (int team : teams) {
            dfs(hashMap, team);
        }
        hashMap.remove(key);
    }

    public int findChampion(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> teams = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                teams.add(j);
            }
            if (!teams.isEmpty()) {
                hashMap.put(i, teams);
            }
        }

        for (int i = 0; i < n; i++) {
            List<Integer> teams = hashMap.getOrDefault(i, null);
            if (teams == null) {
                continue;
            }
            for (int team : teams) {
                dfs(hashMap, team);
            }
            teams.clear();
        }
        if (hashMap.size() > 1) {
            return -1;
        }
        return -1;
    }
}
