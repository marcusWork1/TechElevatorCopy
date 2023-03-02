package com.techelevator.Bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myApplicationProgram {
    public static void main(String[] args) {

        // define a bowler to test the class
        // we can use new to run a constructor for the class
        // define a list of pf scores to use with the new bowler

        List<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(200);
        scores.add(250);

        BowlingClass aBowler = new BowlingClass("Frank",42,0, scores);
        System.out.println(aBowler);

        List<Integer> moreScores = Arrays.asList(150, 200, 280);
        BowlingClass anotherBowler = new BowlingClass("Marcus", 21, 5, moreScores);
                System.out.println(anotherBowler);

                BowlingClass yetAnotherBowler = new BowlingClass("Jim", 15, 27, Arrays.asList(100, 200, 300));
                System.out.println(yetAnotherBowler);
    }
}
