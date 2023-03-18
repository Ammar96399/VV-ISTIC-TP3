package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test void StringContainsIllegalCharIsNotBalanced() {
        assertFalse(StringUtils.isBalanced("1239{[]}()"));
    }

    @Test void NotEvenSizeIsNotBalanced() {
        assertFalse(StringUtils.isBalanced("{[]}("));
    }

    @Test void NullIsNotValid() {
        assertFalse(StringUtils.isBalanced(null));
    }

    @Test void EmptyIsBalanced() {
        assertTrue(StringUtils.isBalanced(""));
    }

    @Test void NestedBalancedStringIsBalanced() {
        assertFalse(StringUtils.isBalanced("[{[({})]}]"));
    }

    @Test void ComposedBalancedStringIsBalanced() {
        assertFalse(StringUtils.isBalanced("[](){}[({})]"));
    }

    @Test void OtherCasesAreNotBalanced() {
        assertFalse(StringUtils.isBalanced("[]([{])}"));
    }
}