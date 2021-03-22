/*
 * Copyright(2021) Algonquin College
 * CST8284 (21W) Assignment 2 Starter Code
 * name: Michael Wang
 * student number: 040990568
 * section: 310
 */
package com.algonquincollege.cst8284.assignment2.model;

import com.algonquincollege.cst8284.assignment2.util.Dice;
import com.algonquincollege.cst8284.assignment2.util.DiceBag;

/**
 * BlueDragon is a subclass of Characer, it inherites all the fields from the 
 * parent, also overides the attack() and defend() methods according to the rules
 * of the game.
 * @author mikew
 * @version 1.0
 * @since Mar 1, 2021
 */
public class BlueDragon extends Character{
	
	/**
	 * Max health for the character as an integer value.
	 */
	private int maxHealth;
	
	/**
	 * Current health for the character as an integer value.
	 */
	private int currentHealth;
	
	/**
	 * Strength of the character as an integer value.
	 */
	private int strength;

	/**
	 * The non-args constructor, set the value for the fields when being initialized 
	 * maxHealth will be 1 to 400 (inclusive, D4*D100), 
	 * current health should be exactly the same as the Max health when being initialized
	 * strength will be 4 to 32 (inclusive, 4*D8)
	 * @see DiceBag
	 */
	public BlueDragon() {
		maxHealth = DiceBag.roll(Dice.FOUR)*DiceBag.roll(Dice.HUNDRED);
		currentHealth = maxHealth;
		strength = 4*DiceBag.roll(Dice.EIGHT);
	}

	/**
	 * This constructor calls the super constructor, allows specific values to be set.
	 * @param maxHealth the maximum health of the character
	 * @param currentHealth the current health of the character
	 * @param strength the strength of the character
	 */
	public BlueDragon(int maxHealth, int currentHealth, int strength) {
		super(maxHealth, currentHealth,strength);
	}
	
	/**
	 * attack() method is overrided by the class BlueDragon,
	 * it will return subclass of the class Attack, in this case, there are 
	 * 80% chances to return MagicAttack's object, and 20% to return FrostAttack;
	 * both MagicAttack and FrostAttack will set the damage value as 4*D12;
	 */
	@Override
	public Attack attack() {
		int chance = DiceBag.roll(Dice.HUNDRED); 
		if(chance>0 && chance<=80 ) {
			MagicAttack att = new MagicAttack(4*DiceBag.roll(Dice.TWELVE));
			return att;
		}else {
			FrostAttack att = new FrostAttack(4*DiceBag.roll(Dice.TWELVE));
			return att;
		}
	}
	
	/**
	 * This method is overided. processes an Attack made against this character,
	 * to determine if the damage value was taken or if the damage was 
	 * reduced or increased. 
	 * in this case, if the attack is fire attack, then the damage value will be 
	 * double; if it's a frost attack, there will be no damage caused; if magic 
	 * attack, then normal harm;
	 * @param attack the Attack against this character
	 * @return an AttackReport on how this character defended
	 */
	@Override
	public AttackReport defend(Attack attack) {
		
		// create an object of AttackReport
		AttackReport result = null;
		
		if(attack != null) {
			result = new AttackReport();
			int damage;
			// if attack is a fire attack
			if(attack instanceof FireAttack) {
				damage = 2*attack.getDamage();
				
//				this.currentHealth-=damage; 	
//				note: can't use the solution above commented!!!!
//				"this" here refer to Chacter, not Dragon, 
//				Because it's the field (instead of the method) to be called, 
//				So it is Character's currentHealth which is called and changed
//				So, we must call the method, which refer to the actual instance of Dragon 
				
				this.setCurrentHealth(this.getCurrentHealth()-damage);
				result.setReport(getTypeClassName() + " was hit by fire attack, caused double damage, ");
				result.setActualDamage(damage);
				
			// if attack is a frost attack
			}else if(attack instanceof FrostAttack) {
				damage = 0;
				this.setCurrentHealth(this.getCurrentHealth()-damage);
				result.setReport(getTypeClassName() + " was hit by frost attack, but ZERO damage, ");
				result.setActualDamage(damage);
				
			// if attack is a magic attack, normal harm
			}else {
				damage = attack.getDamage();
				this.setCurrentHealth(this.getCurrentHealth()-damage);
				result.setReport(getTypeClassName() + " was hit by magic attack, caused full damage, ");
				result.setActualDamage(damage);
			}
		}
		return result;
	}
	
}
