package com.leo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

    public static boolean isValid(String s) {
        Map<String, String> vps = new HashMap<String, String>();
        vps.put("(", ")");
        vps.put("{", "}");
        vps.put("[", "]");

        if (s == null) {
            return false;
        }

        if (s.length() > 0 && vps.containsValue(String.valueOf(s.charAt(0)))) {
            return false;
        }
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < s.length(); i++) {
            String value = String.valueOf(s.charAt(i));
            if (vps.containsKey(value)) {
                stack.push(value);
            } else if (vps.containsValue(value)) {
                if (stack.size() == 0) {
                    return false;
                }
                String tmp = stack.pop();
                if (!vps.get(tmp).equals(value)) {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        isValid("]");
    }
}
