class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        if(n == 1 && (amount % coins[0] != 0)){
            return -1;
        }
    
        dp[0] = 0;

        for(int i = 1; i<dp.length; i++){

            for(int coin : coins){

                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE){

                    dp[i] = Math.min(dp[i], dp[i - coin]+1 );

                }


            }

           
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}