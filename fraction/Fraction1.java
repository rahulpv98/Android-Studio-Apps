public class Fraction1 {
    private int numerator;
    private int denominator;

    public Fraction() {
        /* Initialize Numerator and Denominator to 0 */
	this.numerator=0;
	this.denominator=0;
    }

    public Fraction(int n , int d) {
        /* Initialize Numerator to n and Denominator to d */
  	this.numerator=n;
	this.denominator=d;  
    }

    public Fraction(String fraction) {
        /*
            * I'm writing this one for you guys. Example you pass 8/3 to this constructor,
            * the first statement will split the string into two strings and save it as a string array
            * then the next two statements will store into numerator and denominator after parsing the String to integer
        */
        String[] numbers = fraction.split("/");
        this.numerator = Integer.parseInt(numbers[0]);
        this.denominator = Integer.parseInt(numbers[1]);
    }

    public int getNumerator() {
        /* Write this function. It should return the value of the numerator */
        return 0;
   }

    public int getDenominator() {
        /* Write this function. It should return the value of the denominator */
        return 0;
    }

    public void setNumerator() {
        /* Write this function. It should set the value of the numerator */

    }

    public void setDenominator() {
        /* Write this function. It should set the value of the denominator */

    }

    public double getValue() {
        /* Write this function. It should divide the numerator with denominator and return the result */
        double ans = 0.0;
        return ans;
    }
}
