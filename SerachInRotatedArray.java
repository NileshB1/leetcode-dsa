package com.test.lambda;

/**
 * #18. Search in rotated sorted array
 * #e.g. 0 1 2 3 => 1 2 3 0 => 2 3 0 1 => 3 0 1 2
 * # 6 7 8 9 0 1 2 3 4 5 target = 4
 * #clue: Modify binary serach. Find sorted portion in array (L->M or M->R)
 * #1. binary serach, find sorted part
 * #2. Check whther target in sorted part if no discard and continue
 */
public class SerachInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
        int target = 4;
        int index = binarySearchInSortedArray(arr, target);
        System.out.println("Index of target: "+ target + " is :" + index);

    }

    public static int binarySearchInSortedArray(int[] arr, int target) {
        int left = 0, right = arr.length-1, mid = 0;
        while(left <= right) {
            mid = left+(right-left)/2;
            if(arr[mid]==target) {
                return mid;
            } else if(arr[left] < arr[mid]) {
                if(arr[left] <= target && target < arr[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else if(arr[mid] < target && target <= arr[right]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
