package co.edu.unbosque.model;

import java.util.ArrayList;

public class AlgorithmBM {

	static int NO_OF_CHARS = 256;

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * This method has the functionality to organize the string that receive the
	 * algorithm
	 * 
	 * @param str     is the array that has the string.str!=null, str!=" "
	 * @param size    is the size of the char.size!=null, str!=" "
	 * @param badchar is another array that don't have the "letters" of the
	 *                text.badchar!=null, str!=" "
	 */
	void badCharHeuristic(char[] str, int size, int badchar[]) {

		for (int i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		for (int i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

	/**
	 * This method search the char that the user need to find
	 * 
	 * @param text is the entire text that chose the user.text!=null, text!=" "
	 * @param part the part that the algorithm save in the array.part!=null, part!=" "
	 * @return a list with the times that the char is repeated in the text and also
	 *         the char that the user search
	 */

	public ArrayList<Integer> search(String text, String part) {
		ArrayList<Integer> lista = new ArrayList<>();
		char txt[] = text.toCharArray();
		char pat[] = part.toCharArray();
		int m = pat.length;
		int n = txt.length;
		int contador = 0;
		int badchar[] = new int[NO_OF_CHARS];
		badCharHeuristic(pat, m, badchar);
		int s = 0;
		while (s <= (n - m)) {
			int j = m - 1;

			while (j >= 0 && pat[j] == txt[s + j])
				j--;
			if (j < 0) {
				contador++;
				lista.add(s);

				s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
			} else

				s += max(1, j - badchar[txt[s + j]]);
		}
		lista.add(contador);
		return lista;
	}
}
