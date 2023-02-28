package com.techelevator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class StringBitsTest {

        @Test
        public void testWithNormal() {
            Assertions.assertEquals("Hlo",new StringBits().getBits("Hello"));
        }
        @Test
        public void testWithEmpty() {
            Assertions.assertEquals("",new StringBits().getBits(""));
        }

    }
