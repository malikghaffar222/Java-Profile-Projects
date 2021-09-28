
public class Sales extends Employee {
	private double SalesAmount;
	private double CommisionPercent;
	private double housing;

	public Sales(int id, String name, char gender, double basicSalary, double salesAmount, double commisionPercent,
			double housing) {
		super(id, name, gender, basicSalary);
		SalesAmount = salesAmount;
		CommisionPercent = commisionPercent;
		this.housing = housing;
	}

	@Override
	public double getSalary() {
		double salary = ((SalesAmount * CommisionPercent) / 100) + super.getSalary() + housing;
		return salary;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSales Amount: " + SalesAmount + "\nCommision Percent: " + CommisionPercent
				+ "%\nHousing: " + housing;
	}
}
