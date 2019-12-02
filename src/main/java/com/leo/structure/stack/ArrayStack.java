package com.leo.structure.stack;

/**
 * 顺序栈
 * 后进先出
 */
public class ArrayStack {
    private String[] items;
    private int count;
    private int n;

    /**
     * 初始化容量
     *
     * @param len
     */
    public ArrayStack(int len) {
        this.items = new String[len];
        this.count = 0;
        this.n = len;
    }

    /**
     * 入栈
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        if (count == n) {
            return false;
        }

        items[count++] = item;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        return items[--count];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
