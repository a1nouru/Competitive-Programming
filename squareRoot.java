/* The first sqrt number should be the input number / 2. 
   Using the equation, we can come up with a Java Square Root method by ourselves.
*/


public static double sqrt(int number) {
	double t;
 
	double squareRoot = number / 2;
 
	do {
		t = squareRoot;
		squareRoot = (t + (number / t)) / 2;
	} while ((t - squareRoot) != 0);
 
	return squareRoot;
}
