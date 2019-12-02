package com.leo.structure.queue;

/**
 * 顺序队列
 */
public class ArrayQueue {
    private String[] items;
    private int head = 0;
    private int tail = 0;
    private int n;


    public ArrayQueue(int len) {
        this.items = new String[len];
        this.n = len;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        //队列已满 tail==n
        if (tail == n) {
            if (head == 0) {
                return false;
            }

            //数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }

            //更新head,tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        //队列为空 head==tail
        if (head == tail) return null;
        String tmp = items[head];
        ++head;
        return tmp;
    }
}
