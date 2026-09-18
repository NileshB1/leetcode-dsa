package dsa1;

public class b_DP_ClimbingStairs {
    public static void main(String[] args) {
        int numOfStairsBottomup = numberOfStepsBottomup(5);
        System.out.println("DP bottom up approach, Number of stairs are: " + numOfStairsBottomup);

        int numOfStairsFib = numberOfStepsFibonacci(5);
        System.out.println("Fibonacci approach, Number of stairs: " + numOfStairsFib);

    }

    public static int numberOfStepsFibonacci(int num) {
        int first = 1, second = 2, result = 0;
        if(num<=2) {
            return num;
        }

        for(int i=3; i<=num; i++) {
            result = first+second;
            first = second;
            second = result;
        }
        return result;
    }

    public static int numberOfStepsBottomup(int num) {
        int[] arr = new int[num+1];
        if(num <=2) {
            return num;
        }
        //base case
        arr[0]=0; arr[1]=1; arr[2]=2;
        for(int i=3; i<=num;i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[num];
    }
}
