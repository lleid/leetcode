package com.foue.leetcode;

public class SearchInsertPosition35 {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        if (nums[n - 1] < target) {
            return n;
        } else if (nums[n - 1] == target) {
            return --n;
        }
        int i = 0;
        while (i < n) {
            if (nums[i] >= target) {
                return i;
            }
            ++i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 6};
        int i = searchInsert(ints, 5);
        System.out.println(i);
    }
}
