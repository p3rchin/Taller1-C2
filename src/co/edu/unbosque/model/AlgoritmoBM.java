package co.edu.unbosque.model;

public class AlgoritmoBM {

	static int NO_OF_CHARS = 256;

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static void badCharHeuristic(char[] str, int size, int badchar[]) {

		for (int i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		for (int i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

	public static int search(String text, String part) {
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

//				System.out.println("Palabra encontrada en index = " + s);

				s += (s + m < n) ? m - badchar[txt[s + m]] : 1;

			}

			else

				s += max(1, j - badchar[txt[s + j]]);
		}
		return contador;
	}

}
