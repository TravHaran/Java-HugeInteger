package hugeInteger;

public class HugeInteger {
	// private variables, for negative sign, and integer array for value
	public boolean isNegative;
	public int val[];

	//////////// Constructors ///////////////

	// Constructor 1: Takes a String input value defining an integer
	public HugeInteger(String val) {

		// If the first character is a negative
		if (val.charAt(0) == '-') {
			val = val.substring(1);

			// While there are leading 0s
			val = stripLeadingZeros(val);

			// set negative as true
			if (val == "0")
				isNegative = false;
			else
				isNegative = true;
			this.val = new int[val.length()];
			// save each digit as an element of an array
			convertToArr(val, this.val);
		}

		// If positive
		else {
			val = stripLeadingZeros(val);
			// Set negative as false
			isNegative = false;
			// Save each digit as an element
			this.val = new int[val.length()];
			convertToArr(val, this.val);
		}
	}

	// Constructor 2: Generates a random integer of size n
	public HugeInteger(int n) {
		// Error catching
		if (n <= 0)
			throw new IllegalArgumentException("n must be larger than 0");

		// Set as positive number
		isNegative = false;

		// Initiate new array length
		val = new int[n];

		// define the range of random numbers
		int max = 9;
		int min = 1;
		int range = max - min + 1;

		// generate random number for each digit
		for (int i = 0; i < n; i++) {
			val[i] = (int) (Math.random() * range) + min;
		}
	}

	//////////// Methods ///////////////

	// Method 1: Adding integers
	public HugeInteger add(HugeInteger h) {

		// initiate variables
		// Initialize HugeInteger to store sum of addition
		HugeInteger sum = new HugeInteger("0");
		int small[], big[];

		// if one element is negative
		if (h.isNegative && !this.isNegative) {
			sum.val = h.val;
			sum.isNegative = false;
			return this.subtract(sum);
		} else if (this.isNegative && !h.isNegative) {
			sum.val = this.val;
			sum.isNegative = false;
			return h.subtract(sum);
		}

		// determine which number is larger/smaller
		if (h.val.length >= this.val.length) {
			big = h.val;
			small = this.val;
		} else {
			small = h.val;
			big = this.val;
		}

		// add numbers
		String result = addition(small, big);

		// save as new HugeInteger
		sum = new HugeInteger(result);

		// if both elements are negative
		if (this.isNegative && h.isNegative) {
			// the addition of two negative numbers will always yield a negative sum
			sum.isNegative = true;
		}

		return sum;

	}

	// Method 2: Subtracting integers
	public HugeInteger subtract(HugeInteger h) {
		// initiate variables
		// Initialize HugeInteger to store result of subtraction
		HugeInteger difference = new HugeInteger("0");
		HugeInteger test1 = new HugeInteger("0");
		HugeInteger test2 = new HugeInteger("0");
		String result = "";
		int num1[], num2[];

		// if one element is negative
		if (h.isNegative && !this.isNegative) {
			difference.val = h.val;
			difference.isNegative = false;
			return this.add(difference);
		} else if (this.isNegative && !h.isNegative) {
			difference.val = h.val;
			difference.isNegative = true;
			return this.add(difference);

		}
		// Handle Subtraction when this # is less than h
		if (this.compareTo(h) == -1) {
			result = subtraction(h.val, this.val);
			difference = new HugeInteger(result);
			difference.isNegative = true;
			return difference;

		}

		// Handle subtraction when this is greater than h, and both are negative
		if (this.compareTo(h) == 1 && this.isNegative && h.isNegative) {
			test1.val = h.val;
			test2.val = this.val;
			test1.isNegative = false;
			test2.isNegative = false;

			difference = test1.subtract(test2);
			return difference;

		}

		num1 = this.val;
		num2 = h.val;
		// minus numbers
		result = subtraction(num1, num2);

		// save result
		difference = new HugeInteger(result);

		// if both elements are negative
		if (this.isNegative && h.isNegative) {
			difference.isNegative = !difference.isNegative;
		}

		return difference;
	}

	// Method 3: Multiply two integers
	public HugeInteger multiply(HugeInteger h) {
		// Initialize HugeInteger to store product of multiplication
		HugeInteger product = new HugeInteger("0");
		String result = "";
		int num1[], num2[];

		num1 = this.val;
		num2 = h.val;

		// If either element is zero, the product is zero
		if (num1[0] == '0' || num2[0] == '0') {
			return product;
		}

		// multiply numbers
		result = multiplication(num1, num2);

		product = new HugeInteger(result);
		// If one element is negative
		if (h.isNegative ^ this.isNegative) {
			product.isNegative = true;
		}
		// If both elements are negative
		if (h.isNegative && this.isNegative) {
			product.isNegative = false;
		}

		return product;
	}

	// Method 4: Compares this to h, if this is bigger returns 1, otherwise -1,
	// equal = 0
	public int compareTo(HugeInteger h) {

		// Placeholder for easier understanding
		int hbigger = -1, hsmaller = 1;

		// sign checking
		if (h.isNegative && !this.isNegative)
			return hsmaller;
		else if (!h.isNegative && this.isNegative)
			return hbigger;
		else if (h.isNegative && this.isNegative) {
			hbigger = 1;
			hsmaller = -1;
		}

		// length checking
		if (h.val.length > this.val.length)
			return hbigger;
		else if (this.val.length > h.val.length)
			return hsmaller;

		// value checking
		else {
			for (int i = h.val.length - 1; i >= 0; i--) {
				if (h.val[i] > this.val[i])
					return hbigger;
				else if (h.val[i] < this.val[i])
					return hsmaller;
			}
			return 0;
		}

	}

	// Method 5: Returns the String representation of HugeInteger
	public String toString() {

		String val = "";
		for (int i = 0; i < this.val.length; i++) {
			val = this.val[i] + val;
		}

		if (this.isNegative) {
			val = "-" + val;
		}
		if (val.charAt(0) == '-' && val.charAt(1) == '0') {
			val = "0";
		}

		return val;
	}

	//////////// Sub-Functions ///////////////

	// Basic Addition function
	public static String addition(int[] small, int[] big) {
		int carryOver = 0, sumInt;
		String sumStr = ""; // Initialize empty string to store sum

		// add each corresponding digit and save carry to perform basic addition
		for (int i = 0; i < big.length; i++) {
			// add the carried value to the larger number when the index is about to surpass
			// length of small number
			if (i + 1 > small.length)
				sumInt = big[i] + carryOver;
			else
				sumInt = big[i] + small[i] + carryOver;
			sumStr = (sumInt % 10) + sumStr;
			carryOver = sumInt / 10;
		}

		// if there is a carry left at the end
		if (carryOver != 0) {
			sumStr = (carryOver) + sumStr;
		}
		return sumStr;
	}

	// Subtraction function
	public static String subtraction(int[] num1, int[] num2) {
		// Store result in empty string
		String diffStr = "";
		// Convert integer arrays to strings
		String str1 = reverseString(arrayToString(num1)), str2 = reverseString(arrayToString(num2));

		// make sure str1 is not smaller
		if (isSmaller(str1, str2)) {
			String t = str1;
			str1 = str2;
			str2 = t;
		}

		// determine length of both integers
		int n1 = str1.length(), n2 = str2.length(), diff = n1 - n2;

		// Initialize borrow to be zero
		int borrow = 0;

		// Traverse from end of both strings till small string length and subtract digit
		// of str1 and str2

		for (int i = n2 - 1; i >= 0; i--) {
			// Implement grade school mathematics algorithm to compute the difference of
			// each digit
			int sub = (((int) str1.charAt(i + diff) - (int) '0') - ((int) str2.charAt(i) - (int) '0') - borrow);
			if (sub < 0) {
				sub = sub + 10;
				borrow = 1;
			} else
				borrow = 0;

			diffStr += String.valueOf(sub);
		}

		// Subtract remaining digits of str1[]
		for (int i = n1 - n2 - 1; i >= 0; i--) {
			if (str1.charAt(i) == '0' && borrow > 0) {
				diffStr += "9";
				continue;
			}

			int sub = (((int) str1.charAt(i) - (int) '0') - borrow);

			if (i > 0 || sub > 0) {
				// remove preceding 0's
				diffStr += String.valueOf(sub);
			}
			borrow = 0;

		}
		// reverse result
		String result = reverseString(diffStr);

		return result;
	}

	// Multiplication function
	public static String multiplication(int[] num1, int[] num2) {
		// Store result in empty string
		String prodStr = "";
		// Convert integer arrays to strings
		String str1 = (arrayToString(num1)), str2 = (arrayToString(num2));

		int[] m = new int[str1.length() + str2.length()];

		// Iterate from right to left in num1
		for (int i = 0; i < str1.length(); i++) {
			// Iterate from right to left in num2
			for (int j = 0; j < str2.length(); j++) {
				m[i + j] = m[i + j] + (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
			}
		}
		// Multiply with current digit of first number & add result to the previously
		// stored product at the current position
		for (int i = 0; i < m.length; i++) {
			int digit = m[i] % 10;
			int carry = m[i] / 10;
			if (i + 1 < m.length) {
				m[i + 1] = m[i + 1] + carry;
			}
			prodStr = digit + prodStr;
		}

		return (prodStr);
	}

	// Strip Character function
	public static String stripLeadingZeros(String val) {
		// while a zero exists in the front of the string, remove it.
		while (val.length() > 1 && val.charAt(0) == '0') {
			val = val.substring(1);
			if (val.length() == 0)
				val = "0";
		}
		return val;
	}

	// Convert String to Integer Array
	public static void convertToArr(String val, int[] valArr) {
		// save each digit as an element of an array
		for (int i = 0; i < val.length(); i++) {
			// Error catching
			if (!Character.isDigit(val.charAt(val.length() - i - 1)))
				throw new IllegalArgumentException("Only accepts numeric values");
			valArr[i] = Character.getNumericValue(val.charAt(val.length() - i - 1));
		}
	}

	// Check if two strings are smaller
	public static boolean isSmaller(String str1, String str2) {
		// calculate the lengths of both strings
		int n1 = str1.length(), n2 = str2.length();

		if (n1 < n2)
			return true;
		if (n1 > n2)
			return false;

		for (int i = 0; i < n1; i++) {
			if (str1.charAt(i) < str2.charAt(i))
				return true;
			else if (str1.charAt(i) > str2.charAt(i))
				return false;
		}
		return false;
	}

	// Reverse a string
	public static String reverseString(String str) {
		String revStr = "";
		revStr = new StringBuilder(str).reverse().toString();
		return revStr;
	}

	// Convert integer array to string
	public static String arrayToString(int[] array) {
		StringBuilder builder = new StringBuilder();
		for (int i : array) {
			builder.append(i);
		}
		return builder.toString();
	}

}
