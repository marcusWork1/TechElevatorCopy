package Cards;

// subclass of playingCard


// import different package of PlayingCard that contains what you need
import com.techelevator.PlayingCard;

public class ItalianPlayingCard extends PlayingCard {
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
    public String toString() {
        return "ItalianPlayingCard: " + super.toString();
    }
} // end of class



