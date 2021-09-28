
public class BankAccount {
	private String Name;
	private int AccountNumber;
	private double CurrentAmount;

	public BankAccount() {
	}

	public BankAccount(String name, int accountNumber, double currentAmount) {
		Name = name;
		AccountNumber = accountNumber;
		CurrentAmount = currentAmount;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public double getCurrentAmount() {
		return CurrentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		CurrentAmount = currentAmount;
	}

}
