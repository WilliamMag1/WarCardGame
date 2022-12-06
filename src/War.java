import java.util.Random;

/**
 * The War class respresents a game of war.
 * How many cards there will be. How amny rounds there will be.It
 * also dictates what cards are higher and lower than others.
 */

public class War {
    /**
    *Instance Variables
    */
    private int rounds;
    private int points= 0;
    private int deckSize;

    private int cardValue;

    private String cardDrawn;

    private String[] set = new String[]{"1", "2","3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King",
            "Ace"};

    /**
     *Creates a LinearEquation object using set values
     */
    public War(){
        rounds =10;
        deckSize= 26;
    }

    /**
     *Creates a LinearEquation object with values that can be changed according to the parameter
     */
    public War(int rounds, int deckSize){
        this.rounds=rounds;
        this.deckSize=deckSize;
    }

    /**
     *  ToString method. Returns the rounds and deckSize (two int variables) as a string.
     */
    public String printRules() {
        return "The game will have " + rounds +" rounds "+ "and players will have a decksize of " + deckSize;
    }

    /**
     *  getter method: returns number of rounds
     */
    public int getRounds(){
        return rounds;
    }

    /**
     *  getter method: returns the deckSize
     */
    public int getDeckSize(){
        return deckSize;
    }

    /**
    * setter method: updates the value of deckSize by adding the value of parameter z to it.
    * */
    public void setDeckSize(int z){
        deckSize +=z;
    }

    /**
     * returns a random element of the String array. set.
     */
    public String cardDrawn() {
        Random random = new Random();
        int index = random.nextInt(set.length);
        cardDrawn=set[index];
        return cardDrawn;
    }

    /**
     * return the value of the int variable cardValue based on the card drawn. For example, if the card drawn is 1, cardValue will equal 1.
     */
    public int cardValue(String x){
        if (cardDrawn.equals("1")){
            cardValue=1;
        } else if (cardDrawn.equals("2")){
            cardValue=2;
        } else if (cardDrawn.equals("3")){
            cardValue=3;
        } else if (cardDrawn.equals("4")){
            cardValue=4;
        } else if (cardDrawn.equals("5")) {
            cardValue = 5;
        } else if (cardDrawn.equals("6")){
            cardValue=6;
        } else if (cardDrawn.equals("7")){
            cardValue=7;
        } else if (cardDrawn.equals("8")){
            cardValue=8;
        } else if (cardDrawn.equals("9")){
            cardValue=9;
        } else if (cardDrawn.equals("10")){
            cardValue=10;
        } else if (cardDrawn.equals("Jack")){
            cardValue=11;
        } else if (cardDrawn.equals("Queen")){
            cardValue=12;
        } else if (cardDrawn.equals("King")){
            cardValue=13;
        } else if (cardDrawn.equals("Ace")){
            cardValue=14;
        }
        return cardValue;
    }

    /**
     *  setter method: updates the value of addPoints by adding the value of parameter z to it.
     */
    public void addPoints(int z){
        points +=z;
    }

    /**
     * returns the value of the points variable
     */
    public int getPoints(){
        return points;
    }

}

