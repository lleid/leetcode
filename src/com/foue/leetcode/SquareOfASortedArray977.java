package com.foue.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SquareOfASortedArray977 {
    public int[] sortedSquares(int[] A) {
        int[] newIntArr = new int[A.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i] * A[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            newIntArr[i] = list.get(i);
        }

        return newIntArr;
    }

    public static void main(String[] args) {
        SquareOfASortedArray977 array = new SquareOfASortedArray977();
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        int[] arrPow = array.sortedSquares(arr);
        System.out.println(arrPow);
    }
}
