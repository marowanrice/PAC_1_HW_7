# PAC_1_HW_7
car game with car objects

GRADE: 9.5/10 -- .5 deducted with "getColor() should return a String as specified in the writeup"

Back to the garage for our third and final Car assignment. This program will be very similar to the previous iterations of
the Car assignment, however, we’ll now be instantiating Car objects. The Car class should have an ignition, a color, and a
position (given by an x coordinate and a y coordinate) as well as various methods to generate and change these instance
variables.

The ignition state and the position state may change during the course of the program’s execution, but the color will stay
the same. Before the user is given control of the car via the menu, the car’s attributes should already be assigned (i.e., it
will have its ignition set to “off”, it will be given a color, and it will have random position coordinates). The car’s current
location will be represented by a char that stands for its color (e.g., “R” for red). Available colors are: Red, Green, Blue,
White, Silver (R, G, B, W, S). The ignition can be set to either on (True) or off (False).

The user should be prompted to choose a car and then, once a car is selected, the user can (i) turn the ignition on/off; (ii)
move the car around the 20x20 grid; (iii) change cars; or (iv) quit the program.

Specific error checking will be expected. The car should be prevented from going out of bounds and, if the ignition is off,
the car should not be able to move anywhere.

Lastly, the most current grid and the status of the car should be printed after each user action (i.e., turning the ignition
on/off, legal movement of the car, and when the user chooses to quit).
