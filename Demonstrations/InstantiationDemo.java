/**
 * These classes demonstrate the difference between variable declaration and
 * object instantiation. Also, they show how one can obtain an object without
 * using the new operator.
 * 
 * These classes also show how to properly set up getters and setters for
 * instance variables of the classes.
 * 
 * @author Jp
 */

public class InstantiationDemo {
	public static void main(String[] args) {
		// Variable declaration
		// Statement below declares a variable of type Chocolate to store reference to
		// object/instance of type Chocolate
		Chocolate chocolate;

		// Object instantiation and initialization
		// Statement below (1) instantiates an instance of type Chocolate, (2) returns
		// the memory address of the object that was created, and (3) initializes the
		// chocolate variable with the returned memory address
		chocolate = new Chocolate();

		// Because the variable chocolate is of type Chocolate, you can call the methods
		// declared in the class Chocolate (line 58)
		chocolate.setBrand("Kitkat");
		System.out.println(chocolate.getBrand());

		// Ways you can obtain an object without using the new operator
		// When I instantiate an instance of BoxOfChocolate class, the class creates 6
		// instances of Chocolate and place them in an array of length 6
		// Check the BoxOfChocolate class (line 75)
		BoxOfChocolate boxOfChocolate = new BoxOfChocolate();

		// Carefully examine the statement below
		// Although I did not explicitly create an instance of Chocolate,
		// I can obtain the chocolate from the BoxOfChocolate, which internally
		// created Chocolate objects and placed them in its instance variable
		Chocolate hersheys = boxOfChocolate.getChocolateAt(0);

		// Since variable hersheys is of type Chocolate and contains object of
		// type Chocolate, which I obtained from boxOfChocolate, I can call methods
		// using the variable
		System.out.println(hersheys.getBrand());

		// You do not need to declare a variable to call the method
		for (int i = 1; i < 6; i++) {
			System.out.println(boxOfChocolate.getChocolateAt(i).getBrand());
		}
	}
}

/*
 * Chocolate class Object/Instance of this class represents a chocolate with
 * information about its brand represented by String
 */
class Chocolate {
	private String brand;

	// Setter for brand instance variable
	public void setBrand(String brand) {
		this.brand = brand;
	}

	// Getter for brand instance variable
	public String getBrand() {
		return brand;
	}
}

/*
 * BoxOfChocolate class Object/Instance of this class represents
 */
class BoxOfChocolate {
	private Chocolate[] contents;

	// This is the constructor
	// It is executed when the object of this class is instantiated
	// This constructor instantiates 6 Chocolate objects with different
	// brand and place them in an array
	BoxOfChocolate() {
		contents = new Chocolate[6];
		contents[0] = makeChocolate("Hershey's");
		contents[1] = makeChocolate("Ferrero Rocher");
		contents[2] = makeChocolate("Lindt & Sprungli");
		contents[3] = makeChocolate("Ghirardelli");
		contents[4] = makeChocolate("Guylian");
		contents[5] = makeChocolate("Snickers");
	}

	// Returns the chocolate at the specified index in the contents
	public Chocolate getChocolateAt(int index) {
		if (index < 0 || index > 5) {
			System.out.println("Index cannot be less than 0 or greater than 5");
		}
		return contents[index];
	}

	// Instantiates Chocolate object with the specified brand
	public static Chocolate makeChocolate(String brand) {
		Chocolate chocolate = new Chocolate();
		chocolate.setBrand(brand);
		return chocolate;
	}
}
