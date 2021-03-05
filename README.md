# Java-HugeInteger
This was for my Data Structures and Algorithms Lab.
##Description: 
The range of integers that can be represented in Java using a primitive data type is only from −263 to 263 − 1. What if we need to manipulate integer values beyond this range?
In this assignment you will write a HugeInteger class which is able to represent arbitrar- ily large integer numbers. This class must implement arithmetic operations on integers such as addition, subtraction, multiplication and comparison. You have to implement this class without using Java predefined classes, unless specified otherwise.
Additionally, you have to measure experimentally the running times of the operations implemented in your HugeInteger class and compare them with the measured running times of the corresponding operations provided by java.math.BigInteger class.
##Specifications:
The class HugeInteger must contain at least the following methods:
1) public HugeInteger add(HugeInteger h): Returns a new HugeInteger repre- senting the sum of this HugeInteger and h.
2) public HugeInteger subtract(HugeInteger h): Returns a new HugeInteger representing the difference between this HugeInteger and h.
3) public HugeInteger multiply(HugeInteger h): Returns a new HugeInteger representing the product between this HugeInteger and h.
4) public int compareTo(HugeInteger h): Returns -1 if this HugeInteger is less than h, 1 if this HugeInteger is larger than h, and 0 if this HugeInteger is equal to h.
5) public String toString(): Returns a string representing the sequence of digits corresponding to the decimal representation of this HugeInteger.
The class HugeInteger must contain at least the following constructors:
1) public HugeInteger(String val)createsaHugeIntegerfromthedecimalString representation val. The string contains an optional minus sign at the beginning followed by one or more decimal digits. No other characters are allowed in the string.
2) public HugeInteger(int n) creates a random HugeInteger of n digits, the first digit being different from 0; n must be larger or equal to 1.
Each constructor must throw an exception if the argument passed to the constructor does not comply to the specifications. In your solution, you may use Java API methods for string manipulation and for pseudo-random number generation.
