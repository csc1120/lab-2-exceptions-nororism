/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Marco Nororis
 * Last Updated: 9/11/2024
 */
package nororism;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Driver class for assignment
 */
public class Driver {
    public static void main(String[] args){
        boolean complete = false;
        do {
            try {
                int[] in = getInput();
                Die[] dice = createDice(in[0], in[1]);
                int[] rolls = rollDice(dice, in[1], in[2]);
                int i = findMax(rolls);
                report(in[0], rolls, i);
                complete = true;


            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Please enter a valid number of sides\n");
            } catch (NullPointerException e){
                System.out.println();
            } catch (DieNotRolledException e) {
                throw new RuntimeException(e);
            }

        } while(!complete);
    }

    /**
     * getInput() This method will ask the user for three numbers,
     * entered on a single line and separated by spaces and return these
     * values in the same order as they were entered in an array. These numbers will be:
     * The number of dice to roll in the experiment
     * The number of sides these dice will have
     * How many times the dice will be rolled
     * @return
     * array of numbers
     */
    private static int[] getInput() throws NullPointerException{

        int[] values = new int[3];
        String input;
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the number of dice to roll, how many sides the dice have" +
                           "and how many rolls to complete, separating the values by a space" +
                           " Example: \"2 6 1000\"");
        System.out.println("Enter configuration: ");

        int var = 0;
        try{
            input = in.nextLine();
            Scanner buf = new Scanner(input);
            values[0] = buf.nextInt();
            var++;
            values[1] = buf.nextInt();
            var++;
            values[2] = buf.nextInt();

            return values;
        } catch (InputMismatchException e){
            System.out.println("Please enter only enter 3 integers followed by a space");
        } catch (NoSuchElementException e){
            System.out.println("Only found " + var + " element(s), excepting 3");
        }

        throw new NullPointerException();
    }

    /**
     * Creates an array of the desired amount of dice and fills them with new dice
     * @param numDice
     * number of new dice to make
     * @param numSides
     * number of sides for each new dice
     * @return
     * returns the array with the new dice
     */
    private static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; numDice > i; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }


    /**
     * Creates an array of ints the size of the amount of possible values of the dice in the
     * dice array created in createDice, rolls the dice, and tallies the values of each occurrence
     * @param dice
     * the dice array created in createDice
     * @param numSides
     * number of sides gotten from getInput
     * @param numRolls
     * number of times to roll each dice gotten from getInput
     * @return
     * returns an array containing the amount of occurrences per value
     * @throws DieNotRolledException
     * checked exception from the Die classes roll method that makes sure the dice have been rolled
     */
    private static int[] rollDice(Die[] dice, int numSides, int numRolls)
            throws DieNotRolledException {

        int totalValues = numSides * (dice.length);
        int total = 0;
        int[] value = new int[totalValues - dice.length+1];
        for(int i = 0; i < numRolls; i++){
            for(Die j: dice){
                j.roll();
                total += j.getCurrentValue();
            }
            value[total-dice.length]++;
            total = 0;
        }
        return value;
    }

    /**
     * finds the value that has been rolled the most in the int array from rollDice
     * @param rolls
     * the int array gotten from rollDice
     * @return
     * returns the value with the most occurrences
     */
    private static int findMax(int[] rolls){
        int big = 0;
        int values = 0;
        for(int i = 0; rolls.length > i; i++){
            if(rolls[i] >= big){
                big = rolls[i];
                values = i;
            }
        }
        return values+2;
    }

    /**
     * prints each possible value the dice could have rolled and their occurrences with asterisks
     * comparing them to the value with the most occurrences to have a visual of the amount of occurrences
     * @param numDice
     * the number of dice gotten from getInput
     * @param rolls
     * the number of rolls gotten from getInput
     * @param max
     * the value with the most amount of occurrences gotten from findMax
     */
    private static void report(int numDice, int[] rolls, int max){
        double scale = (double) rolls[max-2]/10;
        int num = numDice;
        for(int i: rolls){
            String s = "*";
            System.out.printf("%-2d:%-6d%-6s%n", num, i, s.repeat((int) (i/scale)));
            num++;
        }
    }
}
