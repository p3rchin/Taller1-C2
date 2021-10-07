/**
 * Package containing the class
 */
package co.edu.unbosque.model;
// JAVA program for implementation of KMP pattern

import java.util.ArrayList;

/**
 * 
 * @author Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago Acevedo.
 *
 */

public class AlgorithmKMP {
	
	/**
	 * This method preprocess the pattern by calculate the loops using the other method down here this search the index and save them.
	 * <b>pre</b>The part must be inside the text.<br>
	 * <b>post</b>An arrayList with the index position must be returned and the amount.<br>
	 * @param txt is the all text. txt must be != " ".
	 * @param pat is the part that has the string[ ]. pat must be != " " and != null.
	 * @return a list with the amount of times that the char is finding and also the char itself.
	 */
	
	public ArrayList<Integer> KMPSearch(String txt, String pat) {
		ArrayList<Integer> lista = new ArrayList<>();
		int amount = 0;
		int M = pat.length();
		int N = txt.length();

		int lps[] = new int[M];
		int j = 0;

		computeLPSArray(pat, M, lps);

		int i = 0;
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				amount++;
				lista.add(i - j);
				j = lps[j - 1];
			}

			else if (i < N && pat.charAt(j) != txt.charAt(i)) {

				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		lista.add(amount);
		return lista;
	}

	/**
	 * This method calculate the loop, this also search the char.
	 * <b>pre</b>The part in the text must be worth for the method.<br>
	 * <b>post</b>The lps of the array must be founded.<br>
	 * @param pat is the part of the string. pat must be != null and != " ".
	 * @param M is the middle of the loop. M must be != null and != " ".
	 * @param lps is the array of loop. lps must be != null and != " ".
	 */
	
	public void computeLPSArray(String pat, int M, int lps[]) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {

				if (len != 0) {
					len = lps[len - 1];

				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
