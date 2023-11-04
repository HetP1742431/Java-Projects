package ece325.lec.assignment3;

public interface AnimalHandler {
	/**
	 * Randomly select an animal and return it.
	 */
	public ZooAnimal selectRandomAnimal();
	
	/**
	 * Randomly select an animal and feed it.
	 */
	public void feedRandomAnimal() throws Exception;
	
	/**
	 * Try to feed the animal. If the animal hasn't danced yet, throw the appropriate exception.
	 * If the animal is fed already, throw the appropriate exception. Otherwise, feed the animal.
	 * @param animal	 
	 */
	public void feed(ZooAnimal a) throws Exception;	
}
