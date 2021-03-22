/*
 * name: Michael Wang
 * student number: 040990568
 * section: 310
 */
package com.algonquincollege.cst8284.assignment2.util;

import java.util.Random;

/**
 * This class contains utility methods to simulate rolling a variety of 
 * polyhedral dice, 4-sided, 6-sided, 8-sided, 10-sided, 12-sided, 20-sided
 * and 100-sided.
 * 
 * @author piedas
 */
public class DiceBag {
	/**
	 * This instance of random is used for all of the 
	 * methods in the class.
	 */
	private static Random random = new Random();
	
	/**
	 * the method will pass the Dice object, and return the value which will 
	 * be in the range of 1 to dice.getValue(); 
	 * for example, roll(Dice FOUR) will return an integer from 1-4;
	 * 
	 * @param dice:	the instance of enum Dice
	 * @return	the integer which representing the number after the dice is rolled
	 */
	public static int roll(Dice dice) {
		return random.nextInt(dice.getValue())+1;
	}
}
