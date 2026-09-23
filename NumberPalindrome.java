package dsa1;

//1. Normal reverse number. Just check while num > reversedNum (Means both numbers are halfway or reversedNum is greater by 10x)
public class NumberPalindrome {
    public static void main(String[] args) {
        int num = 12321;
        // int num = -121;
        // int num = 1234;
        boolean isNumPalidrome = isPalindrome(num);
        System.out.println("Number: "+ num + ", is palindrome: " + isNumPalidrome);
    }

    public static boolean isPalindrome(int num) {
        if(num <=0) {
            return false;
        }
        if(num>0 && num%10==0) {
            return false;
        }
        int revesedNum = 0;
        int lastDigit = 0;
        while(num > revesedNum) {
            lastDigit = num%10;
            revesedNum = (revesedNum*10) + lastDigit;
            num = num/10;
        }
        return (num == revesedNum) || (num == revesedNum/10);
    }
}
