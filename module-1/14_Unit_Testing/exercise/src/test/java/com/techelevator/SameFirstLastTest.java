package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SameFirstLastTest {

    @Test
    public void testWithValid() {
        Assertions.assertEquals(true,new SameFirstLast().isItTheSame(new int[]{1,2,3,1}));
    }
    @Test
    public void testWithInValid() {
        Assertions.assertEquals(false,new SameFirstLast().isItTheSame(new int[]{1,2,3,2}));
    }

}