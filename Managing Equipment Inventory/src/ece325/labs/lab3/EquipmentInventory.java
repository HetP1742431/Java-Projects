package ece325.labs.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EquipmentInventory {

	/** The list of all your equipment objects */
	ArrayList<Equipment> inventory;
	/** The number of objects per type of equipment, grouped by the String description of a type */
	HashMap<String, Integer> inventoryCount;

	/** 
	 * Create an EquipmentInventory object by initializing the inventory and inventoryCount objects.
	 */
	public EquipmentInventory() {
		inventory = new ArrayList<>();
		inventoryCount = new HashMap<>();
	}

	/**
	 * Add e to the inventory, and if the add is successful, increase the number of that equipment type in your inventoryCount.
	 * Make sure that you cannot accidentally add the same object twice.
	 * @param e The equipment object to add
	 */
	public void add(Equipment e) {
		if (!inventory.contains(e)) {
			inventory.add(e); // if the inventory doesn't contain the equipment, add it to the inventory ArrayList
			increaseInventoryCount(e);
		}
	}

	/**
	 * Remove e from the inventory and if successful, decrease the number of that equipment type in your inventoryCount.
	 * @param e The equipment object to remove
	 */
	public void remove(Equipment e) {
		if (inventory.contains(e)) {
			inventory.remove(e); // if we only have 1 equipment of type "e", remove it from the inventory
			decreaseInventoryCount(e);
		}
	}

	/**
	 * Increase the inventoryCount for the type of equipment of e by 1.
	 * If it does not exist in the inventoryCount yet, add the type to the inventoryCount.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to increase the inventoryCount
	 */
	protected void increaseInventoryCount(Equipment e) {
		if (inventoryCount.containsKey(e.toString())) {
			int currentValue = getInventoryCount(e); // get how many of this equipment do we already have from the inventoryCount
			int newValue = currentValue + 1; // add one to the count of this equipment
			inventoryCount.put(e.toString(), newValue); // add the new count number to our inventoryCount hashmap
		}
		else {
			inventoryCount.put(e.toString(), 1); // if it's not already in the inventoryCount, make the count of this equipment 1
		}
	}

	/**
	 * Decrease the inventoryCount for the type of equipment of e by 1.
	 * If the inventoryCount for this type is now 0, remove the type from the inventoryCount.
	 * If the inventoryCount does not contain this type of equipment, do nothing.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to decrease the inventoryCount
	 */
	protected void decreaseInventoryCount(Equipment e) {
		if (inventoryCount.containsKey(e.toString())) {
			int currentValue = getInventoryCount(e); // get how many of this equipment do we already have from the inventoryCount hashmap
			int newValue = currentValue - 1; // reduce one from the count of this equipment
			inventoryCount.put(e.toString(), newValue); // add the new count number to our inventoryCount
			// if the inventoryCount for this equipment is now 0
			if (getInventoryCount(e) == 0) {
				inventoryCount.remove(e.toString()); // remove the equipment from the inventoryCount
			}
		}
		else {
			return; // if inventoryCount doesn't have an equipment, do nothing
		}
	}

	/** 
	 * Return the number of times this type of equipment occurs in the inventory.
	 * If it doesn't occur in the inventory, return -1 (to indicate that something went wrong somewhere).
	 * @param e
	 * @return
	 */
	public Integer getInventoryCount(Equipment e) {
		if (!inventoryCount.containsKey(e.toString())) {
			return -1;
		}
		else {
			return inventoryCount.get(e.toString());
		}
	}
	
	/**
	 * Return the String representation of the EquipmentInventory.
	 * It should look similarly to the following:
	 * [EquipmentInventory: Guitar: 3, Stool: 3, Chair: 1, Keyboard: 2]
	 * (after adding 3 guitars, 3 stools, 1 chair and 2 keyboards).
	 * The order in which the types are printed does not matter.
	 * @return the string representation of the EquipmentInventory
	 */
	public String toString() {
		String result = "[EquipmentInventory: ";
        for (String key : inventoryCount.keySet()) {
			result += key + ": " + inventoryCount.get(key) + ", ";
        }
		if (result.length() > 21) {
			result = result.substring(0, result.length() - 2);
		}
        result += "]";
		return result;
	}

	public static void main(String[] args) {
		EquipmentInventory inventory = new EquipmentInventory(); // iniatialize the EquipmentInventory object
		
		// generate 3 Guitar objects
		Guitar G1 = new Guitar();
		Guitar G2 = new Guitar();
		Guitar G3 = new Guitar();
		// add 3 guitars to the inventory
		inventory.add(G1);
		inventory.add(G2);
		inventory.add(G3);
		
		// generate 2 Keyboard objects
		Keyboard K1 = new Keyboard();
		Keyboard K2 = new Keyboard();
		// add 2 keyboards to the inventory
		inventory.add(K1);
		inventory.add(K2);

		// generate 3 Stool objects
		Stool S1 = new Stool();
		Stool S2 = new Stool();
		Stool S3 = new Stool();
		// add 3 stools to the inventory
		inventory.add(S1);
		inventory.add(S2);
		inventory.add(S3);

		// generate 1 Chair objects
		Chair C1 = new Chair();
		// add 1 chair to the inventory
		inventory.add(C1);

		System.out.println(inventory.toString()); // print equipment inventory

		// remove 1 Keyboard and 1 Stool from the inventory
		inventory.remove(K1);
		inventory.remove(S1);
		
		System.out.println(inventory.toString()); // print inventory after selling 1 keyboard and 1 stool
	}
}