package BlackJackgame;

//Created by Clayton Paplaczyk

/*
All number cards are the same number that they are on the card. All face cards are
worth 10, but an Ace will give you the option to select if you want to use it as either
a 1 or a 10. All random cards are random, hopefully you do not come across 5 of the same 
card in one hand.
 */

import java.io.*;
import java.math.*;
import java.util.Scanner;

public class Cards
{
	public static void main (String[] args)
	{
		String line = new String();
		String inputInfo = new String();
		boolean operation = false;
		char input1;

		double dealerCardTotal, playerCardTotal = 0, dealer1Card, dealer2Card, firstCard, secondCard = 0;

		try
		{
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader stdin = new BufferedReader (isr);

			do
			{
				System.out.print("What action would you like to perform?\n");
				line = stdin.readLine().trim();  //read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1)    //check if a user entered only one character
				{
					switch (input1)
					{
					case 'D':  //Play Game
						System.out.print("Your Cards will now be dealt.");
						//inputInfo = stdin.readLine().trim();

						//Dealer cards
						dealer1Card = Math.floor(Math.random());
						dealer2Card = Math.floor(Math.random());

						//Players first two cards
						firstCard = Math.floor(Math.random());
						secondCard = Math.floor(Math.random());

						//Total for Dealer, two cards
						dealerCardTotal = dealer1Card + dealer2Card;
						//Total for player, two cards
						playerCardTotal = firstCard + secondCard;

						//Player BlackJack
						if(playerCardTotal == 21){
							System.out.println("BlackJack, you win! :)");
						}
						//Dealer BlackJack
						else if(dealerCardTotal == 21){
							System.out.println("Dealer BlackJack! :'(");
						}
						//Player busts
						else if(playerCardTotal > 21){
							System.out.println("You bust, dealer wins this time.");
						}
						//Game starts
						else if(dealerCardTotal >= playerCardTotal){
							//Hit for Player
							//user = scan.nextInt();     // reads an integer entered by a user
							//if(user == 1){
							playerCardTotal += Math.floor(Math.random());
						}
						else 
							System.out.println("Error, sorry about that one...");
					}	

					break;
				case 'Q':   //Quit Game
					break;
				case '?':   //Display Menu
					printMenu();
					break;
				default:
					System.out.print("Unknown action\n");
					break;
				}

				else
				{
					System.out.print("Unknown action\n");
				}
			} while (input1 != 'Q' || line.length() != 1);
		}
		catch (IOException exception)
		{
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu()
	{
		System.out.println("Choice\t\tAction\n" +
				"------\t\t------\n" +
				"D\t\tDeal Cards\n" +
				"Q\t\tQuit\n" +
				"?\t\tDisplay Help\n\n");
	}
} // end of BlackJack class

