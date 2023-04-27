import java.util.Arrays;

public class CoinWeighing {
    public static int findHeavierCoin(int[] coins) {
        int n = coins.length;
        if (n == 1) {
            return coins[0];
        } else {
            int groupSize = n / 3;
            int[] groupA = Arrays.copyOfRange(coins, 0, groupSize);
            int[] groupB = Arrays.copyOfRange(coins, groupSize, 2 * groupSize);
            int[] groupC = Arrays.copyOfRange(coins, 2 * groupSize, n);
            int result = weigh(groupA, groupB);
            if (result == 0) {
                return findHeavierCoin(groupC);
            } else if (result > 0) {
                return findHeavierCoin(groupA);
            } else {
                return findHeavierCoin(groupB);
            }
        }
    }
    public static int weigh(int[] coins1, int[] coins2) {
        int weight1 = 0;
        for (int i = 0; i < coins1.length; i++) {
            weight1 += coins1[i];
        }
        int weight2 = 0;
        for (int i = 0; i < coins2.length; i++) {
            weight2 += coins2[i];
        }
        if (weight1 == weight2) {
            return 0;
        } else if (weight1 < weight2) {
            return -1;
        } else {
            return 1;
        }
    }
}
