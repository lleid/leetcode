package com.leo.leetcode;

public class SearchInRotatedSortedArray_33 {

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == target) {
                return i;
            }
            ++i;
        }

        return -1;
    }


    /**
     * 利用哨兵，当数组很大时，性能明显
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;

        if (nums[len - 1] == target) {
            return len - 1;
        }

        int tmp = nums[len - 1];
        nums[len - 1] = target;
        int i = 0;

        while (nums[i] != target) {
            ++i;
        }
        nums[len - 1] = tmp;

        if (i == (len - 1)) {
            return -1;
        } else {
            return i;
        }
    }

    public static void main(String[] args) {

    }
}
