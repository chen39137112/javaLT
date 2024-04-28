import java.util.ArrayList;

public class Q1017 {
    public static void main(String[] args) {
        Q1017 s = new Q1017();
        String ret = s.baseNeg2(4);
        System.out.println(1);
    }

    public String baseNeg2(int n) {
        if (n == 0) return "0";
        ArrayList<Integer> binArr = new ArrayList<>();
        int bitNum = 0;

        while (n > 0) {
            binArr.add(n & 1);
            if ((bitNum & 1) == 1) {
                n += (n & 1);
            } else {
                n -= (n & 1);
            }
            n >>= 1;
            bitNum++;
        }

        String ret = "";
        for (int i = binArr.size() - 1; i >= 0 ; i--) {
            ret = ret.concat(binArr.get(i) == 0 ? "0" : "1");
        }
        return ret;
    }
}
