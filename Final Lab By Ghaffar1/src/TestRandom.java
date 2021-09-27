class NewRandom extends java.util.Random {
	public String nextLetters() {
		char n1 = (char) (nextInt(26) + 97);
		char n2 = (char) (nextInt(26) + 97);
		char n3 = (char) (nextInt(26) + 97);
		return n1 + "" + n2 + "" + n3 + "";
	}
}

public class TestRandom {
	public static void main(String[] args) {
		NewRandom random = new NewRandom();
		System.out.println("First Call: " + random.nextLetters());
		System.out.println("2nd Call: " + random.nextLetters());
		System.out.println("3rd Call: " + random.nextLetters());

	}
}
