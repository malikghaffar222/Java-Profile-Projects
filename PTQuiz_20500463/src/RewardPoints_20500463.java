
public class RewardPoints_20500463 {
	int purchaseCost;
	String customerName;
	double rewardPoints;

	public RewardPoints_20500463(int purchaseCost, String customerName) {
		this.purchaseCost = purchaseCost;
		this.customerName = customerName;
		double bonusPoints = 0;

		if (purchaseCost >= 1000) {
			bonusPoints = 500;
		}
		rewardPoints = purchaseCost * GetPointsPerDollarSpent(purchaseCost) + bonusPoints;

	}

	public int getPurchaseCost() {
		return purchaseCost;
	}

	public void setPurchaseCost(int purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(double rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public static void main(String[] args) {
	}

	double GetPointsPerDollarSpent(int purchaseCost) {
		double pointsEarned = 0;
		if (purchaseCost < 100) {
			pointsEarned = 1;
		} else if (purchaseCost >= 100 && purchaseCost < 500) {
			pointsEarned = 1.5;

		} else if (purchaseCost >= 500 && purchaseCost < 1000) {
			pointsEarned = 2;
		} else if (purchaseCost >= 1000) {
			pointsEarned = 2.5;
		}
		return pointsEarned;
	}
}
