/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: FIXME
 * Last Updated: FIXME
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
     */
    public Die(int numSides) {
        random = new Random();
        int sides;
        try {
            if (numSides > MIN_SIDES && numSides < MAX_SIDES) {
                sides = numSides;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.out.println("sides out of bounds");
            sides = 0;
        }
        this.numSides = sides;
    }

    /**
     * returns the current value of the die and returns the value to zero
     * @return
     * current value of die
     */
    public int getCurrentValue(){
        int value = currentValue;
        try{
            if (currentValue == 0){
                throw new DieNotRolledException();
            }
        } catch (DieNotRolledException e){
            System.out.println("Die value is zero");
        }
        currentValue = 0;
        return value;
    }

    /**
     * generates a random number in the bounds set in the constructor
     */
    public void roll(){
        currentValue = random.nextInt(1,numSides+1);
    }
}