package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * 
 * @author Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago Acevedo.
 *
 */

public class AlgorithmBM {
	
	/**
	 * NO_OF_CHARS is Integer type.
	 */

	static int NO_OF_CHARS = 256;
	
	/**
	 * This method calculate the max between two numbers.
	 * <b>pre</b>The type must be Integer.<br>
	 * <b>post</b>Must be the max number.<br>
	 * @param a is a number. a must be != 0.
	 * @param b is a number. b must be != 0.
	 * @return the max value.
	 */

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * This method has the functionality to organize the string that receive the algorithm.
	 * <b>pre</b>The arrays must be the type char and Integer.<br> 
	 * <b>post</b>It must be worth for other method.<br>
	 * @param str is the array that has the string. str must be !=null and  != " ".
	 * @param size is the size of the char. size must be != null and != " ".
	 * @param badchar is another array that don't have the "letters" of the text. badchar must be !=null and != " ".
	 */
	void badCharHeuristic(char[] str, int size, int badchar[]) {

		for (int i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		for (int i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

	/**
	 * This method search the char that the user need to find.
	 * <b>pre</b>This must be receive a file and a word.<br>
	 * <b>post</b>This must find the repeated word.<br>
	 * @param text is the entire text that chose the user. text must be!= null and != " "
	 * @param part the part that the algorithm save in the array. part must be != null and != " ".
	 * @return a list with the times that the char is repeated in the text and also the char that the user search
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
