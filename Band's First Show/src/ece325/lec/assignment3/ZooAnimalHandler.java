package ece325.lec.assignment3;

import java.util.ArrayList;

public class ZooAnimalHandler implements DanceTherapist, AnimalHandler {
    private ArrayList<ZooAnimal> animals;

    /**
	 * Iniatlize a zooAnimalHandler object
	 */
    public ZooAnimalHandler(ArrayList<ZooAnimal> animals) {
        this.animals = animals; // Iniatialization of ZooAnimalHandler
    }
    
    /**
	 * Randomly select an animal
	 * @return a random animal from the list of the animal
	 */
    public ZooAnimal selectRandomAnimal() {
		int randomIndex = (int) (Math.random()*animals.size()); // generate random number (index) to select the animal randomly
        return animals.get(randomIndex);
    }

    /**
	 * Randomly select an animal and feed it, handling exceptions
	 */
    public void feedRandomAnimal() throws Exception {
        ZooAnimal randomAnimal = selectRandomAnimal(); // feed randomly selected animal
        feed(randomAnimal);
    }

    /**
	 * Try to feed the animal, checking safety requirements and throwing exceptions
	 */
    public void feed(ZooAnimal animal) throws Exception {
        if (animal.isFed()) {
            // if animal is already fed, throw AlreadyFedException
            throw new AlreadyFedException(animal.getName() + " already ate and may get a belly ache!");
        } else if (!animal.hasDanced()) {
            // if animal hasn't danced yet, throw DidNotDanceException
            throw new DidNotDanceException(animal.getName() + " did not dance yet!");
        } else {
            // feed the animal if it has already danced and not already fed
			animal.feed();
        }
    }

    /**
	 * Randomly select an animal to dance, handling exceptions
	 */
    public void inviteRandomAnimalToDance() throws Exception {
        ZooAnimal randomAnimal = selectRandomAnimal(); // randomly select animal to dance
        inviteAnimalToDance(randomAnimal);
    }

    /**
	 * Invite the animal to dance, verifying safety requirements and throwing exceptions
	 */
    public void inviteAnimalToDance(ZooAnimal animal) throws Exception {
        // if animal is already fed, throw AlreadyFedException
        if (animal.isFed()) {
            throw new AlreadyFedException(animal.getName() + " already ate and is about to vomit!");
        } else {
            // if animal is not fed yet, invite it to dance
			animal.inviteToDance();
        }
    }
}