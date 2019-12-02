package com.leo.structure.stack;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 链表栈
 */
public class LinkedListStack {

    private Node top;

    /**
     * 入栈
     *
     * @param data
     */
    public void push(String data) {
        Node n = new Node(data, null);
        if (top == null) {
            top = n;
        } else {
            n.next = top;
            top = n;//始终保持top是最新数据
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (top == null) return null;
        String data = top.getData();
        top = top.next;
        return data;
    }

    /**
     * 打印
     *
     * @return
     */
    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Data
    @AllArgsConstructor
    private static class Node {
        private String data;
        private Node next;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
