package com.example.doinglab.decode;

import java.util.Stack;

public class Solution {

    private String str;
    private Stack<Integer> stack = new Stack<>();

    public String decodeString(String s) {
        str = s;
        setDigitIndex();
        decodeString();

        return str;
    }

    private void setDigitIndex() {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                stack.push(i);
            }
        }
    }

    private void decodeString() {
        while (!stack.isEmpty()) {
            int digitIdx = stack.pop();
            int closeIdx = closeIdx(digitIdx);
            String encoded = str.substring(digitIdx, closeIdx + 1);
            String decoded = decoded(encoded);
            str = str.replace(encoded, decoded);
        }
    }

    private int closeIdx(int digitIdx) {
        for (int i = digitIdx; i < str.length(); i++) {
            if (str.charAt(i) == ']') {
                return i;
            }
        }

        return -1;
    }

    private String decoded(String encoded) {
        int cnt = encoded.charAt(0) - '0';
        String subStr = encoded.substring(2, encoded.length() - 1);

        return repeat(subStr, cnt);
    }

    private String repeat(String str, int cnt) {
        StringBuilder sb = new StringBuilder();
        while (cnt-- > 0) {
            sb.append(str);
        }

        return sb.toString();
    }

}