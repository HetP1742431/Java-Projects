package ece325.labs.lab4;

public class AverageRating {
	private float avgRating;
	private float count;
	
	/**
     * Constructor to initialize the AverageRating with an initial rating.
     * @param rating The initial rating.
     */
	public AverageRating(float rating) {
		avgRating = rating;
		count = 1;
	}
	
	/**
	 * Recomputes the average rating taking the new rating r into account.
	 * @param rating The new rating to add.
	 */
	public void addRating(float r) {
		// Update the average rating and increment the count
		avgRating = (avgRating * count + r)/(count + 1);
		count++;
	}
	
	/**
     * Get the current average rating.
     * @return The average rating.
     */
	public float getAvgRating() {
		return avgRating;
	}
	
	/**
     * Returns a string representation of the AverageRating.
     * @return A string representation of the object.
     */
	public String toString() {
		return "[AverageRating: " + avgRating + "]";
	}
}