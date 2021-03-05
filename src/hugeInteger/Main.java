package hugeInteger;

public class Main {
	public static void main(String[] args) {
		HugeInteger x1;
		HugeInteger x2;
		HugeInteger x3;

		
		//Constructor 1 test cases (String)
		
		
		//a) Valid inputs
		

		x1 = new HugeInteger("5");
		x2 = new HugeInteger("-5");
		x3 = x1.add(x2);
		System.out.println(x1.toString() + "\n");
		System.out.println(x2.toString() + "\n");
		System.out.println("Sum: " + x3.toString() + "\n");


		x1 = new HugeInteger("-1");
		x2 = new HugeInteger("-99");
		x3 = x1.subtract(x2);
		System.out.println(x1.toString() + "\n");
		System.out.println(x2.toString() + "\n");
		System.out.println("Difference: " + x3.toString() + "\n");
		
		x1 = new HugeInteger("321");
		x2 = new HugeInteger("123");
		x3 = x1.multiply(x2);
		System.out.println(x1.toString() + "\n");
		System.out.println(x2.toString() + "\n");
		System.out.println("Product: " + x3.toString() + "\n");
		
	}
	
}