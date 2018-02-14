import java.util.Scanner;

public class Blackjack
{
public static void main(String args[]) {

    Scanner scnr = new Scanner(System.in);
    P1Random rng = new P1Random();

    int gameNum,
        myNum,
        newNum,
        handNum,
        menuOpt,
        dealerNum,
        myWins,
        dealerWins,
        gameDraws;

        gameNum = 1;
        myWins = 0;
        dealerWins = 0;
        gameDraws = 0;

    //Game Begins/resets variable values for next game.

    while (gameNum >= 1)
    {
        myNum = 0;
        dealerNum = 0;
        handNum = 0;

        System.out.println("START GAME #" + gameNum);
        System.out.println("");

    //Generates "random" card, displays it to player and adds it to player's hand. Checks player's hand for win or loss.

        while (myNum < 21 && dealerNum == 0)
        {
            newNum = rng.nextInt(13) + 1;

            if (newNum > 1 && newNum <= 10)
            {
                System.out.println("Your card is a " + newNum + "!");
            }
            else
            {
                switch (newNum)
                {
                    case 1:
                        System.out.println("Your card is a ACE!");
                        break;
                    case 11:
                        System.out.println("Your card is a JACK!");
                        newNum--;
                        break;
                    case 12:
                        System.out.println("Your card is a QUEEN!");
                        newNum -= 2;
                        break;
                    case 13:
                        System.out.println("Your card is a KING!");
                        newNum -= 3;
                        break;
                }
            }
            handNum = newNum + myNum;
            System.out.println("Your hand is: " + (handNum));
            myNum = handNum;

            if (handNum == 21)
            {
                System.out.println();
                System.out.println("BLACKJACK! You win!");
                myWins++;
            }
            else if (handNum > 21)
            {
                System.out.println();
                System.out.println("You exceeded 21! You lose.");
                dealerWins++;
            }
            else
            {

    //Displays menu.

                menuOpt = 0;
                while (menuOpt < 1 || menuOpt > 4 || menuOpt == 3)
                {
                    System.out.println();
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");

                    System.out.println();

                    System.out.print("Choose an option: ");
                    menuOpt = scnr.nextInt();
                    if (menuOpt < 1 || menuOpt > 4)
                    {
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                    }

    //Responds to menu command.

                    switch (menuOpt)
                    {
                        case 1:
                            break;
                        case 2:
                            dealerNum = rng.nextInt(11) + 16;
                            break;
                        case 3:
                            System.out.println("Number of Player wins: " + myWins);
                            System.out.println("Number of Dealer wins: " + dealerWins);
                            System.out.println("Number of tie games: " + gameDraws);
                            System.out.println("Total # of games played is: " + (gameNum - 1));
                            System.out.println("Percentage of Player wins: " + ((((double) (myWins)) / ((double) (gameNum - 1))) * 100) + "%");
                            break;
                        case 4:
                            System.exit(0);
                            break;
                    }
                }
            }
            System.out.println();
        }

    /*Handles ties and Dealer wins/losses. Increases game number if
    game ends and restarts or loops back to generate another card.*/

        if (handNum < 21)
        {
            System.out.println("Dealer's hand: " + dealerNum);
            System.out.println("Your hand is: " + handNum);
            System.out.println();
        }
            if (myNum == dealerNum)
            {
                System.out.println("It's a tie! No one wins!");
                gameDraws++;
                System.out.println();
            }
            else if (dealerNum == 21)
            {
                System.out.println("Dealer wins!");
                dealerWins++;
                System.out.println();
            }
            else if (dealerNum > 21)
            {
                System.out.println("You win!");
                myWins++;
                System.out.println();
            }
            else if (myNum < 21 && dealerNum <21)
            {
                if (dealerNum > myNum)
                {
                    System.out.println("Dealer wins!");
                    dealerWins++;
                    System.out.println();
                }
                else if (myNum > dealerNum)
                {
                    System.out.println("You win");
                    myWins++;
                    System.out.println();
                }
            }
        gameNum++;
        }
    }
}