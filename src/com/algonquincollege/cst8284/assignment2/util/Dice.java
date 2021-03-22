/*
 * name: Michael Wang
 * student number: 040990568
 * section: 310
 */
package com.algonquincollege.cst8284.assignment2.util;

/**
 * the enum Dice contains 7 and only 7 instances, every instance representing a dice:
 * For example, FOUR means a dice with 4 sides from 1-4,
 * SIX means a dice with 6 sides from 1-6, and so on.
 * 
 * @author mikew
 * @since  March 1, 2021
 * @version 1.0
 *
 */
public enum Dice {
	
	/**
	 * create the constant instances, each object pass a specific integer to the 
	 * constructor's parameter, for example, Dice FOUR passes 4, Dice SIX passes 6
	 * and so on. 
	 */
	FOUR(4),
	SIX(6),
	EIGHT(8),
	TEN(10),
	TWELVE(12),
	TWENTY(20),
	HUNDRED(100);
	
	/**
	 * the int "value" representing the max number which is expected after the
	 * dice is rolled, for example, FOUR's max expected number after being rolled
	 * is 4; SIX is 6, and so on;
	 * this attribute is private, so as to prevent being changed outside the class
	 */
	private int value;
	
	/**
	 * private constructor, so that no more Dice object can be created outside.
	 * 
	 * @param num: 	the number which is set as the attribute "value", 
	 * ie. Dice FOUR passes 4, SIX passes 6, and so on
	 */
	private Dice(int num) {
		this.value = num;
	}

	/**
	 * get the value of "value" of dice
	 * @return the value after the dice is rolled
	 */
	public int getValue() {
		return value;
	}

}
