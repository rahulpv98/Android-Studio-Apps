import java.util.Scanner;

public class TestFractions {
    public static void main(String[] args) {
        // Reading a 3*3 Matrix of Fractions using hardcoded values with Scanner class
        Scanner scan = new Scanner("8/3 4/9 5/7 6/3 5/7 6/2 2/3 8/9 5/4");

        //Created a 2D Array of Fractions
        Fraction fractions[][] = new Fraction[3][3];

        //Reading from Scanner, creating a new Fraction out of it, and storing it inside fractions array
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                fractions[i][j] = new Fraction(scan.next());
            }
        }

        //Calculating the value of Determinant, and storing it to a variable
        double ans = computeValue(fractions);

        System.out.println(ans);
        scan.close();
    }

    public static double computeValue(Fraction[][] fractions) {
        double ans = 0.0;
        /* Calculate the value of the Determinant of the matrix (using multiplication of Fractions, after getting the value of each fraction using getValue()) Here and return it to the main function */

        return ans;
    }
}
