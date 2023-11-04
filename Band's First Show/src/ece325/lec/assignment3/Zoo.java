package ece325.lec.assignment3;

import java.util.ArrayList;

/**
 * You do not have to make changes to this class.
 *
 */
public class Zoo {
	private ArrayList<ZooAnimal> animals;
	private ZooAnimalHandler handler;
	
	
	/** 
	 * Creates a new zoo and adds the animals who currently live in the zoo to it.
	 */
	public Zoo() {
		animals = new ArrayList<ZooAnimal>();
		addAnimals();
		handler = new ZooAnimalHandler(animals);
	}	
	
	/**
	 * Add all the animals who currently live in the zoo. After you create a Zoo object,
	 * there is no need to call this method again.
	 * 
	 * Side note: these are all real animals! Google them if you don't believe it.
	 */
	private void addAnimals() {
		animals.add(new ZooAnimal("Wunderpus photogenicus"));
		animals.add(new ZooAnimal("Spiny Lumpsucker"));
		animals.add(new ZooAnimal("Pleasing Fungus Beetle"));
		animals.add(new ZooAnimal("Pink Fairy Armadillo"));
		animals.add(new ZooAnimal("Rasberry Crazy Ant"));
		animals.add(new ZooAnimal("Satanic Leaf-Tailed Gecko"));
		animals.add(new ZooAnimal("Tasselled Wobbegong"));
		animals.add(new ZooAnimal("Hellbender"));
		animals.add(new ZooAnimal("Chicken Turtle"));
		animals.add(new ZooAnimal("Star-Nosed Mole"));	
	}
	
	public ArrayList<ZooAnimal> getAnimals(){
		return animals;
	}
	
	public boolean allAnimalsFed() {
		for(ZooAnimal a : animals) {
			if(!a.isFed())
				return false;
		}
		System.out.println("All animals fed! Thanks!");
		return true;
	}
	
	public ZooAnimalHandler getAnimalHandler() {
		return handler;
	}	
}
