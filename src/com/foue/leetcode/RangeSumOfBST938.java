package com.foue.leetcode;

public class RangeSumOfBST938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        return toCount(root, L, R);
    }

    public int toCount(TreeNode root, int L, int R) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (L <= root.val && root.val <= R) {
            count += root.val;
        }
        int leftCount = toCount(root.left, L, R);
        int rightCount = toCount(root.right, L, R);

        count += leftCount;
        count += rightCount;
        return count;
    }

    public static void main(String[] args) {
        TreeNode t1 = null;
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(18);
        t2.left = t1;
        t2.right = t3;
        t3.left = t4;
        t3.right = t5;
        t4.left = t6;
        t4.right = t7;
        RangeSumOfBST938 test = new RangeSumOfBST938();
        int count = test.rangeSumBST(t2, 7, 15);
        System.out.println(count);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

