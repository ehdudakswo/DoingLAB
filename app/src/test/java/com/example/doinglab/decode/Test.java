package com.example.doinglab.decode;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void test() {
        assertEquals("aaabcbc", new Solution().decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", new Solution().decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", new Solution().decodeString("2[abc]3[cd]ef"));
    }

    @org.junit.Test
    public void test2() {
        assertEquals("a", new Solution().decodeString("1[a]"));
        assertEquals("aa", new Solution().decodeString("2[1[a]]"));
        assertEquals("aaaaaa", new Solution().decodeString("3[2[1[a]]]"));
    }

    @org.junit.Test
    public void test3() {
        assertEquals("abcd", new Solution().decodeString("abcd"));
        assertEquals("abbcddd", new Solution().decodeString("a2[b]c3[d]"));
        assertEquals("abbcbbcbbcddd", new Solution().decodeString("a3[2[b]c]3[d]"));
    }

}