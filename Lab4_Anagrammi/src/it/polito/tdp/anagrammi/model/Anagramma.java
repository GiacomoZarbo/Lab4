package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Anagramma {

	int conta = 0;

	public List<String> anagrammaParola(List<Character> caratteri) {
		List<String> parole = new LinkedList<String>();
		anagrammaRic(caratteri, parole, 0, "");
		return parole;
	}

	public void anagrammaRic(List<Character> caratteri, List<String> parole, int step, String parola) {
		if (step == caratteri.size()) {
			if (!parole.contains(parola))
				parole.add(parola);
		}

		for (int i = 0; i < caratteri.size(); i++) {
			if (!parola.contains("" + caratteri.get(i))) {
				parola += "" + caratteri.get(i);
				anagrammaRic(caratteri, parole, step + 1, parola);
				parola = parola.substring(0, parola.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Anagramma a = new Anagramma();
		ArrayList<Character> caratteri = new ArrayList<Character>();
		caratteri.add('D');
		caratteri.add('O');
		caratteri.add('G');
		List<String> parole = a.anagrammaParola(caratteri);
		for (String s : parole) {
			System.out.println(s);
		}
	}
}
