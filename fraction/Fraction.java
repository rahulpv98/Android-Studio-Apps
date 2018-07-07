public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
      numerator=0;
      denominator=0; 
    }

    public Fraction(int n , int d) {
      this.numerator=n;
      this.denominator=d;  
    }

    public Fraction(String fraction) {
      
        String[] numbers = fraction.split("/");
        this.numerator = Integer.parseInt(numbers[0]);
        this.denominator = Integer.parseInt(numbers[1]);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

   
    public float getValue() {
		float ans=0;      
         ans = (float)getNumerator()/getDenominator();
        
        return ans;
    }
}
