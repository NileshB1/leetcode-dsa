package dsa1;
//https://www.youtube.com/watch?v=ih2OZ9-M3OM
//https://www.youtube.com/watch?v=hK6Git1o42c
public class i_DP_InterleavingStrings {
    public static void main(String[] args) {
        String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";

        boolean areStringsinterLeaved = isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray());
        System.out.println("Strings are interleaved: " + areStringsinterLeaved);
    }

    public static boolean isInterleaved(char[] str1, char[] str2, char[] str3) {
        int length1 = str1.length, length2 = str2.length, length3 = str3.length;

        if(length1 + length2 != length3) {
            return false;
        }
        boolean dp[][] = new boolean[length1+1][length2+1];
        dp[0][0] = true;

        for(int i=0; i <= length1; i++) {
            for(int j=0; j <= length2; j++) {

                // base case
                if(i==0 && j==0) {
                    dp[i][j] = true;
                }
                int l = i+j-1;
                if (i > 0 && str3[l] == str1[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

                if (j > 0 && str3[l] == str2[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return  dp[length1][length2];
    }
}
