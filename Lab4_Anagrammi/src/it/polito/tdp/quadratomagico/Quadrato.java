package it.polito.tdp.quadratomagico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quadrato {

	private Map<Pos, Integer> caselle;
	private List<Pos> posizioni;

	public Quadrato(int lato) {
		caselle = new HashMap<Pos, Integer>();
		posizioni = new ArrayList<Pos>();
		for (int riga = 1; riga <= lato; riga++) {
			for (int colonna = 1; colonna <= lato; colonna++)
				posizioni.add(new Pos(riga, colonna));
		}
	}

	public Integer get(Pos p) {
		return caselle.get(p);
	}

	public void set(Pos p, Integer i) {
		if (caselle.get(p) == null)
			caselle.put(p, i);
		else
			throw new RuntimeException("Casella già occupata!");
	}

	public void delete(Pos p) {
		if (caselle.get(p) != null)
			caselle.put(p, null);
		else
			throw new RuntimeException("Casella già vuota!");
	}
	
	public int size(){
		return posizioni.size();
	}

	public List<Pos> getPosizioni() {
		return posizioni;
	}

}
