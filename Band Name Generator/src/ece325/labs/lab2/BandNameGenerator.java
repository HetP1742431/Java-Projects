package ece325.labs.lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;
	
	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;
	
	String adjectivesFile;
	String nounsFile;
	
	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;
	}
	
	
	/**
	 * Load the adjectives file and initialize that part of the generator.
	 */
	public void loadAdjectives() {
		adjectives = getAdjectives();
		adjectivesLoaded = true;
	}
	
	/**
	 * Load the nouns file and initialize that part of the generator.
	 */
	public void loadNouns() {
		nouns = getNouns();
		nounsLoaded = true;
	}
			
	/**
	 * Return a string that capitalizes only the first letter of s. So for example,
	 * cat becomes Cat.
	 * 
	 * @param s
	 * @return
	 */
	public String capitalizeFirst(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1); // use the "toUppercase" method of String
	}
	
	
	/** 
	 * Generate a name for your band consisting of two adjectives and one noun.
	 * Make sure to return "UNINITIALIZED" if the band name generator is not initialized correctly yet.
	 * @return the generated name or "UNINITIALIZED"
	 */
	public String generateName() {
		String finalName = "UNINITIALIZED"; // initialize the band name as "UNINITIALIZED"
		// return "UNINITIALIZED" if  either of adjectives or nouns are not initialized correctly
		if (!adjectivesLoaded || !nounsLoaded) {
			return finalName;
		}
		
		int adjectivesLength = adjectives.length; // get the number of adjectives in array
		int nounsLength = nouns.length; // get the number of nouns in array
		int randomAdjNo1 = (int) (Math.random()*adjectivesLength); // Select 2 random adjectives from the list of adjectives using Math.random()
		int randomAdjNo2 = (int) (Math.random()*adjectivesLength); // Cast double to integer
		int randomNounNo1 = (int) (Math.random()*nounsLength); // Select a random noun from the list of nouns using Math.random()
		
		// use capatializeFirst method of the class to capitalize the first letter of 2 adjectives and 1 noun
		finalName = capitalizeFirst(adjectives[randomAdjNo1]) + " " + capitalizeFirst(adjectives[randomAdjNo2]) + " " + capitalizeFirst(nouns[randomNounNo1]);
		return finalName;
	}

	
	/**
	 * This method loads a text file into a String array. It assumes the number of 
	 * lines in the file is on the first line of the file itself.
	 * 
	 * Note: you are not allowed to make changes to this method. You can use this method for 
	 * loading text files in the other lab and course assignments as well.
	 * 
	 * @param file
	 * @return
	 */
	private String[] loadTxt(String file) {
		String[] data = new String[0];
		BufferedReader in = null;
		
		try { 
			in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			while((line = in.readLine()) != null)
			{
				data[i] = line;
				i++;
				
			}
		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();			
		}
		finally {
			if(in != null) { 
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Problem closing file: " + file);
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	/**
	 * Returns the list of adjectives.
	 * @return
	 */
	public String[] getAdjectives() {
		adjectives = loadTxt(adjectivesFile);	// create the array of adjectives from the file using loadTxt method
		return adjectives;
	}
	
	/**
	 * Returns the list of nouns.
	 * @return
	 */
	public String[] getNouns() {
		nouns = loadTxt(nounsFile); // create the array of nouns from the file using loadTxt method
		return nouns;
	}
	
	public static void main(String[] args) {
		// create a BandNameGenerator and initialize it
		BandNameGenerator myBand = new BandNameGenerator("adjectives.txt", "nouns.txt");
		myBand.loadAdjectives(); //loads the adjectives file and initializes the generator
		myBand.loadNouns(); //loads the nouns file and initializes the generator

		// generate and print 20 names for your band
		for(int i = 0; i < 20; i++){
			System.out.println(myBand.generateName());
		}
	}

}