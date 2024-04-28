public class Q2739 {
    public static void main(String[] args) {
        Q2739 s = new Q2739();
        int ret = s.distanceTraveled(9, 3);
        System.out.println(1);
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int ret = 0;
        while (mainTank >= 5) {
            ret += mainTank / 5 * 50;
            int addTank = Math.min(mainTank / 5, additionalTank);
            mainTank = addTank + mainTank % 5;
            additionalTank -= addTank;
        }
        return ret + mainTank * 10;
    }
}
