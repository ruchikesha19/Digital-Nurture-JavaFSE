package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringHelperTest {
    @Test
    public void testReverse() {
        StringHelper helper = new StringHelper();
        assertEquals("olleh", helper.reverse("hello"));
        assertNull(helper.reverse(null));
        assertEquals("", helper.reverse(""));
    }

    @Test
    public void testIsPalindrome() {
        StringHelper helper = new StringHelper();
        assertTrue(helper.isPalindrome("radar"));
        assertTrue(helper.isPalindrome("Radar"));
        assertFalse(helper.isPalindrome("hello"));
        assertFalse(helper.isPalindrome(null));
        assertTrue(helper.isPalindrome(""));
    }
}
