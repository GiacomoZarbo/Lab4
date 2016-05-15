package it.polito.tdp.quadratomagico;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {

	private int conta;

	public int contaSoluzioni(int lato) {

		Quadrato q = new Quadrato(lato);
		conta = 0;

		int step = 0;

		cerca(q, step);

		return conta;
	}

	private void cerca(Quadrato q, int step) {
		Check check = new Check();
		if (step == q.size()) {
			if (check.check(q)) {
				System.out.format("Conta : %d.\n%d %d %d\n%d %d %d\n%d %d %d\n\n", conta+1, q.get(new Pos(1, 1)),
						q.get(new Pos(1, 2)), q.get(new Pos(1, 3)), q.get(new Pos(2, 1)), q.get(new Pos(2, 2)),
						q.get(new Pos(2, 3)), q.get(new Pos(3, 1)), q.get(new Pos(3, 2)), q.get(new Pos(3, 3)));
				this.conta++;
			}
		} else {

			Pos p = q.getPosizioni().get(step);
			List<Integer> numeri = new ArrayList<Integer>();
			for (int x = 1; x <= 9; x++) {
				boolean trovato = false;
				for (Integer i : numeri) {
					if (i == x)
						trovato = true;
				}
				if (!trovato) {
					q.set(p, x);
					cerca(q, step + 1);
					q.delete(p);
					numeri.add((Integer) x);
				}
			}
		}
	}

	public static void main(String[] args) {
		Ricerca r = new Ricerca();
		r.contaSoluzioni(3);
	}

}
