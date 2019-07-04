package com.foue.leetcode;

public class JewelsAndStones771 {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.toCharArray().length; i++) {
            String js = String.valueOf(J.charAt(i));
            for (int k = 0; k < S.toCharArray().length; k++) {
                String ss = String.valueOf(S.charAt(k));
                if (js.equals(ss)) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones771 jewelsAndStones771 = new JewelsAndStones771();
        int count = jewelsAndStones771.numJewelsInStones("z", "ZSZZ");
        System.out.println(count);
    }
}
