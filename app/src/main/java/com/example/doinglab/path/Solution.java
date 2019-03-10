package com.example.doinglab.path;

import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static final String INVALID = "INVALID";
    private final String SEPARATOR = "/";
    private final String CURRENT = ".";
    private final String UPPER = "..";

    private Stack<String> stack = new Stack<>();
    private String result;

    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return INVALID;
        }

        String first = String.valueOf(path.charAt(0));
        if (!first.equals(SEPARATOR)) {
            return INVALID;
        }

        this.result = path + SEPARATOR;
        removeSeparatorOverlap();
        removeCurrent();
        setUpperByStack();
        setPathByStack();

        return result;
    }

    private void removeSeparatorOverlap() {
        while (true) {
            String overlap = overlap();
            if (overlap == null) {
                break;
            }

            result = result.replace(overlap, SEPARATOR);
        }
    }

    private String overlap() {
        String overlap = SEPARATOR + SEPARATOR;
        int startIdx = result.indexOf(overlap);
        if (startIdx == -1) {
            return null;
        }

        int endIdx = startIdx + 2;
        while (endIdx < result.length()) {
            if (String.valueOf(result.charAt(endIdx)).equals(SEPARATOR)) {
                endIdx++;
            } else {
                break;
            }
        }

        return result.substring(startIdx, endIdx);
    }

    private void removeCurrent() {
        String target = SEPARATOR + CURRENT + SEPARATOR;
        while (result.contains(target)) {
            result = result.replace(target, SEPARATOR);
        }
    }

    private void setUpperByStack() {
        StringTokenizer st = new StringTokenizer(result, SEPARATOR);
        while (st.hasMoreTokens()) {
            String subPath = st.nextToken();
            if (subPath.equals(UPPER)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(subPath);
            }
        }
    }

    private void setPathByStack() {
        Collections.reverse(stack);
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(SEPARATOR);
            sb.append(stack.pop());
        }

        if (sb.length() == 0) {
            sb.append(SEPARATOR);
        }

        result = sb.toString();
    }

}