package com.example.doinglab.path;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void test() {
        assertEquals(Solution.INVALID, new Solution().simplifyPath("a/b/c"));
        assertEquals("/a", new Solution().simplifyPath("/a/./"));
        assertEquals("/a/b", new Solution().simplifyPath("/a/b/c/../"));
        assertEquals("/a", new Solution().simplifyPath("/a/"));
        assertEquals("/a/b/c", new Solution().simplifyPath("/a/////////b/c"));
        assertEquals("/", new Solution().simplifyPath("/../"));
    }

    @org.junit.Test
    public void test2() {
        assertEquals("/home", new Solution().simplifyPath("/home/"));
        assertEquals("/", new Solution().simplifyPath("/../"));
        assertEquals("/home/foo", new Solution().simplifyPath("/home//foo/"));
        assertEquals("/c", new Solution().simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", new Solution().simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c", new Solution().simplifyPath("/a/b//c/d//././/.."));
    }

    @org.junit.Test
    public void test3() {
        assertEquals(Solution.INVALID, new Solution().simplifyPath(""));
        assertEquals("/", new Solution().simplifyPath("/"));
        assertEquals("/", new Solution().simplifyPath("/////"));
        assertEquals("/", new Solution().simplifyPath("/."));
        assertEquals("/", new Solution().simplifyPath("/..//././///..//../."));
        assertEquals("/", new Solution().simplifyPath("/..//././///..//.././.."));
    }

    @org.junit.Test
    public void test4() {
        assertEquals("/a", new Solution().simplifyPath("/a"));
        assertEquals("/a", new Solution().simplifyPath("///a"));
        assertEquals("/a", new Solution().simplifyPath("//../././../a//"));
        assertEquals("/a", new Solution().simplifyPath("//../././../a//bb/.//./..//"));
        assertEquals("/a", new Solution().simplifyPath("//../././../a//bb/.//./..//ccc.././/.."));
    }

}