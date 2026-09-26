package dsa1;

//4, 5 ,0 , 1, 3, 18
//1  0  0   0  0   0
public class j_DP_LongestCommonSubSeq {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lcs = lengthOfLIS(nums);
        System.out.println("Longest common subsequence is: " + lcs);
    }

    public static int lengthOfLIS(int[] nums) {
        int ans = 0;
        int finalAns = 0;
        int length = nums.length;
        if(length == 1) return 1;

        int[] dp = new int[length];
        dp[0] = 1;

        for(int i=1; i<length; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            finalAns = Math.max(finalAns, dp[i]);
        }
        return finalAns;
    } // TC: O(n^2), SC: O(n)
}
