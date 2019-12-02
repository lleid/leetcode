package com.leo.structure.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 链表队列
 */
public class LinkedListQueue {

    private Node head;
    private Node tail;

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(String item) {
        if (tail == null) {
            Node node = new Node(item, null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }

        String value = head.getData();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    /**
     * 打印
     */
    public void printAll() {
        Node p = head;
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
}
