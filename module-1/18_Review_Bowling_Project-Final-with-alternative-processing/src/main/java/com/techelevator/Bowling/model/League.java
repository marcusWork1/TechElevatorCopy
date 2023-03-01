package com.techelevator.Bowling.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class League {
private String league_Name;
private Map<Integer, List<Bowler>> leagueMembers;
private Map<Integer,Map<Integer, Bowler>> leagueMemberMap;

public League() {
    league_Name = null;
    leagueMembers = null;
}
public League(String nameOfLeague, String fileName2Load) throws FileNotFoundException {
    league_Name = nameOfLeague;
    leagueMembers = new TreeMap<Integer, List<Bowler>>();
    leagueMemberMap = new TreeMap();

    loadFileIntoMembers(fileName2Load);
    loadFileIntoMemberMap(fileName2Load);
}

    public String getLeague_Name() {
        return league_Name;
    }

    public Map<Integer, List<Bowler>> getLeagueMembers() {
        return leagueMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof League)) return false;
        League league = (League) o;
        return Objects.equals(getLeague_Name(), league.getLeague_Name()) && Objects.equals(getLeagueMembers(), league.getLeagueMembers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeague_Name(), getLeagueMembers());
    }

    @Override
    public String toString() {
        return "\nLeague{" +
                "league_Name='" + league_Name + '\'' +
                ", \nleagueMembers=" + leagueMembers +
                ", \nleagueMemberMap=" + leagueMemberMap +
                '}';
    }

    private void loadFileIntoMembers(String nameOfFile) throws FileNotFoundException {
        // Define a File object to represent the file
        File theFile = new File(nameOfFile);

        // Define a Scanner object for the file so we can read it
        Scanner fileOnDisk = new Scanner(theFile);

        boolean noDataProcessedYet = true;
        int currentTeamNumber = 0;
        List<Bowler> bowlersOnTeam = new ArrayList();


        // Loop while the file has a line to read
        while(fileOnDisk.hasNextLine()) {
            // Read a line from the file
            String lineFromFile = fileOnDisk.nextLine();
            // Separate the values in the line based on the , delimiter
            String[] valuesInLine = lineFromFile.split(",");
            // [0] [1]       [2]            [3]    [4]     [5]
            //  1,  1,  Fred Flintstone,   230,    228,   229
            // Assign values from the file to variables
            try {
                int teamNumber = Integer.parseInt(valuesInLine[0]);
                int bowlerNumber = Integer.parseInt(valuesInLine[1]);
                String bowlerName = valuesInLine[2];
                int score1 = Integer.parseInt(valuesInLine[3].trim());
                int score2 = Integer.parseInt(valuesInLine[4].trim());
                int score3 = Integer.parseInt(valuesInLine[5].trim());

                // Define the objects need fot the Map
                List<Integer> bowlerScores = Arrays.asList(score1, score2, score3);
                Bowler newBowler = new Bowler(teamNumber, bowlerNumber, bowlerName, bowlerScores);

                if (noDataProcessedYet == true) {
                    currentTeamNumber = teamNumber;
                    noDataProcessedYet = false;
                }

                if (teamNumber == currentTeamNumber) {
                    bowlersOnTeam.add(newBowler);
                } else {
                    leagueMembers.put(currentTeamNumber, bowlersOnTeam);
                    currentTeamNumber = teamNumber;
                    bowlersOnTeam = new ArrayList<>();
                    bowlersOnTeam.add(newBowler);
                }
            }
            catch (NumberFormatException exceptionObject) {
                System.out.println("Invalid numeric value in the input data");
                System.out.println("Skipping bowler");
                continue;  // skip rest of loop processing
            }
        }  // End of while loop
            leagueMembers.put(currentTeamNumber, bowlersOnTeam);
}  // End of loadFile() method

    private void loadFileIntoMemberMap(String nameOfFile) throws FileNotFoundException {
        // Define a File object to represent the file
        File theFile = new File(nameOfFile);

        // Define a Scanner object for the file so we can read it
        Scanner fileOnDisk = new Scanner(theFile);

        boolean noDataProcessedYet = true;
        int currentTeamNumber = 0;
        Map<Integer, Bowler> bowlersOnTeam = new TreeMap();

        // Loop while the file has a line to read
        while(fileOnDisk.hasNextLine()) {
            // Read a line from the file
            String lineFromFile = fileOnDisk.nextLine();
            // Separate the values in the line based on the , delimiter
            String[] valuesInLine = lineFromFile.split(",");
            // [0] [1]       [2]            [3]    [4]     [5]
            //  1,  1,  Fred Flintstone,   230,    228,   229
            // Assign values from the file to variables

            try {
                int teamNumber = Integer.parseInt(valuesInLine[0]);
                int bowlerNumber = Integer.parseInt(valuesInLine[1]);
                String bowlerName = valuesInLine[2];
                int score1 = Integer.parseInt(valuesInLine[3].trim());
                int score2 = Integer.parseInt(valuesInLine[4].trim());
                int score3 = Integer.parseInt(valuesInLine[5].trim());
                // Define the objects need for the Map
                List<Integer> bowlerScores = Arrays.asList(score1, score2, score3);
                Bowler newBowler = new Bowler(teamNumber, bowlerNumber, bowlerName, bowlerScores);


                if (noDataProcessedYet == true) {
                    currentTeamNumber = teamNumber;
                    noDataProcessedYet = false;
                }

                if (teamNumber == currentTeamNumber) {
                    bowlersOnTeam.put(bowlerNumber, newBowler);
                } else {
                    leagueMemberMap.put(currentTeamNumber, bowlersOnTeam);
                    currentTeamNumber = teamNumber;
                    bowlersOnTeam = new TreeMap<Integer, Bowler>();
                    bowlersOnTeam.put(bowlerNumber, newBowler);
                }
            } catch (NumberFormatException exceptionObject) {
                    System.out.println("Invalid numeric value in the input data");
                    System.out.println("Skipping bowler");
                    continue;  // skip rest of loop processing
                }
        }  // End of while loop
        leagueMemberMap.put(currentTeamNumber, bowlersOnTeam);
    }  // End of loadFile() method

}  // End of League class
