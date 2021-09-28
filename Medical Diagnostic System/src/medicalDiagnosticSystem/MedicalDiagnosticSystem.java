package medicalDiagnosticSystem;

import java.util.Scanner;

public class MedicalDiagnosticSystem {
	private static int questionNumbetr = 1;

	public static int askSymptom(String symptom, int previousInput) {
		if (symptom == "")
			return 0;
		if (!(previousInput == 0 || previousInput == 1)) {
			System.out.println("Invalid input entered!");
			System.out.println("Program terminated!");
			System.exit(0);
		} else if (questionNumbetr != 1)
			System.out.println();
		System.out.println(questionNumbetr++ + ") Do you have " + symptom.toLowerCase() + "?");
		System.out.println("0) No");
		System.out.println("1) YEs");
		System.out.print("Type 0 or 1: ");
		return new Scanner(System.in).nextInt();
	}

	public static void main(String[] args) {
		int fever, shakingChills, profuseSweating, headache, vomiting, diarrhoea, fatigue, suffocation, blueSkin, sinus,
				wateryDiarrhoea, rapidHeartRate, lossOfSkinElasticity, dryMucusMembrane, lowBloodPressure,
				coughForMoreThanThreeWeeks, painWhileBreathing, nightSweat, bloodWithCough;
		fever = askSymptom("fever", 0); // here we can provide 1 too as it is very first question
		shakingChills = askSymptom("shaking chills", fever);
		profuseSweating = askSymptom("profuse sweating", shakingChills);
		headache = askSymptom("headache", profuseSweating);
		vomiting = askSymptom("vomiting", headache);
		diarrhoea = askSymptom("diarrhoea", vomiting);
		fatigue = askSymptom("fatigue", diarrhoea);
		suffocation = askSymptom("suffocation", fatigue);
		blueSkin = askSymptom("blue skin", suffocation);
		sinus = askSymptom("sinus", blueSkin);
		wateryDiarrhoea = askSymptom("watery diarrhoea", sinus);
		rapidHeartRate = askSymptom("rapid heart rate", wateryDiarrhoea);
		lossOfSkinElasticity = askSymptom("loss of skin elasticity", rapidHeartRate);
		dryMucusMembrane = askSymptom("dryMucus membrane", lossOfSkinElasticity);
		lowBloodPressure = askSymptom("low blood pressure", dryMucusMembrane);
		coughForMoreThanThreeWeeks = askSymptom("cough for more than three weeks", lowBloodPressure);
		painWhileBreathing = askSymptom("pain while breathing", coughForMoreThanThreeWeeks);
		nightSweat = askSymptom("night sweat", painWhileBreathing);
		bloodWithCough = askSymptom("blood with cough", nightSweat);

		if (!(bloodWithCough == 0 || bloodWithCough == 1)) {
			System.out.println("Invalid input entered!");
			System.out.println("Program terminated!");
			System.exit(0);
		}

		if (fever == 1 || shakingChills == 1 || profuseSweating == 1 || headache == 1 || vomiting == 1
				|| diarrhoea == 1)
			System.out.println("You have a chance of Malaria, go for a medical test for Malaria.");
		if (shakingChills == 1 || fever == 1 || fatigue == 1 || suffocation == 1 || blueSkin == 1 || sinus == 1)
			System.out.println("You have a chance of Spanish Flu, go for a medical test for Spanish Flu.");
		if (wateryDiarrhoea == 1 || vomiting == 1 || rapidHeartRate == 1 || lossOfSkinElasticity == 1
				|| dryMucusMembrane == 1 || lowBloodPressure == 1)
			System.out.println("You have a chance of Cholera, go for a medical test for Cholera.");
		if (coughForMoreThanThreeWeeks == 1 || painWhileBreathing == 1 || fatigue == 1 || fever == 1 || nightSweat == 1
				|| bloodWithCough == 1)
			System.out.println("You have a chance of Tuberculosis, go for a medical test for Tuberculosis.");
		if (headache == 1)
			System.out.println("You have a chance of Pneumonia, go for a medical test for Pneumonia.");
	}

}