package ece325.lec.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SongCollectionArrayList {
	private ArrayList<String> songs;

	/**
	 * Create a SongCollectionArrayList object.
	 * 
	 */
	public SongCollectionArrayList() {
		songs = new ArrayList<String>();
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

		// ff song is not in the collection
		songs.add(s);
		return true; // addition of song successful
	}

	/**
	 * Remove s from the collection.
	 * @param s the song to be removed
	 */
	public void remove(String s) {
		songs.remove(s); // remove song from ArrayList
	}

	/**
	 * Return true if the collection contains s, false otherwise.
	 * @param s the song to be searched for
	 * @return
	 */
	public boolean contains(String s) {
		return songs.contains(s); // look up for the song in the collection
	}
	
	/**
	 * If there is a song at position index in the collection, return it. Otherwise return null.
	 * @param index the index of the song to return
	 * @return
	 */
	public String getSong(int index) {
		if (index >= 0 && index < songs.size())
		{
			return songs.get(index); // return the song at specified index
		}
		return null; // if index doesn't exist or out of bound
	}

	/**
	 * Return the number of songs in the collection.
	 * @return
	 */
	public int getNumberOfSongs() {
		return songs.size(); // returns number of songs
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
		
		SongCollectionArrayList collection = new SongCollectionArrayList(); // iniatlize the SongCollectionArrayList

		for (String song : songList)
		{
			collection.add(song); // add songs from songList to collection, ensuring uniqueness 
		}

		System.out.println("Number of unique songs: " + collection.getNumberOfSongs());
	}

}
