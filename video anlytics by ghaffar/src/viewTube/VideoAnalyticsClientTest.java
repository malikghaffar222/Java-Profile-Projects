package viewTube;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideoAnalyticsClientTest {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

	@BeforeEach
	public void setUp() throws Exception {
		currentMethodName = null;
	}

	@Test @Graded(description="Client works as expected", marks=4)
	public void testGetLog() {
		assertEquals("4\n" + 
				"190\n" + 
				"0\n" + 
				"90\n" + 
				"-1\n" + 
				"1\n" + 
				"Taxicab\n" + 
				"Day 1 views: 10\n" + 
				"Day 2 views: 70\n" + 
				"Day 3 views: 20\n" + 
				"Day 4 views: 90", VideoAnalyticsClient.getLog());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if(currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score+=graded.marks();
			result+=graded.description()+" passed. Marks awarded: "+graded.marks()+"\n";
		}
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		if(result.length() != 0) {
			result = result.substring(0, result.length()-1); //remove the last "\n"
		}
		System.out.println(result+"\nIndicative Total for VideoAnalyticsClient: "+score+" out of 5");
		if(score == 4) {
			System.out.println("VideoAnalyticsClient - Nice work!");
		}

		//		String name = "NAME_ME_HERE".replace("./","");
		//		String markMessage = name.substring(0, 7)+","+score;
		//		System.out.println(markMessage+",\""+result+"\"\n");
		//		File file = new File("./reports/"+name.substring(0, 7)+".txt");
		//		FileWriter writer = new FileWriter(file);
		//		writer.write(markMessage+",\""+result+"\"\n");
		//		writer.flush();
		//		writer.close();
	}

}
