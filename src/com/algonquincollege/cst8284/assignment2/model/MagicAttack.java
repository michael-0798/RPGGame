/*
 * Copyright(2021) Algonquin College
 * CST8284 (21W) Assignment 2 Starter Code
 * name: Michael Wang
 * student number: 040990568
 * section: 310
 */
package com.algonquincollege.cst8284.assignment2.model;

/**
 * class MagicAttack is a sub class of Attack, which will be implemented by the 
 * object instance from class BlueDragon
 * @author mikew
 * @version 1.0
 * @since Mar 1, 2021
 */
public class MagicAttack extends Attack{
	
	/**
	 * non-args constructor, calls the int-constructor
	 * set the default value of the field damage, which is 0
	 */
	public MagicAttack() {
		this(0);
	}
	
	/**
	 * int constructor, chained in the non-parametered constructor
	 * call the super constructor
	 * @param damage: the damage value to be set into the ojbect
	 */
	public MagicAttack(int damage) {
		super(damage);
	}

}
