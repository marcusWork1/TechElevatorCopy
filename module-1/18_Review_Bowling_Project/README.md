## Bowling Project – Phase 1

#### Create a Class to hold information about Bowlers:
1. Attributes to be stored:
   - Team Number
   - Bowler Number
   - Bowler Name
   - Scores of three games stored as a unit
2. Only one constructor is needed that will receive all attributes as parameters.
3. Standard getters and setters should be defined.
4. Standard equals() and toString() overrides should be defined
5. Methods for deriving the sum of the scores and the average of the scores should be defined.
#### Create a class to hold information about a bowling league:
1. Attributes to be stored:
   - Name of the League
   - League members which is a set of bowlers stored by team.
2.  Two constructors need to be defined:
    - Default constructor that initializes all data members to null
    - 2‐arg constructor that takes the league name and a file name containing the bowlers for the league. This constructor should assign the league name passed to the league name data member and load the file name passed into the league members data member.
3.  Standard getters should be defined, but no setters.
4.  Standard equals() toString() overrides should be defined.
5.  A method to display all the bowlers in the league in team order should be defined.
#### Create an application program to:
1.  Instantiate a League using the data in the comma delimited file called **bowling.dat** stored in the **/data** folder of the project. The order of the values in the file:

        team number, bowler number, bowler name, score1, score2, score3 

2. Use the league method you wrote to display all the bowlers by team.
