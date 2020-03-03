// Car.java
// Rowan Rice
// October 9, 2019

/* 

Car is an object with 4 attributes:
	-- ignition state
	-- color
	-- position (x, y)
	-- number

This class instantiates a Car object and provides the methods 
that manipulate the car's attributes.

*/

import java.util.Scanner;
import java.lang.Math;

public class Car
{
	/* ~~~~Instance Variables~~~~ */
	private boolean ignition;
	private char color;
	private int xPos;
	private int yPos;
	private int carNum;


	/* ~~~~~~~~CONSTANTS~~~~~~~~ */
	public static final char RED = 'R';
	public static final char BLACK = 'B';
	public static final char GREEN = 'G';
	public static final char WHITE = 'W';
	public static final char SILVER = 'S';

	public static final char QUIT_SELECTION = 'Q';
	public static final char IGNITION_SELECTION = 'I';
	public static final char MOVE_SELECTION = 'M';

	public static final char MOVE_VERT = 'V';
	public static final char MOVE_HORIZ = 'H';

	public static final int COLUMNS = 20;
	public static final int ROWS = 20;
	public static final int START = 1;

	public Car(int index)
	{
		ignition = initializeIgnition();
		color = assignColor();
		xPos = randomizePosition();
		yPos = randomizePosition();
		carNum = index + 1; // corrects 0-9 indices to 1-10 cars
	}

	// this is the method that allows the user to play the game with the
	// selected car.  If the user quits the game, the method will return
	// false and the loop (in the main method), that continues asking 
	// the user what car to play with, will stop
	// returns:		- true if the user did not quit the game
	//				- false if the user did quit the game
	public boolean playGame()
	{
		char mainInput; // variable for main menu entry
		char moveInput; // variable for move menu entry
		int moveUnits; // variable for number spaces to move
		boolean continueGame = true; // variable to return; start true

		//int carIndex = carSelected - 1; // calc index in array

		Scanner input1 = new Scanner(System.in);

		printMainMenu(); // asks user for input
		mainInput = input1.next().charAt(0);

		switch (mainInput)
		{
			case QUIT_SELECTION:
			{
				continueGame = false;
				System.out.println("\nThanks for playing!");
				break;
			}

			case IGNITION_SELECTION:
			{
				ignitionSwitch();
				state();
				break;
			}

			case MOVE_SELECTION:
			{
				printMvmtMenu();
				moveInput = input1.next().charAt(0);

				switch (moveInput)
				{
					case MOVE_HORIZ:
					{
						System.out.println("Enter a movement distance: ");
						moveUnits = input1.nextInt();
						moveHorizontally(moveUnits);
						state();
						break;
					}

					case MOVE_VERT:
					{
						System.out.print("\nEnter a movement distance: ");
						moveUnits = input1.nextInt();
						moveVertically(moveUnits);
						state();
						break;
					}

					default:
					{
						System.out.println("Error: invalid direction");
						break;
					}
				}				
				break;
			}

			default: // default in the main game loop (main menu input)
			{
				System.out.println("Error: incorrect input. Try again.");
				break;
			}
		}

		return continueGame;
	}

	/* ~~~~~~~~METHODS~~~~~~~~ */


	// false to start
	private boolean initializeIgnition()
	{
		return false;
	}

	// this method assigns a random color to the car when it's called
	// returns a char (which represents a color)	
	private char assignColor()
	{
		int numToColor = (int)(Math.random() * 5);
		char color;

		switch (numToColor)
		{
			case 0:
				color = RED;
				break;

			case 1:
				color = BLACK;
				break;

			case 2:
				color = GREEN;
				break;

			case 3: 
				color = WHITE;
				break;

			default:
				color = SILVER;
				break;
		}

		return color;
	}

	// this method gives a random number between 1 and 20
	// it's called to give the car a random position at start
	// called for both the horizontal and vertical positions
	private int randomizePosition()
	{
		return ((int) (Math.random()*20)) + 1;
	}

	// prints the main menu - doesn't change instance to instance
	public static void printMainMenu()
	{
		System.out.println("\nWhat would you like to do?");
		System.out.println("I: turn the ignition on/off");
		System.out.println("M: move the car");
		System.out.println("Q: quit this program");
		System.out.print("Input: ");
	}

	// flips the ignition switch (off to on or on to off)
	private void ignitionSwitch()
	{
		ignition = (!ignition);
	}

	// prints the movement menu - doesn't change instance to instance
	public static void printMvmtMenu()
	{
		System.out.println("\nIn which direction do you want to move the car?");
		System.out.println("H: Horizontal");
		System.out.println("V: Vertical");
		System.out.print("Direction: ");
	}

	// moves the car's x-position on the grid
	// only moves if ignition is on
	// if the user entered a value that would move the car out of bounds
	// (either before space 1 or past space 20), then the position is not 
	// updated and the current value remains
	private void moveHorizontally (int mvmtInput)
	{
		int desiredPos = xPos + mvmtInput;

		if (ignition) // checks to see if ignition is on
		{
			if ((desiredPos <= COLUMNS) && (desiredPos >= START))
			{
				xPos = desiredPos; // only updates position if in bounds
			}
			else
			{
				System.out.println("Error: Out of bounds");
			}
		}
		else // if ignition is off, don't update the position
		{
			System.out.println("Error: Turn the ignition on");
		}

	}

	// moves the car's y-position on the grid
	// only moves if ignition is on
	// if the user entered a value that would move the car out of bounds
	// (either before space 1 or past space 20), then the position is not 
	// updated and the current value remains
	private void moveVertically (int mvmtInput)
	{
		int desiredPos = yPos + mvmtInput;

		if (ignition) // check to see if ignition is on 
		{
			if ((desiredPos <= ROWS) && (desiredPos >= START))
			{
				yPos = desiredPos; // only updates position if in bounds
			}
			else
			{
				System.out.println("Error: Out of bounds");
			}
		}
		else // if ignition is off, don't update the position
		{
			System.out.println("Error: Turn the ignition on");
		}

	}
	
	private void state ()
	{
			System.out.println("\nCar Information");
			System.out.println("Car: " + getCarNum());
			System.out.println("Color: " + translateColorChar(getColor()));
			System.out.println("Ignition: " + translateIgnition(getIgnition()));
			System.out.println("Location: (" + getX() + ", " + getY() + ")\n");
			
			printGrid();
	}

	// prints out the grid and the car's position in the grid 
	private void printGrid ()
	{
			// this first loop will print all the rows up to (not including)
			// the row that the car is in 
			// uses constants to set dimensions
			for (int rows = START; rows < yPos; rows++)
			{
				for (int cols = START; cols <= COLUMNS; cols++)
				{
					System.out.print("- ");
				}
				System.out.println();
			}

			// second loop prints the row that the car is on up to 
			// (not including) the car position
			for (int carColumn = START; carColumn < xPos; carColumn++)
			{
				System.out.print("- ");
			}

			// print car
			System.out.print(color + " ");

			// third loop prints the the rest of the row that the car is on
			for (int colsRem = START; colsRem <= (COLUMNS - xPos); colsRem++)
			{
				System.out.print("- ");
			}
			System.out.println();

			// fourth loop prints all the rows below the car 
			for (int rowRem = START; rowRem <= (ROWS - yPos); rowRem++)
			{
				for (int cols = START; cols <= COLUMNS; cols++)
				{
					System.out.print("- ");
				}
				System.out.println();
			}
	}
	
	public int getCarNum()
	{
		return carNum;
	}

	public char getColor()
	{
		return color;
	}

	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}

	public boolean getIgnition()
	{
		return ignition;
	}

	// translates the char that represents the car's color into a 
	// word to be printed for the user 
	// doesn't change instance to instance
	public static String translateColorChar (char c)
	{
		switch (c)
		{
			case RED:
			{
				return "Red";
			}

			case BLACK:
			{	
				return "Black";
			}

			case GREEN:
			{	
				return "Green";
			}

			case WHITE:
			{	
				return "White";
			}

			default:
			{	
				return "Silver";
			}
		}
	}

	// translates the boolean that represents the car's ignition
	// state into a word to be printed for the user
	// doesn't change instance to instance
	public static String translateIgnition (boolean ign)
	{
		if (ign)
		{
			return "On";
		}

		return "Off";
	}
	
} 
