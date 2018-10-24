import java.util.Scanner;

public class BlackJ1ack {
    public static void main(String[] arg) { //entry

        int gameNum = 1; // making it so the game will start on 1

        int endGame = 19; // setting an integer to a random value so the loop will have an end that's not connected to the options menu. The value isn't important

            System.out.println("START GAME #1");

        P1Random rng = new P1Random();

        int p1Hand = 0; // Setting the initial hand to 0. p1Hand is player's hand

        int dealer = 0; // setting the dealer's hand to 0 as well
        int myNumber = 0; // this is the value of the card pulled for the player, which starts off at 0

        Scanner scanner = new Scanner(System.in); // introduce scanner for options menu

        int P1wins = 0; // amount of player wins
        int dealerWin = 0; // amount of dealer wins
        int tie = 0;
        double percentP1 = 0.0; // percent of player wins

        int options = 1; // making it so the game will automatically start by making the loop condition true

      do
         {
             if (p1Hand == 0 && dealer == 0){ // set this condition because every time p1Hand and dealer = 0, a new game is started
                 options = 1; // making it so loop will start with option 1 each time a new game starts
             }

            switch(options) {

                case 1:

                    if (p1Hand != 0) { // if the p1Hand is 0, it's a new game, which should not print the following statement
                        System.out.println("Choose an option:"); // The beginning of each game will automatically deal a card without this
                    }

                    myNumber = rng.nextInt(13) + 1; // giving a card with a value between 1 and 13
                    if (myNumber == 13) {
                        p1Hand = p1Hand + 10; // When 13 is drawn, 10 is added
                        System.out.println("Your card is a KING!"); // Making value of 13 a KING
                    }

                    if (myNumber == 12) {
                        p1Hand = p1Hand + 10; // When 12 is drawn, 10 is added
                        System.out.println("Your card is a QUEEN!"); // making value of 12 a QUEEN
                    }

                    if (myNumber == 11) {
                        p1Hand = p1Hand + 10; // when 11 is drawn, 10 is added
                        System.out.println("Your card is a JACK!"); // making value of 11 a JACK
                    }

                    if (myNumber == 1) {
                        p1Hand = p1Hand + 1; // When 1 is drawn, 1 is added
                        System.out.println("Your card is a ACE!"); // making value of 1 a ACE
                    }

                    if (myNumber < 11 && myNumber > 1) { // if the number is between, and not including, 1 and 11 the value stays the same
                        p1Hand = p1Hand + myNumber; // Keeping track of the value of the player's hand
                        System.out.println("Your card is a " +myNumber+ "!");
                    }

                    System.out.println("Your hand is: " + p1Hand);

                    if (p1Hand > 21) { // winner can be determined. more can be seen at bottom of loop
                        break;
                    }

                    if (p1Hand == 21) {
                        break;
                    }

                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");

                    options = scanner.nextInt(); // so that the loop isn't an infinite loop and it depends on input
                    break;

                case 2:
                    dealer = rng.nextInt(11) + 16; // giving dealer a card with value between 16 and 26
                    System.out.println("Choose an option:");

                    System.out.println("Dealer's hand: " + dealer);
                    System.out.println("Your hand is: " + p1Hand);

                    if (p1Hand < dealer && dealer <= 21) { // both conditions here so player doesn't lose if dealer is greater than 21
                        System.out.println("Dealer wins!");

                        gameNum = gameNum + 1; // so the beginning of each game will state the game # going up by 1
                        System.out.println("START GAME #" + gameNum);

                        dealerWin = dealerWin + 1; // keeping track of dealer wins

                        options = 1; // so the new game will begin with option 1 and deal a card
                        p1Hand = 0; // When the game restarts, these values will return to 0
                        dealer = 0;

                        break;
                    }
                    if (dealer > 21) { // if dealer goes over 21, player wins
                        System.out.println("You win!");

                        gameNum = gameNum + 1;
                        System.out.println("START GAME #" + gameNum);
                        P1wins = P1wins + 1; // keeping track of player wins

                        options = 1;
                        p1Hand = 0;
                        dealer = 0;

                        break;
                    }
                    if (p1Hand > dealer && p1Hand < 21) { // so the player will not win if they go over 21
                        System.out.println("You win!");

                        gameNum = gameNum + 1;
                        System.out.println("START GAME #" + gameNum);
                        P1wins = P1wins + 1;

                        options = 1;
                        p1Hand = 0;
                        dealer = 0;
                    }
                    if (p1Hand == dealer){
                        System.out.println("It's a tie! No one wins!");

                        break;
                    }

                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");

                    break;

                case 3:

                    System.out.println("Choose an option:");

                    System.out.println("Number of Player wins: " + P1wins);
                    System.out.println("Number of Dealer wins: " + dealerWin);
                    System.out.println("Number of tie games: " + tie);
                    System.out.println("Total # of games played is: " + (gameNum - 1)); // it is gameNum - 1 because the current game being played does not count

                    percentP1 = (P1wins * 100 / (gameNum - 1)); // calculating the percent of player wins
                    System.out.println("Percentage of Player wins: " +percentP1 + "%");


                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");

                    options = scanner.nextInt();
                    break;

                case 4:

                    System.out.println("Choose an option:");

                    options = endGame; // so that the loop will not automatically end at options = 4, but will terminate the above statement first
                    break;

                default: // any other number entered will terminate the following responses

                    System.out.println("Choose an option:");

                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");

                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");

                    options = scanner.nextInt();
                    break;
              }
            if(p1Hand > 21){
                System.out.println("You exceeded 21! You lose.");

                gameNum = gameNum + 1;
                System.out.println("START GAME #" + gameNum);
                dealerWin = dealerWin + 1;

                p1Hand = 0;
                dealer = 0;
                options = 1;
                continue;
            }

            if(p1Hand == dealer && p1Hand != 0){ // The player and dealer are = at the start at 0, so this condition was added

                gameNum = gameNum + 1;
                System.out.println("START GAME #" + gameNum);
                tie = tie + 1;

                p1Hand = 0;
                dealer = 0;
                options = 1;
                continue;
            }

            if (p1Hand == 21){
                System.out.println("BLACKJACK! You win!");

                gameNum = gameNum + 1;
                System.out.println("START GAME #" + gameNum);
                P1wins = P1wins + 1;

                p1Hand = 0;
                dealer = 0;
                options = 1;
            } // continue isn't needed because this is the end
         }
      while (options != endGame); // loop is determined by endGame instead of options so that case 4 will terminate before quitting
    }
}
