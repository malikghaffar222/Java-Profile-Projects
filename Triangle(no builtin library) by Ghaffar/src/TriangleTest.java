import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TriangleTest {
	Triangle t1, t2, t3, t4;
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Triangle();
		t2 = new Triangle(11,11,13);
		t3 = new Triangle(3,4,5);
		t4 = new Triangle(4,5,6);
	}

	@Test
	void testTriangle() {
		assertEquals(1, t1.e1);
		
		assertEquals(1, t1.e2);
		
		assertEquals(1, t1.e3);
		System.out.println(t1.e1);
	}

	@Test
	void testTriangleIntIntInt() {
		assertEquals(13, t2.e3);
		assertEquals(3, t3.e1);
		assertEquals(5, t4.e2);
	}

	@Test
	void testIsValid() {
		assertTrue(t1.isValid());
		assertTrue(t2.isValid());
		assertTrue(t3.isValid());
		assertTrue(t4.isValid());
		
		Triangle t5 = new Triangle(-10, 10, 10);
		assertFalse(t5.isValid());
		Triangle t6 = new Triangle(11, 10, 110);
		assertFalse(t6.isValid());
		Triangle t7 = new Triangle(3, -3, -11);
		assertFalse(t7.isValid());
	}

	@Test
	void testSortEdge() {
		
		t1.sortEdge();
		t2.sortEdge();
		t3.sortEdge();
		t4.sortEdge();
		assertEquals(1, t1.e1);
		assertEquals(11, t2.e2);
		assertEquals(5, t3.e1);
		assertEquals(6, t4.e1);
	}

	@Test
	void testMax() {
		assertEquals(1, t1.max());
		assertEquals(13, t2.max());
		assertEquals(5, t3.max());
		assertEquals(6, t4.max());
	}

	@Test
	void testMedium() {
		assertEquals(1, t1.medium());
		assertEquals(11, t2.medium());
		assertEquals(4, t3.medium());
		assertEquals(5, t4.medium());
	}

	@Test
	void testMin() {
		assertEquals(1, t1.min());
		assertEquals(11, t2.min());
		assertEquals(3, t3.min());
		assertEquals(4, t4.min());
	}

	@Test
	void testGetPerimeter() {
		assertEquals(3, t1.getPerimeter());
		assertEquals(35, t2.getPerimeter());
		assertEquals(12, t3.getPerimeter());
		assertEquals(15, t4.getPerimeter());
	}

	@Test
	void testIsRightTriangle() {
		assertFalse(t1.isRightTriangle());
		assertFalse(t2.isRightTriangle());
		assertTrue(t3.isRightTriangle());
		assertFalse(t4.isRightTriangle());
		
		
	}

	@Test
	void testIsIsosceles() {
		assertTrue(t1.isIsosceles());
		assertTrue(t2.isIsosceles());
		assertFalse(t3.isIsosceles());
		assertFalse(t4.isIsosceles());
	}

	@Test
	void testIsEquilateral() {
		assertTrue(t1.isEquilateral());
		assertFalse(t2.isEquilateral());
		assertFalse(t3.isEquilateral());
		assertFalse(t4.isEquilateral());
	}

	@Test
	void testIsObtuse() {
		assertFalse(t1.isObtuse());
		assertFalse(t2.isObtuse());
		assertFalse(t3.isObtuse());
		assertFalse(t4.isObtuse());
		
		Triangle t5 = new Triangle(4,5,8);
		assertTrue(t5.isObtuse());
	}

	@Test
	void testIsSimilar() {
		assertFalse(t1.isSimilar(t2));
		assertFalse(t2.isSimilar(t3));
		assertFalse(t3.isSimilar(t4));
		assertFalse(t4.isSimilar(t1));
		
		Triangle t5 = new Triangle(3,3,3);
		assertTrue(t5.isSimilar(t1));
		
		Triangle t6 = new Triangle(22,22,26);
		assertTrue(t6.isSimilar(t2));
		
		Triangle t7 = new Triangle(30,40,50);
		assertTrue(t7.isSimilar(t3));
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, t1.compareTo(t2));
		assertEquals(1, t2.compareTo(t3));
		assertEquals(-1, t3.compareTo(t4));
		assertEquals(1, t4.compareTo(t1));
		
		
		Triangle t5 = new Triangle(10,12,13);
		assertEquals(0, t5.compareTo(t2));
		
		Triangle t6 = new Triangle(4,3,5);
		assertEquals(0, t6.compareTo(t3));
		
		Triangle t7 = new Triangle(3,6,6);
		assertEquals(0, t7.compareTo(t4));
		
		
	}
	
	@Test
	void testIdenticalTo() {
		
		Triangle t5 = new Triangle(10,12,13);
		assertFalse(t1.identicalTo(t5));
		assertFalse(t2.identicalTo(t5));
		assertFalse(t3.identicalTo(t5));
		assertFalse(t4.identicalTo(t5));
		
		Triangle t6 = new Triangle(4,3,5);
		assertTrue(t3.identicalTo(t6));
		
		Triangle t7 = new Triangle(11,11,13);
		assertTrue(t2.identicalTo(t7));
		
		
	}
	
	
	@Test
	void testPoweredPerimeter() {
		
		assertEquals(-1, t1.poweredPerimeter(-11));
		assertEquals(1, t2.poweredPerimeter(0));
		
		assertEquals(12, t3.poweredPerimeter(1));
		assertEquals(50625, t4.poweredPerimeter(4));
		
		
		
	}
	
	
}
