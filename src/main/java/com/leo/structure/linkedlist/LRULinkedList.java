package com.leo.structure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

public class LRULinkedList {

    private Node top;
    private int size;
    private int count;

    public LRULinkedList(int size) {
        this.size = 10;
    }

    public void add(String str) {
        Node node = new Node(str, null);

        if (count == 0) {
            top = node;
            ++count;
        } else {
            node.next = top;
            Node pre = findPreNode(node);
            if (pre == null) {
                if (count == size) {
                    deleteEndNode(node);
                } else {
                    top = node;
                    ++count;
                }
            } else {
                Node tmp = pre.next;
                pre.next = tmp.next;
                top = node;
            }
        }
    }

    public Node findPreNode(Node node) {
        while (node != null) {
            if (node.getData().equals(node.getData())) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void deleteEndNode(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = null;
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

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList(5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            list.add(scanner.nextLine());
            list.printAll();
        }
    }

    @Data
    @AllArgsConstructor
    private static class Node {
        private String data;
        private Node next;
    }
}

