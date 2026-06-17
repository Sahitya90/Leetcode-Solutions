import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 1D array representing the current row.
        // Size is 'n' (number of columns).
        int[] dp = new int[n];
        
        // Base Case: There is exactly 1 way to reach any cell in the first row 
        // (by only moving strictly right).
        Arrays.fill(dp, 1);
        
        // Loop through the remaining rows (starting from row 1 to m-1)
        for (int i = 1; i < m; i++) {
            // Loop through columns (starting from column 1 to n-1)
            for (int j = 1; j < n; j++) {
                // dp[j] (old value from the top) + dp[j-1] (new value from the left)
                dp[j] = dp[j] + dp[j-1];
            }
        }
        
        // The last element contains the total unique paths to the bottom-right corner
        return dp[n - 1];
    }
}