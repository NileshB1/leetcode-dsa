package dsa1;

import java.util.Arrays;

public class d_DP_PartitionSubArray_Equal_Sum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        // 1 5 11 5
        //[0 1 2 3 4 5 6 7 8 9 10 11]
        //[T F F F F F F F F F F  F]
        boolean isEqualPartition = equalPartition(arr);
        System.out.println("Can array partition into two equal sum subarray? : " +isEqualPartition );
    }

    public static boolean equalPartition(int[] arr) {
        int len = arr.length;
        int total = Arrays.stream(arr).sum();
        if(total %2==1) {
            return false;
        }
        int target = total/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0; i<arr.length; i++) {
            for(int curr = dp.length-1; curr >= 1; curr--) {
                if(curr >= arr[i]) {
                    dp[curr] = dp[curr] || dp[curr - arr[i]];
                }
            }

        }

        return dp[target];
    }
}
