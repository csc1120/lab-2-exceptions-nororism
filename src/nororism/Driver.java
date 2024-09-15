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

public class Driver {
    public static void main(String[] args){
        do {
            try {
                int[] in = getInput();
                Die[] dice = createDice(in[1], in[2]);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number of sides");
            }
        } while(1==1);
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
    private static int[] getInput(){

        int[] values = new int[3];
        String input;
        Scanner in = new Scanner(System.in);
        boolean isValid = false;

        System.out.println("Please enter the number of dice to roll, how many sides the dice have" +
                           "and how many rolls to complete, separating the values by a space" +
                           "Example: \"2 6 1000\"");
        System.out.println("Enter configuration: ");

        do{
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
            } catch (NoSuchElementException f){
                System.out.println("Only found " + var + "elements, excepting 3");
            }
        } while (isValid);
        return null;
    }

    private static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; numDice > i; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    private static int[] rollDice(Die[] dice, int numSides, int numRolls){
        return null;
    }

    private static int findMax(int[] rolls){
        return 0;
    }

    private static void report(int numDice, int[] rolls, int max){

    }
}
