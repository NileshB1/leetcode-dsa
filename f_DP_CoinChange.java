package dsa1;

public class f_DP_CoinChange {
    public static void main(String[] args) {
        // 1 2 5
        // 0 1 2 3 4 5 6
        // 0 1
        // for 1:
        // 1-1 = 0 -> dp[0] = 0 -> Min(Integer.MAX_VALUE, 0) = 0
        // 1 - 2 -> No possible
        // 1 - 5 -> Not possible
        // dp[1] = 1+0 = 1
        int[] coins = {1, 2, 5};
        int amount = 6;
        int minCoins = findMinCoins(coins, amount);
        System.out.println("Minimum numbers of coins required for amount: " + amount + ", is: " + minCoins);
    }

    public static int findMinCoins(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1;  i <= dp.length-1; i++) {
            int minimum = Integer.MAX_VALUE;
            for(int j=0; j < coins.length; j++) {
                if(i >= coins[j] && dp[i - coins[j]] != -1) {
                    int rem = i - coins[j];
                    minimum = Math.min(minimum, dp[rem]);
                }
            }
            dp[i] = (minimum == Integer.MAX_VALUE) ? -1 : minimum + 1;
        }
        return dp[amount];
    }
}
