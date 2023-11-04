package ece325.lec.assignment3;

/**
 * Finish the implementation of this class. No need to add any instance variables or methods
 *
 */
public class ZooAnimal {
	/**
	 * True iff the animal was fed already.
	 */
	private boolean isFed;
	
	/**
	 * True iff the animal has danced already.
	 */
	private boolean hasDanced;
	
	/**
	 * The name of the animal.
	 */
	private String name;
	
	/**
	 * Iniatlize a zooAnimal object
	 */
	public ZooAnimal(String name) {
		isFed = false;
		hasDanced = false;
		this.name = name;
	}
			
	/**
	 * Returns true iff the animal was fed already during the concert.
	 * @return true if the animal was fed
	 */
	public boolean isFed() {
		return isFed;
	}
	
	/**
	 * Feed the animal.
	 */
	public void feed() {
		isFed = true;
	}	
	
	
	/**
	 * Invite an animal to dance. There's a 50% chance they actually start to dance when they are invited.
	 */	
	public void inviteToDance() {
		hasDanced = (Math.random()) < 0.5; // Assign true to 'hasDanced' with a 50% probability (randomly)
	}
	
	/** 
	 * Return true iff the animal has already danced.
	 * @return true if the animal has danced
	 */
	public boolean hasDanced() {
		return hasDanced;
	}
	
	/** 
	 * Return the name of the animal.
	 * @return the name of the animal
	 */
	public String getName() {
		return name;
	}
}