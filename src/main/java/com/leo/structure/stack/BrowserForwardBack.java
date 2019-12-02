package com.leo.structure.stack;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 使用栈实现 浏览器 前进 后退
 */
public class BrowserForwardBack {

    private String url;
    private LinkedListStack forwardStack;
    private LinkedListStack backStack;

    public BrowserForwardBack() {
        this.forwardStack = new LinkedListStack();
        this.backStack = new LinkedListStack();
    }

    public void open(String url) {
        this.url = url;
        backStack.push(url);
        show(url, "show");
    }

    public void show(String url, String act) {
        System.out.println(url + " " + act);
    }

    public void forward() {
        if (canForward()) {
            String furl = forwardStack.pop();
            backStack.push(furl);
            show(furl, "forward");
        } else {
            System.out.println("can not forward");
        }
    }


    public void back() {
        if (canBack()) {
            String burl = backStack.pop();
            forwardStack.push(burl);
            show(burl, "back");
        } else {
            System.out.println("can not back");
        }
    }

    public boolean canForward() {
        return forwardStack.size > 0;
    }

    public boolean canBack() {
        return backStack.size > 0;
    }

    public static void main(String[] args) {
        BrowserForwardBack browser = new BrowserForwardBack();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");

        browser.forward();

        browser.back();
        browser.back();

        browser.forward();
        browser.forward();
        browser.forward();

        browser.back();
        browser.back();
    }

    private static class LinkedListStack {

        private Node top;
        private int size = 0;

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
            this.size++;
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
            if (size > 0) {
                this.size--;
            }
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
                System.out.println(p.getData());
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
}
