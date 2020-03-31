/**
 * This Class demonstrates the reason and the use of threshold-based double
 * comparison.
 * 
 * @author Jp
 */

public class DoubleComparison {
    /**
     * THRESHOLD - Used for comparison of double values
     * 
     * Can be public or private, does not matter. 
     * Should be static (Constants are usually static). 
     * The name does not matter: 'THRESHOLD' or 'EPSILON' is
     * commonly used for double comparison.
     * Usually a very small number.
     */
    private static final double THRESHOLD = 0.000000000001;

    public static void main(String[] args) {
    	// Reason for using threshold-based comparison
        System.out.println("Demonstration of comparison using ==");
        
        // Let's say I have a num that is equal to 15.0
        double num = 15.0;
        
        // 15.0 / 11.0 should mathematically yield 1.3636... with 3636 repeating infinitely
        // However, in Java, double variable can only hold up to certain number of digits (15 ~ 16)
        // and any digits after are rounded according to a special rule
        double intermediate = num / 11.0;
        System.out.println(num + " / " + 11.0 + " = " + intermediate);	// 1.3636363636363635
        // 1.3636363636363636... is rounded to 1.3636363636363635

        // intermediate * 11.0 becomes 1.3636363636363635 * 3.0 which yields 14.999999999999998
        double result = intermediate * 11.0;
        System.out.println(intermediate + " * " + 11.0 + " = " + result);	// 14.999999999999998

        // Therefore, the following expression would evaluate to false
        boolean returnsFalse = 15.0 == result;
        System.out.println(15.0 + " == " + result + " evaluates to " + returnsFalse);
        
        // The following is an equivalent expression
        returnsFalse = 15.0 == 15.0 / 11.0 * 11.0;
        System.out.println(15.0 + " == " + 15.0 / 11.0 * 11.0 + " evaluates to " + returnsFalse);
        
        // 15.0 / 11.0 * 11.0 SHOULD return 15.0 because 11.0s cancel out
        // However, minor rounding that happen due to double's limitation
        // causes the the final answer to be off by very small number.
        // This is why Threshold-based Comparison is recommended for double
        
        System.out.println();
        
        // Use of threshold-based comparison
        System.out.println("Demonstration of threshold-based comparison");
        
        // Threshold-based comparison syntax:
        // Math.abs(expected - actual) < THRESHOLD
        // expected represents a value that you expect
        // actual represents a value you get after operations or method call
        // * The order does not matter because you are taking the absolute value of the difference
        // You should use < instead of <=
        System.out.println("result == " + result); // 14.999999999999998
        boolean returnsTrue = Math.abs(15.0 - result) < THRESHOLD;
        System.out.println("Math.abs(15.0 - result) < THRESHOLD evaluates to " + returnsTrue);
        
        // If you want to compare the actual value to 0
        result = result - 15.0; 
        System.out.println("result == " + result); // -1.7763568394002505E-15 (very small number)
        returnsTrue = Math.abs(result) < THRESHOLD;
        System.out.println("Math.abs(result) < THRESHOLD evaulates to " + returnsTrue);
    }
}