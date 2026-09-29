package dsa1;

public class TrailingZeros {
    public static void main(String[] args) {
        int fact = 125;
        int numOfFactorial = numOfFactorials(fact);
        System.out.println("Number of zeros in factorial: " + fact + ", is: " + numOfFactorial);
    }

    public static int numOfFactorials(int num) {
        int numOfZeros = 0;
        int currPowOfFive = 5;

        while(num >= currPowOfFive) {
            numOfZeros += num/currPowOfFive;
            currPowOfFive = currPowOfFive*5;

        }
        return numOfZeros;
    }
}


