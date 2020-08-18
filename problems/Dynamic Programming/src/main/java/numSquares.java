import java.util.Arrays;

public class numSquares {
    public int numSquares(int n){
        if(n<2){
            return 1;
        }
        int i = 1;
        while(i*i<n){
            i++;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for(int j =1;j<=i;j++){
            for(int k=1;k<n+1;k++){
                if(k>=j*j) {
                    dp[k] = Math.min(dp[k],dp[k-j*j]+1);
                }
            }
        }
        return dp[n];
    }

}
