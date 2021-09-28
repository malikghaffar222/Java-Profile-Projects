package viewTube;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.Timeout;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VideoAnalyticsTest {
	VideoAnalytics simple, nullHistory, emptyHistory, longHistory;
	int[] a;
	int[] b;
	int[] c;
	int[] d;
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();
	
	@BeforeEach
	public void setUp() throws Exception {
		currentMethodName = null;
		
		a = new int[] {10,70,20,90,80,5};
		simple = new VideoAnalytics("El Clasico", a);
		
		b = null;
		nullHistory = new VideoAnalytics("Installing Eclipse", b);
		
		c = new int[0]; //empty array
		emptyHistory = new VideoAnalytics("Headphones Review", c);
		
		d = new int[] {10,10,20,10,20,30,10,20,30,40,5,40,50,60,80,70,70,80,90,100,110,120,130,140,150,160,170,180};
		longHistory = new VideoAnalytics("Practical exam walkthrough", d);
	}

	@Test @Order(1) @Graded(description="constructor", marks=8)
	public void testVideoAnalytics() {
		assertEquals("El Clasico", simple.title);
		assertEquals("Installing Eclipse", nullHistory.title);
		assertEquals("Headphones Review", emptyHistory.title);
		assertEquals("Practical exam walkthrough", longHistory.title);
		
		assertNotNull(simple.views);
		assertNotNull(emptyHistory.views);
		assertNotNull(longHistory.views);
		assertNull(nullHistory.views);

		assertNotEquals(a, simple.views, "you are making reference copy, you need to make instance copy. watch week 4 lecture.");
		assertNotEquals(c, emptyHistory.views);
		assertNotEquals(d, longHistory.views);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(2) @Graded(description="getHistoryLength", marks=4)
	public void testGetHistoryLength() {
		assertEquals(6, simple.getHistoryLength());
		assertEquals(0, nullHistory.getHistoryLength());
		assertEquals(0, emptyHistory.getHistoryLength());
		assertEquals(28, longHistory.getHistoryLength());
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();

	}

	@Test @Order(3) @Graded(description="getTotalViews", marks=8)
	public void testGetTotalViews() {
		assertEquals(275, simple.getTotalViews());
		assertEquals(0, nullHistory.getTotalViews());
		assertEquals(0, emptyHistory.getTotalViews());
		assertEquals(2005, longHistory.getTotalViews());
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(4) @Graded(description="indexOfLeastViews", marks=8)
	public void testIndexOfLeastViews() {
		assertEquals(5, simple.indexOfLeastViews());
		assertEquals(null, nullHistory.indexOfLeastViews());
		assertEquals(null, emptyHistory.indexOfLeastViews());
		assertEquals(10, longHistory.indexOfLeastViews());	
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(5) @Graded(description="highestViewCount", marks=8)
	public void testHighestViewCount() {
		assertEquals(90, simple.highestViewCount());
		assertEquals(0, nullHistory.highestViewCount());
		assertEquals(0, emptyHistory.highestViewCount());
		assertEquals(180, longHistory.highestViewCount());		
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(6) @Graded(description="viewsInPercentage", marks=8)
	public void testViewsInPercentage() {
		assertNull(nullHistory.viewsInPercentage());
		assertNotNull(emptyHistory.viewsInPercentage());
		assertEquals(0, emptyHistory.viewsInPercentage().length);
		
		for(int i=0; i < simple.views.length; i++) {
			assertEquals(simple.views[i] * 100.0 / simple.getTotalViews(), simple.viewsInPercentage()[i], 0.01);
		}

		for(int i=0; i < longHistory.views.length; i++) {
			assertEquals(longHistory.views[i] * 100.0 / longHistory.getTotalViews(), longHistory.viewsInPercentage()[i], 0.01);
		}
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(7) @Graded(description="compareTo", marks=8)
	public void testCompareTo() {
		assertEquals(-1, simple.compareTo(longHistory));
		assertEquals(1, longHistory.compareTo(simple));
		int[] e = {15,80,90,20,70};
		
		VideoAnalytics simple2 = new VideoAnalytics("Joga Bonito", e);
		assertEquals(0, simple.compareTo(simple2));
		assertEquals(0, simple2.compareTo(simple));
		
		assertEquals(-1, nullHistory.compareTo(simple));
		assertEquals(1, simple.compareTo(nullHistory));

		assertEquals(0, nullHistory.compareTo(emptyHistory));
		assertEquals(0, emptyHistory.compareTo(nullHistory));
	
		assertEquals(0, nullHistory.compareTo(nullHistory));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(8) @Graded(description="toString", marks=8)
	public void testToString() {
		assertEquals("El Clasico\n" + 
				"Day 1 views: 10\n" + 
				"Day 2 views: 70\n" + 
				"Day 3 views: 20\n" + 
				"Day 4 views: 90\n" + 
				"Day 5 views: 80\n" + 
				"Day 6 views: 5", simple.toString());
		assertEquals("Installing Eclipse - No Views Yet", nullHistory.toString());
		assertEquals("Headphones Review - No Views Yet", emptyHistory.toString());
		assertEquals("Practical exam walkthrough\n" + 
				"Day 1 views: 10\n" + 
				"Day 2 views: 10\n" + 
				"Day 3 views: 20\n" + 
				"Day 4 views: 10\n" + 
				"Day 5 views: 20\n" + 
				"Day 6 views: 30\n" + 
				"Day 7 views: 10\n" + 
				"Day 8 views: 20\n" + 
				"Day 9 views: 30\n" + 
				"Day 10 views: 40\n" + 
				"Day 11 views: 5\n" + 
				"Day 12 views: 40\n" + 
				"Day 13 views: 50\n" + 
				"Day 14 views: 60\n" + 
				"Day 15 views: 80\n" + 
				"Day 16 views: 70\n" + 
				"Day 17 views: 70\n" + 
				"Day 18 views: 80\n" + 
				"Day 19 views: 90\n" + 
				"Day 20 views: 100\n" + 
				"Day 21 views: 110\n" + 
				"Day 22 views: 120\n" + 
				"Day 23 views: 130\n" + 
				"Day 24 views: 140\n" + 
				"Day 25 views: 150\n" + 
				"Day 26 views: 160\n" + 
				"Day 27 views: 170\n" + 
				"Day 28 views: 180", longHistory.toString());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(9) @Graded(description="maxLengthIncreasingViews", marks=4)
	public void testMaxLengthIncreasingViews() {
		assertEquals(2, simple.maxLengthIncreasingViews());
		assertEquals(0, nullHistory.maxLengthIncreasingViews());
		assertEquals(0, emptyHistory.maxLengthIncreasingViews());
		assertEquals(12, longHistory.maxLengthIncreasingViews());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(10) @Graded(description="buckets", marks=4)
	public void testBuckets() {
		assertNull(simple.buckets(0));
		assertNull(simple.buckets(-1));
		assertEquals("[[10], [70], [20], [90], [80], [5]]", Arrays.deepToString(simple.buckets(1)));
		assertEquals("[[10, 70, 20], [90, 80, 5]]", Arrays.deepToString(simple.buckets(3)));
		assertEquals("[[10, 70, 20, 90], [80, 5, 0, 0]]", Arrays.deepToString(simple.buckets(4)));
		assertEquals("[[10, 70, 20, 90, 80], [5, 0, 0, 0, 0]]", Arrays.deepToString(simple.buckets(5)));
		
		assertNull(nullHistory.buckets(0));
		assertNull(nullHistory.buckets(1));
		
		assertNull(emptyHistory.buckets(0));
		assertNull(emptyHistory.buckets(1));
		
		assertEquals("[[10, 10, 20, 10, 20, 30, 10], [20, 30, 40, 5, 40, 50, 60], [80, 70, 70, 80, 90, 100, 110], [120, 130, 140, 150, 160, 170, 180]]", Arrays.deepToString(longHistory.buckets(7)));
		assertEquals("[[10, 10, 20, 10, 20, 30, 10, 20, 30, 40], [5, 40, 50, 60, 80, 70, 70, 80, 90, 100], [110, 120, 130, 140, 150, 160, 170, 180, 0, 0]]", Arrays.deepToString(longHistory.buckets(10)));		
		assertEquals("[[10, 10, 20, 10, 20, 30, 10, 20, 30, 40, 5, 40, 50, 60, 80, 70, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]", Arrays.deepToString(longHistory.buckets(40)));		

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(11) @Graded(description="getIndicesViewCountAtleast", marks=4)
	public void testGetIndicesViewCountAtleast() {
		assertNotNull(simple.getIndicesViewCountAtleast(70));
		assertEquals("[1, 3, 4]", Arrays.toString(simple.getIndicesViewCountAtleast(70)));
		assertEquals("[1, 2, 3, 4]", Arrays.toString(simple.getIndicesViewCountAtleast(20)));
		assertNull(nullHistory.getIndicesViewCountAtleast(0));
		assertNull(emptyHistory.getIndicesViewCountAtleast(0));
		assertNotNull(longHistory.getIndicesViewCountAtleast(10));
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]", Arrays.toString(longHistory.getIndicesViewCountAtleast(10)));
		assertEquals("[]", Arrays.toString(longHistory.getIndicesViewCountAtleast(190)));
		assertEquals("[19, 20, 21, 22, 23, 24, 25, 26, 27]", Arrays.toString(longHistory.getIndicesViewCountAtleast(100)));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(12) @Graded(description="slice", marks=4)
	public void testSlice() {
		VideoAnalytics slice1 = simple.slice(1, 3);
		assertNotNull(slice1);
		assertEquals(simple.title, slice1.title);
		assertNotNull(slice1.views);
		assertEquals("[70, 20, 90]", Arrays.toString(slice1.views));
		
		slice1 = nullHistory.slice(0, 0);
		assertNotNull(slice1);
		assertEquals("Installing Eclipse", slice1.title);
		assertNull(slice1.views);
		
		slice1 = simple.slice(1, 3);
		assertNotNull(slice1);
		assertEquals(simple.title, slice1.title);
		assertNotNull(slice1.views);
		assertEquals("[70, 20, 90]", Arrays.toString(slice1.views));
		
		slice1 = simple.slice(-1, 3); //invalid beginIndex
		assertEquals(simple.title, slice1.title);
		assertNull(slice1.views);

		slice1 = simple.slice(1, 3);
		assertEquals(simple.title, slice1.title);
		assertNotNull(slice1.views);
		assertEquals("[70, 20, 90]", Arrays.toString(slice1.views));
		
		slice1 = simple.slice(0, simple.views.length); //invalid endIndex
		assertEquals(simple.title, slice1.title);
		assertNull(slice1.views);

		slice1 = simple.slice(1, 3);
		assertEquals(simple.title, slice1.title);
		assertNotNull(slice1.views);
		assertEquals("[70, 20, 90]", Arrays.toString(slice1.views));
		
		slice1 = simple.slice(2, 1); //beginIndex > endIndex
		assertEquals(simple.title, slice1.title);
		assertNull(slice1.views);
		
		slice1 = simple.slice(0, simple.views.length-1);
		assertEquals(simple.title, slice1.title);
		assertNotNull(slice1.views);
		assertEquals("[10, 70, 20, 90, 80, 5]", Arrays.toString(slice1.views));
		assertNotEquals(simple.views, slice1.views);

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
		System.out.println(result+"\nIndicative Total for VideoAnalytics: "+score+" out of 76");
		if(score == 76) {
			System.out.println("VideoAnalytics - A job well done!");
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