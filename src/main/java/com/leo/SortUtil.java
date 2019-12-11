package com.leo;

import java.util.Arrays;

public class SortUtil {
    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 9, 1, 5, 6, 4, 2};
//        bubbleSort(array, 8);
//        insertionSort(array, 8);
//        selectionSort(array, 8);
//        mergeSort(array, 8);
        quickSort(array, 8);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param data
     * @param n
     */
    public static void bubbleSort(int[] data, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param data
     * @param n
     */
    public static void insertionSort(int[] data, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            for (int j = i; (j > 0) && data[j] < data[j - 1]; j--) {
                int tmp = data[j];
                data[j] = data[j - 1];
                data[j - 1] = tmp;
            }
        }
    }

    /**
     * 选择 排序
     *
     * @param data
     * @param n
     */
    public static void selectionSort(int[] data, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
    }

    /**
     * 归并排序
     *
     * @param data
     * @param n
     */
    public static void mergeSort(int[] data, int n) {
        merge(data, 0, n - 1);
    }

    /**
     * 快速排序
     *
     * @param data
     * @param n
     */
    public static void quickSort(int[] data, int n) {
        quickSortInternally(data, 0, n - 1);
    }

    private static void quickSortInternally(int[] data, int p, int r) {
        if (p >= r) return;

        int q = partition(data, p, r); // 获取分区点
        quickSortInternally(data, p, q - 1);
        quickSortInternally(data, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     *
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    private static void merge(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            merge(nums, low, mid);
            // 右边
            merge(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
    }

    /**
     * 将数组中low到high位置的数进行排序
     *
     * @param nums 待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     * @param high 待排结束位置
     */
    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
