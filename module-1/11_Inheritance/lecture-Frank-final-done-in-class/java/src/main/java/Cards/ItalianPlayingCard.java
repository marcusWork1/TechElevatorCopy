package Cards;

// This a subclass of PlayingCard


import com.techelevator.PlayingCard;

public class ItalianPlayingCard extends PlayingCard {
    // Constructor was created by Intellij based on the PlayingCard class
    /***************************************************************************************
     * 3-arg constructor when user uses value, suit and color to instantiate
     **************************************************************************************
     * @param value
     * @param suit
     * @param color*/
    public ItalianPlayingCard(int value, String suit, String color) {
        super(value, suit, color);
    }

    @Override
    // It's not unusual for a subclass method to invoke a sup class method
    //      if it needs what the super class method does
    public String toString() {
        return "ItalianPlayingCard: " + super.toString();
    }
}  // End of ItalianPlayingCard class

