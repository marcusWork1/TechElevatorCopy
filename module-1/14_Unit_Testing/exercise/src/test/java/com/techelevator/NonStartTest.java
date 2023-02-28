package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NonStartTest {

    @Test
    public void testNormalTestCase() {
        NonStart firstOrLast = new NonStart();
        Assertions.assertEquals("ellohere",firstOrLast.getPartialString("Hello","There"));
    }

    @Test
    public void testWithFirstOrLastIsEmpty() {
        NonStart firstOrLast = new NonStart();
        Assertions.assertEquals("ello",firstOrLast.getPartialString("Hello",""));
        Assertions.assertEquals("here",firstOrLast.getPartialString("","There"));
    }
}
