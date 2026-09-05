class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        
        for(int i = 2; i<n; i++){

            //if robbing the house
            int rob = nums[i] + dp[i-2];

            //if not robbing the house
            int notRob = dp[i-1];

            dp[i] = Math.max(rob, notRob);
        }
        return dp[n-1];
    }
}