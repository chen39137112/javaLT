import java.util.Arrays;
import java.util.HashSet;

public class Q1883 {
    public static void main(String[] args) {
        Q1883 s = new Q1883();
        int[] dist = {7,3,5,5};

        int ret = s.minSkips(dist, 2, 10);
        System.out.println(1);
    }


    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int len = dist.length;
        int[] newDist = new int[len];
        for (int i = 0; i < len; i++) {
            hoursBefore -= (dist[i] + speed - 1) / speed;
            newDist[i] = dist[i] % speed;
        }
        if (hoursBefore >= 0) return 0;

        int ret = 0;
        return -1;

    }
}
