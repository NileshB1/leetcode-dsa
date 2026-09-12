package dsa1;

public class a_DP_FibonnaciNumber {
    public static void main(String[] args) {
        int num = 7;
        int fibNum = fibbonacci(num);
        System.out.println("Fibbonaci number at index: " + num + ", is: "+ fibNum);
    }

    public static int fibbonacci(int num) {
        int first = 0, second = 1, result = 0;
        for(int i=2; i<=num; i++) {
            if(num <=1) {
                return num;
            }
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}