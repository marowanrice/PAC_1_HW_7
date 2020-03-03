// PlayCarGame.java
// Rowan Rice
// October 30, 2019


/* 

Car Game is a program that allows the user to move 10 cars around a 
20 x 20 board.  The cars have four attributes: number, color, ignition state,
and position (x, y).  The color and starting position of the cars will
be set randomly at the start of the program; the ignition will always
start in the off position.  The user selects which car to operate on
and then the program gives the user the choice of turning on the ignition, 
moving the car, or quitting the game as the program moves along.

The program catches errors at each menu (except when the user is 
selecting which car to use) and when a user enters a movement that 
would push the car out of bounds.

*/

import java.util.Scanner;

public class PlayCarGame
{
	public static int CARS = 10;

	public static void main (String [] args)
	{

		System.out.println("Welcome to the Car Game!");

		//initialize car array
		Car [] carArray = new Car[CARS];

		for (int i = 0; i < carArray.length; i++)
		{
			carArray[i] = new Car(i);
		}

		// initialize the loop variable to play the game
		boolean checkGameOn = true;

		Scanner input = new Scanner(System.in);

		int carSelection; // variable for user selection

		while (checkGameOn)
		{
			System.out.print("Which car would you like to use? ");
			System.out.print("(Choose from 1-10):  ");
			carSelection = input.nextInt();
			carSelection -= 1; // makes sure selection matches index in array
			checkGameOn = carArray[carSelection].playGame();
		}
	}

}