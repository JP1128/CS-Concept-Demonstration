/**
 * This Class demonstrates purpose of unit testing and explains how to properly
 * unit test.
 * 
 * To demonstrate unit testing, I will be using the class that I create called
 * TestObject and test the methods in that class.
 * 
 * @author Jp
 */

public class UnitTesting {
	private static final double THRESHOLD = 0.000000000001;

	public static void main(String[] args) {
		TestObject tObj1 = new TestObject();
		TestObject tObj2 = new TestObject();

		// Unit Test for: setS(String) and getS()
		System.out.println("Test: setS(String) & getS()");
		// if the setS(String) and getS() are implemented correctly, then
		// the following tests should be passed
		tObj1.setS("Hello ");
		tObj2.setS("World");

		// tObj1.getS() should return "Hello "
		boolean passed = tObj1.getS().equals("Hello "); // This expression evaluate to true
		if (passed) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED"); // Not printed
		}

		// tObj2.getS() should return "World"
		passed = tObj2.getS().contentEquals("World"); // This expression evaluate to true
		if (passed) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED"); // Not printed
		}

		System.out.println();
		
		// Unit Test for: setD(double) and getD()
		System.out.println("Test: setD(double) & getD()");

		tObj1.setD(3.14);
		tObj2.setD(2.72);

		// You do not need to declare a separate boolean
		// For a guide on double comparison, check DoubleComparison class
		// tObj1.getD() should return 3.14
		if (Math.abs(3.14 - tObj1.getD()) < THRESHOLD) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED"); // Not printed
		}

		System.out.println();
		
		// Unit Test for: setI(int) and getI()
		System.out.println("Test: setI(int) & getI()");

		tObj1.setI(9);
		tObj2.setI(2);

		// tObj2.getI() should return 2
		if (tObj2.getI() == 2) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED"); // Not printed
		}

		System.out.println();

		// Unit Test for: equalI(TestObject)
		// equalI is correctly implemented and it returns true if and only if the i of
		// the calling object is equal to the i of the object passed in as argument
		System.out.println("Test: equalI(TestObject)");

		System.out.println("i value of tObj1: " + tObj1.getI());
		System.out.println("i value of tObj2: " + tObj2.getI());

		// tObj1.equalI(tObj2) should return false
		if (!tObj1.equalI(tObj2)) { // equivalent to tObj1.equalI(tObj2) == false
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED"); // Not printed
		}

		tObj1.setI(1);
		tObj2.setI(1);
		
		System.out.println("i value of tObj1: " + tObj1.getI());
		System.out.println("i value of tObj2: " + tObj2.getI());

		// tObj1.equalI(tObj2) should return true
		if (tObj1.equalI(tObj2)) { // equivalent to tObj1.equalI(tObj2) == true
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED"); // Not printed
		}
		
		System.out.println();
		
		// Unit Test for: multiplyI(TestObject)
		// multiplyI is incorrectly implemented (refer to the method at line 148)
		System.out.println("Test: multiplyI(TestObject)");
		
		tObj1.setI(2);
		tObj2.setI(3);
		
		System.out.println("i value of tObj1: " + tObj1.getI());
		System.out.println("i value of tObj2: " + tObj2.getI());

		// It's often helpful to print the values to help you find out what the error might be
		// If multiplyI is correctly implemented, then tObj1.multiplyI(tObj2) should return 6
		if (tObj1.multiplyI(tObj2) == 6) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
		}
		System.out.println("Expected: " + 6);
		System.out.println("Returned: " + tObj1.multiplyI(tObj2));
		
		// TRY TO FIX THE multiplyI(TestObject) METHOD SO THAT IT PASS THE ABOVE TEST!!
	}
}

class TestObject {
	private String s;
	private double d;
	private int i;

	/**
	 * Returns true if this object's i is equal to the i of the TestObject passed as
	 * the argument
	 */
	public boolean equalI(TestObject obj) {
		return i == obj.i;
	}

	/**
	 * SHOULD multiply the i of this current object with the i of the TestObject
	 * passed as the argument and returns the result
	 * 
	 * The implementation is purposely incorrect
	 */
	public int multiplyI(TestObject obj) {
		return i * i;
	}

	// Setters and Getters
	public void setS(String s) { this.s = s; }
	public String getS() { return s; }

	public void setD(double d) { this.d = d; }
	public double getD() { return d; }

	public void setI(int i) { this.i = i; }
	public int getI() {	return i; }
}