package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MaxEnd3Test {

    @Test
    public void testFirstIsBigger() {
        MaxEnd3 largerNumber = new MaxEnd3();
        int res[] = largerNumber.makeArray(new int[]{11,5,9});
        Assertions.assertEquals(11,res[0]);
    }
    @Test
    public void testLastIsBigger() {
        MaxEnd3 largerNumber = new MaxEnd3();
        int res[] = largerNumber.makeArray(new int[]{11,5,90});
        Assertions.assertEquals(90,res[0]);
    }

}