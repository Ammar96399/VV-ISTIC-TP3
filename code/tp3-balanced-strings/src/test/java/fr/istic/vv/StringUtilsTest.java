package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test void StringContainsIllegalCharIsNotBalanced() {
        assertFalse(StringUtils.isBalanced("1239{[]}()"));
    }

    @Test void NotEvenSizeIsNotBalanced1() {
        assertFalse(StringUtils.isBalanced("{[]}("));
    }

    @Test void NotEvenSizeIsNotBalanced2() {
        assertFalse(StringUtils.isBalanced("{{{"));
    }

    @Test void NullIsNotValid() {
        assertFalse(StringUtils.isBalanced(null));
    }

    @Test void EmptyIsBalanced() {
        assertTrue(StringUtils.isBalanced(""));
    }

    @Test void NestedBalancedStringIsBalanced() {
        assertTrue(StringUtils.isBalanced("[{[({})]}]"));
    }

    @Test void ComposedBalancedStringIsBalanced() {
        assertTrue(StringUtils.isBalanced("[](){}[({})]"));
    }

    @Test void OtherCasesAreNotBalanced() {
        assertFalse(StringUtils.isBalanced("[]([{])}"));
    }

    @Test void BalancedIllegalSequencesAreNotBalanced1() {
        assertFalse(StringUtils.isBalanced("aabaccabaa"));
    }


    @Test void BalancedIllegalSequencesAreNotBalanced2() {
        assertFalse(StringUtils.isBalanced("aabaabcccc"));
    }
}