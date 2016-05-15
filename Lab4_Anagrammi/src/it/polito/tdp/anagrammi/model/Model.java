package it.polito.tdp.anagrammi.model;

import java.util.List;
import it.polito.tdp.anagrammi.DAO.DAO;

public class Model {

	DAO dao;

	public Model() {
		dao = new DAO();
	}

	public List<String> anagrammaParola(String parola) {
		Anagramma anagramma = new Anagramma();
		List<String> parole = anagramma.anagrammaParola(parola);
		return parole;
		
	}

	public boolean isContenutaInDizionario(String parola) {
		if (dao.isContenutaInDizionario(parola))
			return true;
		else
			return false;
	}
}
