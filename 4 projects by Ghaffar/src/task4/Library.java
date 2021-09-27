package task4;

public class Library {
	private String name;
	private int nbGames;
	private VideoGame[] arrGames;

	Library(String name, int size) {
		this.name = name;
		arrGames = new VideoGame[size];
	}

	public boolean addGame(VideoGame game) {
		if (nbGames >= arrGames.length)
			return false;
		arrGames[nbGames++] = game;
		return true;
	}

	public double calcAverage() {
		if (nbGames == 0)
			throw new ArithmeticException();
		double avgPrice = 0;
		for (int i = 0; i < nbGames; i++) {
			avgPrice += arrGames[i].getPrice();
		}
		avgPrice = avgPrice / nbGames;
		return avgPrice;
	}

	public Physical[] getGames(String s, int p) {
		if (nbGames == 0)
			return null;
		Physical[] physicals = new Physical[split(new Physical[nbGames], new Digital[nbGames])];
		int j = 0;
		for (int i = 0; i < nbGames; i++) {
			if (arrGames[i].getStudio().equals(s) && arrGames[i].getPrice() < p)
				physicals[j++] = (Physical) arrGames[i];
		}
		return physicals;
	}

	public int split(Physical[] ph, Digital[] dg) {
		if (nbGames == 0)
			return -1;
		int j = 0, k = 0;
		for (int i = 0; i < nbGames; i++) {
			if (arrGames[i].getClass().equals("Physical"))
				ph[j++] = (Physical) arrGames[i];
			else if (arrGames[i].getClass().equals("Digital"))
				dg[k++] = (Digital) arrGames[i];
		}
		return j;
	}
}
