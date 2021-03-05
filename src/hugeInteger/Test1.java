package hugeInteger;

public class Test1{
	public static void main(String args[]) {
		//Initialize variables of class HugeInteger
		HugeInteger x1;
		HugeInteger x2;
		HugeInteger x3;
		HugeInteger x4;
		HugeInteger x5;
		HugeInteger x6;
		
		//Constructor 1 test cases (String)
		
		
		//a) Valid inputs
		
		try {
			x1 = new HugeInteger("452358762438957624398756239875623978");
			x2 = new HugeInteger("-452358762438957624398756239875623978");
			x3 = new HugeInteger("000000000452358762438957624398756239875623978");
			x4 = new HugeInteger("-000000000452358762438957624398756239875623978");
			x5 = new HugeInteger("-0");
			x6 = new HugeInteger("0");
			System.out.println(x1.toString() + "\n");
			System.out.println(x2.toString() + "\n");
			System.out.println(x3.toString() + "\n");
			System.out.println(x4.toString() + "\n");
			System.out.println(x5.toString() + "\n");
			System.out.println(x6.toString() + "\n");
			
		}
		catch(Exception e) {
			System.out.println("S#: String  constructor throws exception for valid input\n");
		}
		
		
		//b) Invalid inputs
		try {
			x1 = new HugeInteger("342905872349058-48359725290");
		}
		catch(Exception e) {
			System.out.println("S1: Invalid String in the middle exception caught\n");
		}
		
		try {
			x1 = new HugeInteger("34290587234905848359725290!");
		}
		catch(Exception e) {
			System.out.println("S2: Invalid string at the end exception caught\n");
		}
		
		try {
			x1 = new HugeInteger("~342905872349058-48359725290");
		}
		catch(Exception e) {
			System.out.println("S3: Invalid string at the front exception caught\n");
		}
		
		try {
			x1 = new HugeInteger("000*34290587234905848359725290");
		}
		catch(Exception e) {
			System.out.println("S4: Invalid string with leading zeros exception caught\n");
		}
		
		try {
			x1 = new HugeInteger("-+342905872349058-48359725290");
		}
		catch(Exception e) {
			System.out.println("S5: Invalid negative string exception caught\n");
		}
		
		try {
			x1 = new HugeInteger("");
		}
		catch(Exception e) {
			System.out.println("S6: Invalid emtpy string exception caught\n");
		}
		
		
		//Constructor 2 test cases (Random number)
		
		//c) Valid inputs
		try {
			x1 = new HugeInteger(7);
			x2 = new HugeInteger(70);
		}
		catch(Exception e) {
			System.out.println("R#: Random constructor throws exception for valid input\\n");
		}
		
		//d) Invalid inputs
		try {
			x1 = new HugeInteger(0);
		}
		catch(Exception e) {
			System.out.println("R1: Invalid size 0 exception caught\n");
		}
		
		try {
			x2 = new HugeInteger(-100);
		}
		catch(Exception e) {
			System.out.println("R2: Invalid size negative exception caught\n");
		}
		
		
		//Method 1 test cases (positive integer addition)
		
		//e) Valid inputs
		try {
			x1 = new HugeInteger("452358762438957624398756239875623978");
            x2 = new HugeInteger("452358762438957624398756239875623978");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
		}
		catch(Exception e){
            System.out.println("A#1: Exception generated by positive String Addition class for valid test cases\n");
        }
		
		try {
			x1 = new HugeInteger(21);
            x2 = new HugeInteger(12);
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
		}
		catch(Exception e){
            System.out.println("A#2: Exception generated by positive Random Number Addition class for valid test cases\n");
        }
		
		//f) Invalid inputs
		try {
			x1 = new HugeInteger("$%^452358762438957624398756239875623978");
            x2 = new HugeInteger("45235876243895762439^&*(8756239875623978");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
		}
		catch(Exception e){
            System.out.println("A1: Invalid string addition exception caught\n");
        }
		
		//Method 2 test cases (positive integer subtraction)
		//Valid inputs
		try {
			x1 = new HugeInteger(21);
            x2 = new HugeInteger(12);
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
		}
		catch(Exception e){
            System.out.println("A#2: Exception generated by positive Random Number Subtraction class for valid test cases\n");
        }
		
		//Addition with negative numbers
        System.out.println("Addition");
        try{
            x1 = new HugeInteger("-41227118523886958320663418902059206980124172710684");
            x2 = new HugeInteger("-61909791269961487612522934635131397205598718168957");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("-68851396737734913351388212636496036858104587877124");
            x2 = new HugeInteger("41227118523886958320663418902059206");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877124");
            x2 = new HugeInteger("-76245861525986285249450820492919113334865206726001");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error during addition");
        }
        
        // Subtraction
        System.out.println("Subtraction");
        try{
            x1 = new HugeInteger("-412271185238869583206634189084");
            x2 = new HugeInteger("-6190979126996148761252293435131397205598718168957");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("-7851396737734913351388212636496036858104587877124");
            x2 = new HugeInteger("19851227118523886958320663418902059206");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877124");
            x2 = new HugeInteger("-76245861525986285249450820492919113334865206726001");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877123467459628736598324");
            x2 = new HugeInteger("762458615259862852494509113334865206726001");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error during subtraction");
        }
        
        // Multiplication
        System.out.println("Multiplication");
        try{
            x1 = new HugeInteger("-412271185238869583206634189084");
            x2 = new HugeInteger("-6190979126996148761252293435131397205598718168957");
            x3 = x1.multiply(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("-7851396737734913351388212636496036858104587877124");
            x2 = new HugeInteger("19851227118523886958320663418902059206");
            x3 = x1.multiply(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877124");
            x2 = new HugeInteger("-76245861525986285249450820492919113334865206726001");
            x3 = x1.multiply(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("68851310458787712411111112321");
            x2 = new HugeInteger("762458615259862852494508204113334865206726001");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error during multiplication");
        }
        System.out.println("Comparison");
        try{
            x1 = new HugeInteger("-999");
            x2 = new HugeInteger("-2999");
            int x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("999");
            x2 = new HugeInteger("999");
            x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("1000");
            x2 = new HugeInteger("999");
            x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("999");
            x2 = new HugeInteger("1000");
            x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();

        }
        catch(Exception e){
            System.out.println("Error during multiplication");
        }

	}
}