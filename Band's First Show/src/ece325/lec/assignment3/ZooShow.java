package ece325.lec.assignment3;

public class ZooShow {
	
	public static void main(String[] args) throws Exception {
		// create the zoo
		Zoo zoo = new Zoo();
		ZooAnimalHandler handler = zoo.getAnimalHandler();
		
		// for clarity you should handle any exceptions in this class
		while(!zoo.allAnimalsFed()) {
			try {
				handler.inviteRandomAnimalToDance();
				handler.feedRandomAnimal();
			}
			catch(DidNotDanceException e) {
				System.err.println(e.getMessage());
			}
			catch(AlreadyFedException e) {
				System.err.println(e.getMessage());
			}
		}	
		
		
	}
}