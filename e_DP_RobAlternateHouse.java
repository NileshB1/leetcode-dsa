package dsa1;

public class e_DP_RobAlternateHouse {
    public static void main(String[] args) {
        //4 , 3, 0, 9,  1
        //4   4  4  13  13
        int[] nums = {4 ,3, 0, 9, 1};
        int maxRobVal = robs(nums);
        System.out.println("Max rob val is: " + maxRobVal);
    }

    public static int robs(int[] nums) {
        // base cases
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i < nums.length; i++) {
            int rob = nums[i] + dp[i-2];
            int notRob = dp[i-1];
            int val = Math.max(rob, notRob);
            dp[i] = val;
        }
        return dp[nums.length-1];
    }
}
