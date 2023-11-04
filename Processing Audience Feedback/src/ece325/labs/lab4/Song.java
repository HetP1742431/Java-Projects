package ece325.labs.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Song {
	private String title;
	private ArrayList<String> instruments;
	private AverageRating averageRating;
	
	/**
     * Constructor to create a Song with a title, list of instruments, and initial rating.
     * @param title The title of the song.
     * @param instruments The list of instruments used to play the song.
     * @param rating The initial rating for the song.
     */
	public Song(String title, ArrayList<String> instruments, AverageRating rating) {
		// Constructor implementation
		this.title = title;
		this.instruments = instruments;
		this.averageRating = rating;
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Song otherSong = (Song) o; // type casting an Object to Song
		// Sort the instruments so that we can compare the ArrayLists to check if the Songs have same instruments
		Collections.sort(instruments);
		Collections.sort(otherSong.instruments);

		if (title == null || !title.equals(otherSong.getTitle())) return false; // Return false if titles are not equal
		return instruments.equals(otherSong.getInstruments()); // Return true if instruments are same for both songs
	}
	
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Song s) {
		if (this == s) return true;
		if (s == null) return false;

		// Sort the instruments so that we can compare the ArrayLists to check if the Songs have same instruments
		Collections.sort(instruments);
		Collections.sort(s.instruments);

		if (title == null || !title.equals(s.getTitle())) return false; // Return false if titles are not equal
		return instruments.equals(s.getInstruments()); // Return true if instruments are same for both songs
	}
	
	/**
     * Get the list of instruments.
     * @return The Arraylist of instruments.
     */
	public ArrayList<String> getInstruments() {
		return instruments;
	}
	
	/**
     * Add a rating to the song.
     * @param rating The rating to add.
     */
	public void addRating(float rating) {
		averageRating.addRating(rating);
	}
	
	/**
     * Get the rating object for the song.
     * @return The rating object.
     */
	public AverageRating getRating() {
		return this.averageRating;
	}
	
	/**
     * Get the title of the song.
     * @return The title.
     */
	public String getTitle() {
		return this.title;
	}
	
	/**
     * Returns a string representation of the Song.
     * @return A string representation of the object.
     */
	public String toString() {
		return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]"; 
	}
}