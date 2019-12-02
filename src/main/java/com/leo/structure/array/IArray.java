package com.leo.structure.array;

/**
 * 自定义数组
 */
public class IArray {
    private int data[];
    private int count;
    private int n;

    public IArray(int n) {
        this.data = new int[n];
        this.count = 0;
        this.n = n;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        data[index] = value;

        if (index == count) {
            ++count;
        }

        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        //删除索引后的元素前移
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }

        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IArray array = new IArray(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 3);
        array.printAll();
        array.insert(1, 4);
        array.insert(2, 5);
        array.insert(3, 6);
        array.insert(4, 7);
        array.insert(5, 8);
        array.printAll();
        array.delete(2);
        array.insert(4, 8);
        array.insert(5, 9);
        array.printAll();
    }

}
