package com.foue.leetcode;

public class HamingDistance461 {
    public int hammingDistance(int x, int y) {
        String str1 = Integer.toBinaryString(x);
        String str2 = Integer.toBinaryString(y);

        Integer maxLenth = str1.length() > str2.length() ? str1.length() : str2.length();
        if (str1.length() < maxLenth) {
            StringBuilder sb = new StringBuilder();
            for (int i = str1.length(); i < maxLenth; i++) {
                sb.append("0");
            }
            str1 = sb.toString() + str1;
        }
        if (str2.length() < maxLenth) {
            StringBuilder sb = new StringBuilder();
            for (int i = str2.length(); i < maxLenth; i++) {
                sb.append("0");
            }
            str2 = sb.toString() + str2;
        }

        int count = 0;
        for (int i = 0; i < maxLenth; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        HamingDistance461 hamingDistance461 = new HamingDistance461();
        hamingDistance461.hammingDistance(1, 4);
    }
}
