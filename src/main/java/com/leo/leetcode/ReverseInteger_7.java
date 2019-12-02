package com.leo.leetcode;

public class ReverseInteger_7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String str = String.valueOf(Math.abs(x));
        int sign = x / Math.abs(x);
        try {
            String newStr = new StringBuilder(str).reverse().toString();

            return Integer.parseInt(newStr) * sign;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger_7 reverseInteger7 = new ReverseInteger_7();
        reverseInteger7.reverse(1534236469);
    }
}
