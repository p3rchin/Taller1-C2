package co.edu.unbosque.model;

import java.util.ArrayList;

public class AlgorithmBM {

	static int NO_OF_CHARS = 256;

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	void badCharHeuristic(char[] str, int size, int badchar[]) {

		for (int i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		for (int i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

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
