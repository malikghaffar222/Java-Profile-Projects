import java.util.ArrayList;

public class ApiPracticeRunner {
	public static void main(String[] args) {
		print("hypotenuse(3, 4)", ApiPractice.hypotenuse(3, 4), 5.0);
		print("max(-3, 1)",  ApiPractice.max(-3, 1), 1);
		print("max(40, 40)", ApiPractice.max(40, 40), 40);
		print("max(4, 10)",  ApiPractice.max(4, 10), 10);
		print("min(-3, 1)",  ApiPractice.min(-3, 1), -3);
		print("min(40, 40)", ApiPractice.min(40, 40), 40);
		print("min(4, 10)",  ApiPractice.min(4, 10), 4);
		print("max(\"cat\", \"dog\")", ApiPractice.max("cat", "dog"), "dog");
		print("max(\"Cat\", \"dog\")", ApiPractice.max("cat", "Dog"), "cat");
		print("min(\"cat\", \"dog\")", ApiPractice.min("cat", "dog"), "cat");
		print("min(\"Cat\", \"dog\")", ApiPractice.min("cat", "Dog"), "Dog");
		
		String str1 = "cat";
		String str2 = new String("cat");
		String str3 = "Cat";
		print("isSameText(str1, str2)", 
			ApiPractice.isSameText(str1, str2), true);		
		print("isSameText(str1, str3)", 
			ApiPractice.isSameText(str1, str3), false);
		
		String a = "abc"; 
		String b = "abcd"; 
		String c = "ab"; 
		String d = "wxyz";
		print("getLongestString(a, b, c)", 
			ApiPractice.getLongestString(a, b, c), b);
		print("getLongestString(a, b, d)", 
			ApiPractice.getLongestString(a, b, d), b);
		
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("abcde");
		stringList.add("abc");
		stringList.add("xyz");
		stringList.add("jklm");
		print("getShortestString(stringList)", 
			ApiPractice.getShortestString(stringList), "abc");
		
		ArrayList<String> stringList2 = new ArrayList<String>();
		print("getShortestString(*empty list*)",
			ApiPractice.getShortestString(stringList2), null);
		
		String commaString = "Once upon a time, there lived a cat.";
		print("getStringBeforeComma(commaString)", 
			ApiPractice.getStringBeforeComma(commaString), 
			"Once upon a time");	
		print("getStringAfterComma(commaString)", 
			ApiPractice.getStringAfterComma(commaString), 
			" there lived a cat.");
	}
	
	private static void print(String methodCall, double result, 
			double expected) {
		System.out.print("Result of " + methodCall + ": [" + result + "] ");
		if (result == expected) System.out.println("Good!");
		else System.out.println("Incorrect. Expected [" + expected + "]");
	}

	private static void print(String methodCall, String result, 
			String expected) {
		System.out.print("Result of " + methodCall + ": [" + result + "] ");
		if ((result == null && expected == null) || 
			 result.equals(expected)) System.out.println("Good!");
		else System.out.println("Incorrect. Expected [" + expected + "]");
	}
	
	private static void print(String methodCall, boolean result, 
			boolean expected) {
		System.out.print("Result of " + methodCall + ": [" + result + "] ");
		if (result == expected) System.out.println("Good!");
		else System.out.println("Incorrect. Expected [" + expected + "]");
	}

	private static void printBlankLine() {
		System.out.println();
	}
}
