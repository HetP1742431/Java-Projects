package ece325.lec.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SongCollectionArray {
	private String[] songs;
	private int size; // To keep track of the number of songs in the collection

	/**
	 * Create a SongCollectionArray object with capacity i (= the number of songs it can hold).
	 * @param i the number of songs the collection can hold
	 */
	public SongCollectionArray(int i) {
		songs = new String[i]; // Initialize the array with capacity i
		size = 0; // Inatialize the size to 0
	}
	
	
	/**
	 * Add s to the collection. Only add s if it is not in the collection yet. 
	 * Return true if the addition was successful, otherwise return false.
	 * 
	 * @param s the song to be added
	 * @return
	 */
	public boolean add(String s) {
		// check if the song s is already in the collection
		if (contains(s))
		{
			return false; // song is already in the collection (addition is not successful)
		}

		// if song is not in the collection
		if (size < songs.length)
		{
			songs[size] = s;
			size++; // increment the size counter
			return true; // addition of song successful
		}
		else
		{
			return false; // addition of song is not possible because the collection is full
		}
	}
	
	/**
	 * Remove s from the collection. Make sure that all the empty spots of the array 
	 * are at the end. So if you remove a song from the 'middle' of the array, you need to
	 * make sure that the empty spot is filled up somehow.
	 * @param s the song to be removed
	 */
	public void remove(String s) {

		for (int i = 0; i < size; i++)
		{
			// Check if the given song s is on the collection or not
			if (songs[i] != null && songs[i].equals(s))
			{
				songs[i] = null; // remove the song and replace with null
				
				// move all the elements one slot forward
				for (int j = i; j < size - 1; j++)
				{
					songs[j] = songs[j + 1];
				}
				songs[size - 1] = null; // set the last slot as empty
				size--; // reduce the size counter
				return;
			}
		}
	}
	
	/**
	 * Return true if the collection contains s, false otherwise.
	 * @param s the song to be searched for
	 * @return
	 */
	public boolean contains(String s) {		
		for (int i = 0; i < size; i++)
		{
			// look up for the song in the collection
			if (songs[i] != null && songs[i].equals(s))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * If there is a song at position index in the collection, return it. Otherwise return null.
	 * @param index the index of the song to return
	 * @return
	 */
	public String getSong(int index) {
		if (index >= 0 && index < size)
		{
			return songs[index]; // return the song at specified index
		}
		else
		{
			return null; // if index doesn't exist or out of bound
		}
	}
	
	/**
	 * Return the number of songs in the collection.
	 * @return
	 */
	public int getNumberOfSongs() {
		return size; // returns unique number of songs
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
	private static String[] loadTxt(String file) {
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
	 * Make sure to read the songs.txt file and print the number of unique songs in it.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] songList = loadTxt("songs.txt"); // read the songs.txt file

		SongCollectionArray collection = new SongCollectionArray(songList.length); // iniatlize the SongCollectionArray with the same capacity as number of songs in songs.txt

		for(String song : songList)
		{
			collection.add(song); // add songs from songList to collection, ensuring uniqueness 
		}

		System.out.println("Number of unique songs: " + collection.getNumberOfSongs());
	}
}