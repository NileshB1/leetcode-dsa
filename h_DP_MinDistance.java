package dsa1;

public class h_DP_MinDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int minDistance = minDistance(word1, word2);
        System.out.println("Minimum operation required to convert string is: " + minDistance);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0] = i; //column
        for(int j=0; j<=n; j++) dp[0][j] = j; //row

        for(int i=1; i<=m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int diagonal = dp[i - 1][j - 1];
                    int top = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int min = Math.min(diagonal, (Math.min(top, left)));
                    dp[i][j] = 1 + min;
                }
            }
        }
        return dp[m][n];
    }
}
