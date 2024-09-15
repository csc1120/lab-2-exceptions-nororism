/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Marco Nororis
 * Last Updated: 9/11/2024
 */
package nororism;

import java.util.Random;

/**
 * Die class
 */
public class Die {
    /**
     * minimum sides for the die
     */
    public static final int MIN_SIDES = 2;
    /**
     * maximum sides for the die
     */
    public static final int MAX_SIDES = 100;
    private int currentValue;
    private final int numSides;
    private final Random random;

    /**
     * Die constructor throws IllegalArgumentException if the inputted number of sides is
     * less than 2 or greater than 100 and inputs 0 as the amount of sides.
     * @param numSides
     * a user inputted integer as the number of sides of the die
     * @throws IllegalArgumentException
     * throws IllegalArgumentException if the inputted numSides is less than 2 and more than 100
     */
    public Die(int numSides) throws IllegalArgumentException {
        random = new Random();
        if (numSides > MIN_SIDES && numSides < MAX_SIDES) {
            this.numSides = numSides;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * returns the current value of the die and returns the value to zero
     * @return
     * current value of die
     * @throws DieNotRolledException
     * throws when the current value is 0
     */
    public int getCurrentValue() throws DieNotRolledException{
        if (currentValue == 0){
            throw new DieNotRolledException();
        }
        int value = currentValue;
        currentValue = 0;
        return value;
    }

    /**
     * generates a random number in the bounds set in the constructor
     */
    public void roll(){
        currentValue = random.nextInt(1, numSides+1);
    }
}