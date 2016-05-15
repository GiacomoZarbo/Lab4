package it.polito.tdp.quadratomagico;

public class Check {

	public boolean check(Quadrato q) {
		if (checkRows(q)) {
			if (checkColumns(q)) {
				if (checkDiagonals(q))
					return true;
			}
		}
		return false;
	}

	public boolean checkRows(Quadrato q) {
		if ((q.get(new Pos(1, 1)) + q.get(new Pos(1, 2)) + q.get(new Pos(1, 3)) == 15)
				&& (q.get(new Pos(2, 1)) + q.get(new Pos(2, 2)) + q.get(new Pos(2, 3)) == 15)
				&& (q.get(new Pos(3, 1)) + q.get(new Pos(3, 2)) + q.get(new Pos(3, 3)) == 15))
			return true;
		return false;
	}

	public boolean checkColumns(Quadrato q) {
		if ((q.get(new Pos(1, 1)) + q.get(new Pos(2, 1)) + q.get(new Pos(3, 1)) == 15)
				&& (q.get(new Pos(1, 2)) + q.get(new Pos(2, 2)) + q.get(new Pos(3, 2)) == 15)
				&& (q.get(new Pos(1, 3)) + q.get(new Pos(2, 3)) + q.get(new Pos(3, 3)) == 15))
			return true;
		return false;
	}

	public boolean checkDiagonals(Quadrato q) {
		if ((q.get(new Pos(1, 1)) + q.get(new Pos(2, 2)) + q.get(new Pos(3, 3)) == 15)
				&& (q.get(new Pos(1, 3)) + q.get(new Pos(2, 2)) + q.get(new Pos(3, 1)) == 15))
			return true;
		return false;
	}
}
