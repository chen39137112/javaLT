import java.util.ArrayList;

public class Q1146 {
    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(3);
//        obj.set(0,5);
        int param_2 = obj.snap();
        obj.set(0, 6);
        param_2 = obj.snap();
        param_2 = obj.snap();
        param_2 = obj.snap();
        obj.set(0, 3);
        int param_3 = obj.get(0,2);
        param_3 = obj.get(0, 3);
        param_3 = obj.get(0, 4);

        System.out.println(1);
    }

    public static class SnapshotArray {
        private ArrayList<int[]>[] arr;
        private int snapId;

        public SnapshotArray(int length) {
            arr = new ArrayList[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new ArrayList<>();
            }
            snapId = 0;
        }

        public void set(int index, int val) {
            ArrayList<int[]> idxArr = arr[index];
            int len = idxArr.size();
            if (len == 0 || idxArr.get(len-1)[0] != snapId) {
                idxArr.add(new int[]{snapId, val});
            } else {
                idxArr.get(len-1)[1] = val;
            }
        }

        public int snap() {
            snapId++;
            return snapId - 1;
        }

        public int get(int index, int snap_id) {
            ArrayList<int[]> idxArr = arr[index];
            int len = idxArr.size();
            if (len == 0 || snap_id < idxArr.get(0)[0]) {
                return 0;
            } else if (snap_id >= idxArr.get(len-1)[0]) {
                return idxArr.get(len-1)[1];
            }

            int i = 0, j = len;
            while (i < j - 1) {
                int middle = (i + j) / 2;
                int middleSnap = idxArr.get(middle)[0];
                if (snap_id > middleSnap) {
                    i = middle;
                } else if (snap_id < middleSnap) {
                    j = middle;
                } else {
                    return idxArr.get(middle)[1];
                }
            }
            return idxArr.get(i)[1];
        }
    }
}
