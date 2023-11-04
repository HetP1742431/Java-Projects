package ece325.lec.assignment3;

public interface DanceTherapist {
	/**
	 * Invite a random animal to start dancing to the music. 
	 */
	public void inviteRandomAnimalToDance() throws Exception;
	
	/**
	 * Invite animal to dance. Make sure to verify if it is safe to dance for the animal.
	 * @param the animal to invite 
	 */
	public void inviteAnimalToDance(ZooAnimal animal) throws Exception;
}
