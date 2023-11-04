package ece325.labs.lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SongLoader {
	/**
	 * Load a SongCollection from a file. Uses one or more Scanners to read the
	 * file, create Song objects and insert them into a SongCollection.
	 * 
	 * 
	 * The input is of the format: Songtitle; Instruments; Rating 
	 * Contribution;Guitar,Guitar,Drums;4.5
	 * 
	 * (see songratings.txt for the full input)
	 * 
	 * @param file
	 * @return the loaded SongCollection
	 */
	public static SongCollection loadSongs(String file) {
		SongCollection songCollection = new SongCollection(); // Iniatialze the songCollection object

		BufferedReader reader = null;
		Scanner s = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			s = new Scanner(reader);
			s.useDelimiter("\n"); // take new line each time

			while(s.hasNext()) {
				String line = s.next();
				Song song = parseSong(line);
				songCollection.add(song);
			}
		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();			
		}
		finally {
			// Close all the resources
			try {
                if (reader != null) {
                    reader.close();
                }
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
		}
		return songCollection;
	}

	/**
	 * Parse a Song object from the String and return it. If the String cannot be
	 * parsed into a Song, throw an InvalidSongFormatException.
	 * 
	 * @param songString
	 * @return
	 * @throws InvalidSongFormatException
	 */
	public static Song parseSong(String songString) throws InvalidSongFormatException {
		Scanner s = null;
		ArrayList<String> parts = new ArrayList<>();
		
		try {
			s = new Scanner(songString);
			s.useDelimiter(";");
			while (s.hasNext()) {
				parts.add(s.next());
			}
		}
		finally {
			if (s != null) {
				s.close();
			}
		}

		if (parts.size() != 3) {
            throw new InvalidSongFormatException("Invalid song format: " + songString);
        }

		// Generate the title, instruments and rating for a Song
		String title = parts.get(0);
    	String instruments = parts.get(1);
    	String ratingStr = parts.get(2);

    	// Check if the title is a non-empty string
    	if (title.isEmpty()) {
        	throw new InvalidSongFormatException("Song title cannot be empty: " + songString);
    	}

    	// Check if the instruments is a non-empty string
    	if (instruments.isEmpty()) {
        	throw new InvalidSongFormatException("Instruments list cannot be empty: " + songString);
    	}

    	// Parse the rating as a float while checking for ann exception
    	float rating;
    	try {
            rating = Float.parseFloat(ratingStr);
            // Check for the song rating range
            if (rating < 0 || rating > 10) {
                throw new InvalidSongFormatException("Invalid rating range: " + rating);
			}
        } catch (NumberFormatException e) {
    	    throw new InvalidSongFormatException("Invalid rating format: " + songString);
    	}

    	return new Song(title, parseInstrumentsList(instruments), new AverageRating(rating));
	}

	/**
	 * Uses a scanner to parse the instruments string into an ArrayList of String
	 * objects. You can assume that the string comes in CSV (comma-separated-value)
	 * format, and that it is valid CSV (so no need to do error checking or account
	 * for issues with the data).
	 * 
	 * @param instruments
	 * @return an ArrayList with one String per parsed instrument
	 */
	public static ArrayList<String> parseInstrumentsList(String instruments) {
		Scanner s = null;
		ArrayList<String> instrumentList = new ArrayList<>();

		try {
			s = new Scanner(instruments);
			s.useDelimiter(",");
			while (s.hasNext()) {
				instrumentList.add(s.next());
			}
		}
		finally {
			if (s != null) {
				s.close();
			}
		}
		
        return instrumentList;
    }

	public static void main(String[] args) {
		String file = "songratings.txt";
		System.out.println(SongLoader.loadSongs(file));
	}
}