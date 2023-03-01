package com.techelevator.Bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myApplicationProgram {
    public static void main(String[] args) {

        // Define a Bowler to test the class
        // we use new to run a constructor for the class
        // define a List of scores to use with the new Bowler
        List<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(200);
        scores.add(300);

        Bowler aBowler = new Bowler(0,42,"Frank", scores);
        System.out.println(aBowler);

        List<Integer> moreScores = Arrays.asList(10, 20, 30);

        Bowler anotherBowler = new Bowler(23, 45, "Spock", moreScores);
        System.out.println(anotherBowler);

        Bowler yetAnotherBowler = new Bowler(3, 1, "Worf", Arrays.asList(289, 299, 300));
        System.out.println(yetAnotherBowler);

        Bowler[] bunchOBowlers = new Bowler[10];
    }
}
