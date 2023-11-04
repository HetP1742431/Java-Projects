package ece325.labs.lab4;

import java.util.ArrayList;

public class SongCollection {
	private ArrayList<Song> songs;

	/**
     * Constructor to create an empty SongCollection.
     */
	public SongCollection() {
		songs = new ArrayList<>();
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
	 * 
	 * @param s
	 */
	public void add(Song s) {
		// Check if the song already exists in the collection
        if (songs.contains(s)) {
            // Song already exists, update its average rating
            for (Song existingSong : songs) {
                if (existingSong.equals(s)) {
                    existingSong.addRating(s.getRating().getAvgRating());
                    break;
                }
            }
        } else {
            // Song doesn't exist, add it to the collection
            songs.add(s);
        }
    }

	/**
     * Remove a song from the collection.
     * @param s The Song to remove.
     */
	public void remove(Song s) {
		if (songs.contains(s)) {
			songs.remove(s);
		}
	}

	/**
     * Check if the collection contains a specific song.
     * @param s The Song to check for.
     * @return True if the song is in the collection, false otherwise.
     */
	public boolean contains(Song s) {
		for (Song song : songs) {
			if (s.equals(song)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Get a song at a specific index in the collection.
     * @param index The index of the song to retrieve.
     * @return The Song at the specified index.
     */
	public Song getSong(int index) {
		return songs.get(index);
	}

	/**
     * Get the number of songs in the collection.
     * @return The number of songs in the collection.
     */
	public int getNumberOfSongs() {
		return songs.size();
	}

	/**
     * Get all the songs in the collection.
     * @return An ArrayList of all the songs in the collection.
     */
	public ArrayList<Song> getSongs() {
		return songs;
	}

	/**
     * Returns a string representation of the SongCollection.
     * @return A string representation of the object.
     */
	public String toString() {
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
}