package com.leo.leetcode;

import java.util.Arrays;

public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return explain(nums);
    }

    public TreeNode explain(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(max);
        if (nums.length > 1) {
            treeNode.left = explain(Arrays.copyOfRange(nums, 0, maxIndex));
            treeNode.right = explain(Arrays.copyOfRange(nums, maxIndex+1, nums.length));
        }
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MaximumBinaryTree_654 test = new MaximumBinaryTree_654();
        test.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
