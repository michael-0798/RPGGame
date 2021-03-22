package com.algonquincollege.cst8284.assignment2.model;
/**
 * The class 'AttackOptional' is built only for the Optional Bonus Question in Assignment2, 
 * showing the possibility to replace subclass ('FireAttack' and 'FrostAttack') 
 * by using instance 'fields' (attackName) in the superclass (which is the class 
 * 'Attack' originally).
 * This class will NOT be initialized in any situation in this program. 
 * 
 * The class 'DefendTest' is used only to demonstrate the method 'defend()' in
 * the class 'Character', which could identify the attack type via the 
 * field(attackName) in the class 'AttackOptional'. 
 * 
 * Only the new added/edited parts will be JavaDoced, to make the class more readable.
 * 
 * @author 	mikew
 * @since  	Mar 1, 2021
 * @version	1.0
 */
public class AttackOptional {
	
	/**
	 * add field as "attackName", which could be set value as "frostAttack",
	 * "magicAttack" or "fireAttack" when being initialized.
	 */
	private String attackName;
	
	private int damage;
	
	/**
	 * non-parameter constructor, set the default value of attackName as "magicAttack"
	 */
	public AttackOptional() {
		this(0, "magicAttack");
	}
	
	/**
	 * add 1 String parameter to set the value of attackName; 
	 * @param damage		the damage value of the attack
	 * @param attackName	the attack type, for example: fireAttack, forstAttack
	 */
	public AttackOptional(int damage, String attackName) {
		this.damage = damage;
		this.attackName=attackName;
	}

	/**
	 * same as the original Attack class
	 * @return the damage value of attack
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * same as the original Attack class
	 * @param damage: the damage value of the attack
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * same as the original Attack class
	 */
	@Override
	public String toString() {
		String className = getClass().getName();
		int index = className.lastIndexOf("."); // where is last . in packages
		if(index != -1) {
			className = className.substring(index + 1); // +1 to skip the . char
		}
		return String.format("%s with %d damage", className,
				getDamage());
	}

	/**
	 * get the attack name(type)
	 * @return the attack name(type) of the attack
	 */
	public String getAttackName() {
		return attackName;
	}

	/**
	 * set the attack name(type)
	 * @param attackName	the attack name(type) to be set, for example: fireAttack
	 */
	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}
}

/**
 * the DefendTest class is built only to demostrate that we could identify the 
 * attack types via fild "attackName" in Attack class
 * @author mikew
 * @version 1.0
 */
class DefendTest{
	// the paramerter type is AttackOptional instead of Attack
	public AttackReport defend(AttackOptional attack){
		// use switch case to identify the attack type
		switch(attack.getAttackName()) {
		case "fireAttack":
			System.out.println("it's a fire attack");
			break;
		case "magicAttack":
			System.out.println("it's magic");
			break;
		case "frostAttack":
			System.out.println("it's frost attack");
			break;
		}
		
		AttackReport result = null;
		// omit the codes here 
		return result;
	}
}
