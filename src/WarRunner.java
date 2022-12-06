import java.util.Scanner;

public class WarRunner {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        /*creating class instances*/
        War player = new War();
        War bot = new War();

       /*if "standard" is inputted, then the values for the instance variables deckSize and rounds will be set to the
       no parameter constructor*/
        System.out.println("What game mode do you want to play? standard or custom?");
        String option = scan.nextLine();
        if (option.equals("standard")){
            player = new War();
            bot = new War();
        } else if (option.equals("custom")){ /*if "custom" is inputted, then the values for the instance
                                              variables deckSize and rounds will be set to the values you input.
                                              The constructor with parameter will be used*/
            System.out.println("How many rounds?");
            int numRounds = scan.nextInt();
            System.out.println("How many cards");
            int numCards = scan.nextInt();
            player = new War(numRounds, numCards);
            bot = new War(numRounds, numCards);
        }

        /*initializes variable*/
        int warCount = 0;

        /*prints out how many rounds and cards in each deck there will be.*/
        System.out.println(player.printRules());
        System.out.print("\n");

        /*The number of iterations there will be, will be equal to the value of rounds.*/
        for (int i = 1; i <= bot.getRounds(); i++) {
            /*Initializes and declares variables*/
            String playerCard = player.cardDrawn();
            String botCard = bot.cardDrawn();
            int pCardValue = player.cardValue(playerCard);
            int bCardValue = bot.cardValue(botCard);
            if (pCardValue > bCardValue) { /*If player card value is greater than bot card value, then player score
                                            will change according to the value of the bot card gained. Also prints out the card
                                            drawn and value of bot card and adds +1 to player deckSize and -1
                                            to botDeckSize */
                player.addPoints(bCardValue);
                System.out.println("player card drawn " + playerCard);
                System.out.println("player card value " + pCardValue);
                System.out.println("bot card drawn " + botCard);
                System.out.println("bot card value " + bCardValue);
                System.out.println("player wins round " + i);
                player.setDeckSize(1);
                bot.setDeckSize(-1);
                System.out.println();
            } else if (bCardValue > pCardValue) { /*If bot card value is greater than bot card value, then bot score
                                                   will change according to the value of the player card gained. Also prints out
                                                   the card drawn and value of player card and adds +1 to
                                                   player deckSize and -1 to botDeckSize */
                bot.addPoints(pCardValue);
                System.out.println("bot card drawn " + botCard);
                System.out.println("bot card value " + bCardValue);
                System.out.println("player card drawn " + playerCard);
                System.out.println("player card value " + pCardValue);
                System.out.println("bot wins round " + i);
                player.setDeckSize(-1);
                bot.setDeckSize(1);
                System.out.println();
            } else {
               /*if the cards are equal, prints out the card drawn. Then will loop until the card drawn by the player
                 and bot are unequal. Will also print out "I declare War!" with line breaks being at each syllable.
                 Each time it iterates, the value of WarCount will increase by 4.*/
                System.out.println("card drawn " + playerCard);
                while (pCardValue == bCardValue) {
                    playerCard = player.cardDrawn();
                    botCard = bot.cardDrawn();
                    pCardValue = player.cardValue(playerCard);
                    bCardValue = bot.cardValue(botCard);
                    System.out.println("I");
                    System.out.println("de");
                    System.out.println("clare");
                    System.out.println("war!");
                    warCount += 4;
                }
               /*If player card value is greater than bot card value, then player score
               will change according to the value of the card. Also prints out
               the card drawn and value of bot card and adds +the value of warCount to
               player deckSize and -warCount to botDeckSize */
                if (pCardValue > bCardValue) {
                    player.addPoints(pCardValue);
                    System.out.println("player card drawn " + playerCard);
                    System.out.println("player card value " + pCardValue);
                    System.out.println("bot card drawn " + botCard);
                    System.out.println("bot card value " + bCardValue);
                    System.out.println("player wins round " + i);
                    player.setDeckSize(warCount);
                    bot.setDeckSize(-warCount);
                    System.out.println();
                } else {
                   /*If bot card value is greater than bot card value, then bot score
                   will change according to the value of the card. Also prints out
                   the card drawn and value of player card and adds +the value of warCount to
                   player deckSize and -warCount to botDeckSize */
                    bot.addPoints(bCardValue);
                    System.out.println("bot card drawn " + botCard);
                    System.out.println("bot card value " + bCardValue);
                    System.out.println("player card drawn " + playerCard);
                    System.out.println("player card value " + pCardValue);
                    System.out.println("bot wins round " + i);
                    player.setDeckSize(-warCount);
                    bot.setDeckSize(+warCount);
                    System.out.println();
                }
            }
        }

        /*initializes and declares variable for getting the deck and card values.*/
        int playerPoints = player.getPoints();
        int botPoints = bot.getPoints();
        int playerDeckSize = player.getDeckSize();
        int botDeckSize = bot.getDeckSize();

        /*Prints out these values*/
        System.out.print("\n");
        System.out.print("player score: "+ playerPoints +"\n");
        System.out.println("player deck size: " + playerDeckSize);
        System.out.print("bot score: "+ botPoints+"\n");
        System.out.println("bot deck size: " + botDeckSize);

        /*Initializes variables*/
        int coinFlip;

       /*if both points and deckSize are equal, then either 1 or 2 will be generated via Math.random().coinFlip will be
        set to this value. If coinFlip is 1, then player wins, but if it is 2, then bot wins. */
        if (playerPoints == botPoints && playerDeckSize==botDeckSize) {
            coinFlip = (int) (Math.random() * 2) + 1;
            if (coinFlip == 1) {
                System.out.println("Coin flip is heads");
                System.out.println("player wins");
            } else {
                System.out.println("Coin flip is tails");
                System.out.println("bot wins");
            }
        }
        /*If player deck size is higher, then player wins*/
        else if (playerDeckSize > botDeckSize) {
            System.out.println("player wins");
            /*If bot deck size is higher, then bot wins*/
        } else if (playerDeckSize < botDeckSize) {
            System.out.println("bot wins");
           /*If deck size is equal, then the score will be used to determine a winner. If score is
           higher, then player wins */
        } else if (playerPoints > botPoints) {
            System.out.println("player wins");
            /*If bot score is higher, then player wins*/
        } else {
            System.out.println("bot wins");
        }
    }
}

