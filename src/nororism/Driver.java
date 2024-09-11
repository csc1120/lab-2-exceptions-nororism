/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: FIXME
 * Last Updated: FIXME
 */
package nororism;

public class Driver {
    public static void main(String[] args){
        Die dice = new Die(101);
        for(int i=0; 20 > i; i++){
            dice.roll();
            System.out.println(dice.getCurrentValue());
        }

    }
}