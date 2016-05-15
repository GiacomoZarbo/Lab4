package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.anagrammi.DAO.DAO;

public class Model {

	DAO dao;

	public Model() {
		dao = new DAO();
	}

	public List<String> anagrammaParola(String parola) {
		Anagramma anagramma = new Anagramma();
		List<Character> caratteri = new ArrayList<Character>();
		for (int i = 0; i < parola.length(); i++)
			caratteri.add(i, parola.charAt(i));
		List<String> parole = anagramma.anagrammaParola(caratteri);
		System.out.println(caratteri);
		return parole;
		
	}

	public boolean isContenutaInDizionario(String parola) {
		if (dao.isContenutaInDizionario(parola))
			return true;
		else
			return false;
	}
}
