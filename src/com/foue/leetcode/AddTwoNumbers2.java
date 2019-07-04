package com.foue.leetcode;

public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int count) {
        if (l1 == null && l2 == null && count == 0) {
            return null;
        }
        if (l1 == null && l2 == null && count != 0) {
            return new ListNode(count);
        }
        int sub = 0;
        ListNode n1 = null;
        ListNode n2 = null;
        if (l1 != null) {
            sub += l1.val;
            n1 = l1.next;
        }
        if (l2 != null) {
            sub += l2.val;
            n2 = l2.next;
        }
        sub += count;

        ListNode listNode = new ListNode(sub);
        if (listNode.val > 9) {
            listNode.val = listNode.val - 10;
            listNode.next = addTwoNumbers(n1, n2, 1);
        } else {
            listNode.next = addTwoNumbers(n1, n2, 0);
        }

        return listNode;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(8);
        l1.next = l2;
        ListNode l4 = new ListNode(0);

        ListNode listNode = addTwoNumbers(l1, l4);
        System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


