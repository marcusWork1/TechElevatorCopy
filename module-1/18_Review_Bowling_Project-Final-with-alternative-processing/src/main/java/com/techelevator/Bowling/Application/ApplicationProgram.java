package com.techelevator.Bowling.Application;

import com.techelevator.Bowling.model.Bowler;
import com.techelevator.Bowling.model.League;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class ApplicationProgram {
    public static void main(String[] args) throws FileNotFoundException {
        Bowler aBowler = new Bowler(0,0,"Frank", Arrays.asList(100, 200, 300));
        System.out.println(aBowler);

        League aLeague = new League("Franks League", "./data/bowling.dat");
        System.out.println(aLeague);
    }
}
