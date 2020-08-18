import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length<1){
            return  -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=0;i<coins.length;i++){
            for(int j =1;j<amount+1;j++){
                if(j>=coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
