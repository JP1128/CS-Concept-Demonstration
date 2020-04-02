/**
 * This Class demonstrates how the compareTo(String) method of the String class
 * works.
 * 
 * I'm referring to how the method compareTo(String) is actually implemented by
 * String class. The source code for the String class can be found at
 * http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/lang/String.java
 * 
 * @author Jp
 */

public class CompareTo {
	// Go to line 78 to see the internal implementation of compareTo(String) method!
	
	public static void main(String[] args) {
		/*
		 * Different first character +++++++++++
		 */
		System.out.println("Different first character +++++++++++");
		String str1 = "Bay";
		String str2 = "Airplane";

		// compareTo(str1, str2) returns 1 because B (66) - A (65) = 1
		System.out.println("\"" + str1 + "\".compareTo(\"" + str2 + "\") == " + compareTo(str1, str2));
		// compareTo(str2, str1) returns -1 because A - B = -1
		System.out.println("\"" + str2 + "\".compareTo(\"" + str1 + "\") == " + compareTo(str2, str1));

		/*
		 * Different middle character +++++++++++
		 */
		System.out.println("\nDifferent middle character +++++++++++");
		str1 = "beedle";
		str2 = "beetle";

		// compareTo(str1, str2) returns -16 because d (100) - t (116) = -16
		System.out.println("\"" + str1 + "\".compareTo(\"" + str2 + "\") == " + compareTo(str1, str2));
		// compareTo(str2, str1) returns 16 because t - d = 16
		System.out.println("\"" + str2 + "\".compareTo(\"" + str1 + "\") == " + compareTo(str2, str1));

		/*
		 * Same characters different length +++++++++++
		 */
		System.out.println("\nSame characters different length +++++++++++");
		str1 = "can";
		str2 = "candle";

		// compareTo(str1, str2) returns -3 because str1.length (6) - str2.length (3) =
		// -3
		System.out.println("\"" + str1 + "\".compareTo(\"" + str2 + "\") == " + compareTo(str1, str2));
		// compareTo(str2, str1) returns 3 because str2.length - str1.length = 3
		System.out.println("\"" + str2 + "\".compareTo(\"" + str1 + "\") == " + compareTo(str2, str1));

		/*
		 * Different characters (with digits) +++++++++++
		 */
		System.out.println("\nDifferent characters (with digits) +++++++++++");
		str1 = "123Bird";
		str2 = "Bird";

		// compareTo(str1, str2) returns -17 because '1' (49*) - B (66) = -17
		// * '1' in ASCII corresponds to 49, not 1
		System.out.println("\"" + str1 + "\".compareTo(\"" + str2 + "\") == " + compareTo(str1, str2));
		// compareTo(str2, str1) returns 17 because B - '1' = 17
		System.out.println("\"" + str2 + "\".compareTo(\"" + str1 + "\") == " + compareTo(str2, str1));

		/*
		 * EXPERIMENT! Try to experiment with different String! +++++++++++
		 */
		System.out.println("\nEXPERIMENT +++++++++++");
		str1 = "";
		str2 = "";

		System.out.println(str1.compareTo(str2));
		System.out.println(str2.compareTo(str1));
	}

	// str1.compareTo(str2)
	public static int compareTo(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		// the smallest from len1 and len2
		// the length of the shortest String from str1 and str2
		int lim = Math.min(len1, len2);

		// char array - stores individual characters of the two Strings
		char[] v1 = str1.toCharArray();
		char[] v2 = str2.toCharArray();

		// index
		int k = 0;

		// while k is less than the length of the shortest String
		while (k < lim) {
			// char at the index k for str1 and str2, respectively
			char c1 = v1[k];
			char c2 = v2[k];

			// if the two chars at index k are different, then
			// return the difference between the int value
			// of char of str1 and int value of char of str2
			if (c1 != c2) {
				return c1 - c2;
			}

			// if the two chars at index k are equal, then
			// continue the loop after incrementing the index
			k++;
		}
		// after looping until the program compared the indices
		// up to the length of the shortest String, if no difference
		// was found, then return the difference between the length
		// of str1 and the length of str2
		return len1 - len2;
	}
}
