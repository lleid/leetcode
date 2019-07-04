package com.foue.leetcode;

public class ToSum1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] indexArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int k = (i + 1); k < nums.length; k++) {
                if ((nums[i] + nums[k]) == target) {
                    indexArray[0] = i;
                    indexArray[1] = k;
                }
            }
        }
        return indexArray;
    }

    public static void main(String[] args) {
        int[] indexArray = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(indexArray[0] + "," + indexArray[1]);
    }
}
