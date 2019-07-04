package com.foue.leetcode;

public class MergeTwoBinaryTrees617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return count(t1, t2);
    }


    public TreeNode count(TreeNode t1, TreeNode t2) {
        TreeNode node = null;

        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            if (t1 != null) {
                node = new TreeNode(t1.val);
            }
            if (t2 != null) {
                node = new TreeNode(t2.val);
            }
        } else {
            node = new TreeNode(t1.val + t2.val);
        }

        TreeNode left = count(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        TreeNode right = count(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        if (left != null) {
            node.left = left;
        }
        if (right != null) {
            node.right = right;
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);


        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(3);


        t1.left = t2;
        t2.left = t3;


        t5.right = t6;
        t6.right = t7;

        MergeTwoBinaryTrees617 mergeTwoBinaryTrees617 = new MergeTwoBinaryTrees617();
        TreeNode treeNode = mergeTwoBinaryTrees617.mergeTrees(t1, t5);
        System.out.println("123");
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
