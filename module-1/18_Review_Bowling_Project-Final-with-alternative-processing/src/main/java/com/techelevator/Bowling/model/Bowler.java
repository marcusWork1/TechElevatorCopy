package com.techelevator.Bowling.model;

import java.util.List;
import java.util.Objects;

public class Bowler {
   private int teamNumber;
   private int bowlerNumber;
   String bowlerName;
   List<Integer> scores;

   public Bowler(int teamNumber, int bowlerNumber, String bowlerName, List<Integer> scores) {
      this.teamNumber   = teamNumber;
      this.bowlerNumber = bowlerNumber;
      this.bowlerName   = bowlerName;
      this.scores       = scores;
   }

   public int getTeamNumber() {
      return teamNumber;
   }

   public int getBowlerNumber() {
      return bowlerNumber;
   }

   public String getBowlerName() {
      return bowlerName;
   }

   public List<Integer> getScores() {
      return scores;
   }

   public void setTeamNumber(int teamNumber) {
      this.teamNumber = teamNumber;
   }

   public void setBowlerNumber(int bowlerNumber) {
      this.bowlerNumber = bowlerNumber;
   }

   public void setBowlerName(String bowlerName) {
      this.bowlerName = bowlerName;
   }

   public void setScores(List<Integer> scores) {
      this.scores = scores;
   }

   public int getTotalScore() {
      int scoreSum = 0;

      for(int aScore : scores) {
         scoreSum += aScore;
      }
      return scoreSum;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Bowler)) return false;
      Bowler bowler = (Bowler) o;
      return getTeamNumber() == bowler.getTeamNumber() && getBowlerNumber() == bowler.getBowlerNumber() && getBowlerName().equals(bowler.getBowlerName()) && getScores().equals(bowler.getScores());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getTeamNumber(), getBowlerNumber(), getBowlerName(), getScores());
   }

   @Override
   public String toString() {
      return "\nBowler{" +
              "teamNumber=" + teamNumber +
              ", bowlerNumber=" + bowlerNumber +
              ", bowlerName='" + bowlerName + '\'' +
              ", scores=" + scores +
              ", totalScore=" + getTotalScore() +
              '}';
   }

}
