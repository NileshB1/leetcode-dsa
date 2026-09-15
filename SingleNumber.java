package com.test.lambda;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 9, 12, 12, 5, 7, 9};
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            result = result ^ nums[i];
        }
        System.out.println("Single number is: " + result);
    }
}
