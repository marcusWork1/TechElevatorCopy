package com.techelevator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordCountTest {

    @Test
    public void testWithNonEmpty() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(2,wordCount.getCount(new String[]{"ba", "ba", "black", "sheep"}).get("ba"));
    }
    @Test
    public void testWithEmpty() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(null,wordCount.getCount(new String[]{}).get("ba"));
    }


}