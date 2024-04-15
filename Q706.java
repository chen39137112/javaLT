import java.util.Arrays;

class MyHashMap {
    private int[] buket;
    public MyHashMap() {
        buket = new int[1000000];
        Arrays.fill(buket, -1);
    }

    public void put(int key, int value) {
        buket[key] = value;
    }

    public int get(int key) {
        return buket[key];
    }

    public void remove(int key) {
        buket[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class Q706 {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,2);
        int param_1 = obj.get(1);
        obj.remove(1);
        param_1 = obj.get(1);
        System.out.println(param_1);
    }
}
