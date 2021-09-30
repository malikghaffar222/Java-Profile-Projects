import java.util.ArrayList;
import java.util.Scanner;

public class Question2_20500463 {

	public static void main(String[] args) {
		int numberOfPurchases = 0;
		int totalPurchaseCost = 0;
		double totalrewardPoints = 0, averageRewardPoints = 0;
		// list to store reward points
		ArrayList<RewardPoints_20500463> arrayList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of purchases made: ");
		numberOfPurchases = input.nextInt();
		for (int i = 0; i < numberOfPurchases; i++) {
			// getting user input for each purchase
			System.out.print("Enter purchase cost for purchase #" + (i + 1) + " : ");
			int purchaseCost = input.nextInt();
			System.out.print("Enter customer name : ");
			String customerName = input.next();

			// initating reward points
			RewardPoints_20500463 points = new RewardPoints_20500463(purchaseCost, customerName);
			arrayList.add(points);
		}
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println("Customer name: " + arrayList.get(i).getCustomerName());
			System.out.println("Purchase Cost: " + arrayList.get(0).getPurchaseCost());
			System.out.println("Reward Points for purchase #" + (i + 1) + " : " + arrayList.get(0).getRewardPoints());
			totalPurchaseCost += arrayList.get(i).getPurchaseCost();
			totalrewardPoints += arrayList.get(i).getRewardPoints();
		}
		averageRewardPoints = totalrewardPoints / arrayList.size();
		System.out.println("Total Purchase Cost: " + totalPurchaseCost);
		System.out.println("Total Rewards points: " + totalrewardPoints);
		System.out.println("Average Reward Points: " + averageRewardPoints);

	}

}
