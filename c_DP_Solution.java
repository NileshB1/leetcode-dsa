package dsa1;

/*
Given two integers m and n representing the number of rows and columns of a grid, respectively, find the number of distinct paths from the top-left cell (0, 0) to the bottom-right cell (m - 1, n - 1).
From any cell, you can move only right or down.
Note: The answer is guaranteed to fit within a 32-bit integer.
 */
public class c_DP_Solution {
    public int uniquePathWithObstracles(int[][] obstracleGrid) {
        int r = obstracleGrid.length;
        int c = obstracleGrid[0].length;


        if(obstracleGrid[0][0] == 1 || obstracleGrid[r-1][c-1]==1) return 0;

        int[][] result = new int[r][c];
        result[0][0] = 1;
        //fill 1st row
        for(int i=1; i<c; i++) {
            if(obstracleGrid[0][i] == 0 && result[0][i-1] ==1) {
                result[0][i] = 1;
            } else {
                result[0][i] = 0;
            }
        }

        //fill 1st column
        for(int i=1; i<r; i++) {
            if(obstracleGrid[i][0] == 0 && result[i-1][0] ==1) {
                result[0][i] = 1;
            } else {
                result[0][i] = 0;
            }
        }

        //Rest matrix
        for(int i=1; i<r; i++) {
            for(int j=1; i<c; j++) {
                if(obstracleGrid[i][j] ==1) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j]+result[i][j-1];
                }
            }
        }
        return result[r-1][c-1];
    }
}
