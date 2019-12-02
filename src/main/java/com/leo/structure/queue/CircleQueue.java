package com.leo.structure.queue;

/**
 * 循环队列
 */
public class CircleQueue {

    private String[] items;
    private int n;
    private int head;
    private int tail;

    public CircleQueue(int n) {
        items = new String[n];
        this.n = n;
        this.head = 0;
        this.tail = 0;
    }


    /**
     * 入队
     *
     * @param item
     */
    public boolean enqueue(String item) {
        //队列已满 (tail+1)%n ==head
        if ((tail + 1) % n == head) {
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) return null;
        String tmp = items[head];

        head = (head + 1) % n;
        return tmp;
    }
}
