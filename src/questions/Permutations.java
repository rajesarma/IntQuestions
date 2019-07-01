package questions;

import java.util.ArrayList;

public class Permutations {

	public static void main (String args[]) {

		
		// Check usage
		/*if (args.length < 1) {
			System.out.println("Usage: java Permutations [word]");
			return;
		}*/

		// Get word
		String word = "abc";

		// Create empty indices ArrayList
		ArrayList<Integer> indices = new ArrayList<Integer>();

		// Get the permutations
		ArrayList<String> permutations = Permutations.getPermutations(word, indices);

		// Display the permutations
		System.out.println(permutations);

		return;
	}

	// Takes a word and an ArrayList of already considered indices
	// Input: word (String), indices (ArrayList<Integer>)
	// Output: ArrayList<String> containing all possible permutations
	public static ArrayList<String> getPermutations (String word, ArrayList<Integer> indices) {

		// Create the empty ArrayList to return
		ArrayList<String> toReturn = new ArrayList<String>();

		// If all characters are considered, we are done. Return empty ArrayList
		if (indices.size() == word.length()) {
			toReturn.add("");
			return toReturn;
		}

		// Iterate over each character to find the permutation
		for (int i = 0; i < word.length(); i++) {

			// Skip if index is already considered
			if (indices.contains(i)) {
				continue;
			}

			// Create and populate a duplicate ArrayList of indices that have already been considered
			ArrayList<Integer> newIndices = new ArrayList<Integer>();
			for (int index : indices) {
				newIndices.add(index);
			}

			// Add current index
			newIndices.add(i);

			// Calculate permutations
			ArrayList<String> permutations = Permutations.getPermutations(word, newIndices);

			// Add the current character before the permutations of the rest of the word
			for (String str : permutations) {
				toReturn.add(word.charAt(i) + str);
			}

		}

		// Return
		return toReturn;

	}

}
