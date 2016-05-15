package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {

	List<String> permutations = null;

	public List<String> anagrammaParola(String word) {

		permutations = new ArrayList<String>();
		anagramma_ric(word, 0);

		return permutations;
	}

	private void anagramma_ric(String word, int passo) {
		if (passo == word.length()) {
			if (!permutations.contains(word))
				permutations.add(word);
			return;
		}

		for (int i = passo; i < word.length(); i++) {

			char[] chars = word.toCharArray();

			// Genero una nuova soluzione
			char temp = chars[passo];
			chars[passo] = chars[i];
			chars[i] = temp;

			// Richiamo la funzione ricorsiva
			anagramma_ric(String.valueOf(chars), passo + 1);

			// Trasformando l'array di chars non è necessario fare backtrack.
		}
	}

	public static void main(String[] args) {
		Anagramma a = new Anagramma();
		String parola = "DOG";
		List<String> parole = a.anagrammaParola(parola);
		for (String s : parole) {
			System.out.println(s);
		}
	}
}
