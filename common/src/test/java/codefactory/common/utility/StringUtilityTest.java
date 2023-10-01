package codefactory.common.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static codefactory.common.utility.StringUtility.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringUtilityTest {
    @Test
    @DisplayName("isEmptyTest")
    public void isEmptyTest() {
        assertTrue(isEmpty(null));
        assertTrue(isEmpty(""));
        assertFalse(isEmpty(" "));
        assertFalse(isEmpty("bob"));
        assertFalse(isEmpty("  bob  "));
    }

    @Test
    public void isAnyEmptyTest() {
        assertTrue(isAnyEmpty((String) null));
        //assertFalse(isAnyEmpty((String[]) null));
        assertTrue(isAnyEmpty(null, "foo"));
        assertTrue(isAnyEmpty("", "bar"));
        assertTrue(isAnyEmpty("bob", ""));
        assertTrue(isAnyEmpty("  bob  ", null));
        assertFalse(isAnyEmpty("foo", "bar"));
        assertFalse(isAnyEmpty(new String[]{}));
        assertTrue(isAnyEmpty(new String[]{""}));
    }

    @Test
    public void isBlankTest() {
        assertTrue(isBlank(null));
        assertTrue(isBlank(""));
        assertTrue(isBlank(" "));
        assertFalse(isBlank("bob"));
        assertFalse(isBlank("  bob  "));
    }

    @Test
    public void isAnyBlankTest() {
        //assertFalse(isAnyBlank((String[]) null));
        assertTrue(isAnyBlank((String) null));
        assertTrue(isAnyBlank(null, "foo"));
        assertTrue(isAnyBlank(null, null));
        assertTrue(isAnyBlank("", "bar"));
        assertTrue(isAnyBlank("bob", ""));
        assertTrue(isAnyBlank("  bob  ", null));
        assertTrue(isAnyBlank(" ", "bar"));
        assertFalse(isAnyBlank(new String[] {}));
        assertTrue(isAnyBlank(new String[] { "" }));
        assertFalse(isAnyBlank("foo", "bar"));
    }

    @Test
    public void testContainsWhitespace() {
        assertFalse(containsWhitespace(null));
        assertFalse(containsWhitespace(""));
        assertFalse(containsWhitespace("a"));
        assertFalse(containsWhitespace("abc"));
        assertTrue(containsWhitespace(" "));
        assertTrue(containsWhitespace(" a"));
        assertTrue(containsWhitespace("abc "));
        assertTrue(containsWhitespace("a b"));
        assertTrue(containsWhitespace("a  b"));
    }

    @Test
    public void testTrimWhitespace() {
        assertNull(trimWhitespace(null));
        assertEquals("", trimWhitespace(""));
        assertEquals("", trimWhitespace(" "));
        assertEquals("", trimWhitespace("\t"));
        assertEquals("a", trimWhitespace(" a"));
        assertEquals("a", trimWhitespace("a "));
        assertEquals("a", trimWhitespace(" a "));
        assertEquals("a b", trimWhitespace(" a b "));
        assertEquals("a b  c", trimWhitespace(" a b  c "));
    }

    @Test
    public void testIsNumeric() {
        assertFalse(StringUtility.isNumeric(null));
        assertFalse(StringUtility.isNumeric(""));
        assertFalse(StringUtility.isNumeric(" "));
        assertFalse(StringUtility.isNumeric("a"));
        assertFalse(StringUtility.isNumeric("A"));
        assertFalse(StringUtility.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
        assertFalse(StringUtility.isNumeric("ham kso"));
        assertTrue(StringUtility.isNumeric("1"));
        assertTrue(StringUtility.isNumeric("1000"));
        assertTrue(StringUtility.isNumeric("\u0967\u0968\u0969"));
        assertFalse(StringUtility.isNumeric("\u0967\u0968 \u0969"));
        assertFalse(StringUtility.isNumeric("2.3"));
        assertFalse(StringUtility.isNumeric("10 00"));
        assertFalse(StringUtility.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
        assertFalse(StringUtility.isNumeric("_"));
        assertFalse(StringUtility.isNumeric("hkHKHik*khbkuh"));
        assertFalse(StringUtility.isNumeric("+123"));
        assertFalse(StringUtility.isNumeric("-123"));
    }
}
