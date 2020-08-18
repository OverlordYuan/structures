//问题描述：
//一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
//那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
//1、0-1背包：每类物品最多只能装一次
//2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
//3、完全背包：每类物品可以无限次装进包内

import java.util.ArrayList;
import java.util.List;

public class pack {
    public static int pack01_1(int[] weight,int[] valuce,int V){
        /*0-1背包:动态规划 二维数组*/
        int N = weight.length;
        if (N==0){
            return 0;
        }
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(j<weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+valuce[i-1]);
                }
            }
        }
//        输出装入背包的所有商品的编号
        List<Integer> res = new ArrayList<Integer>();
        int W = V;
        for(int k=N;k>0;k--){
            if(dp[k][W]>dp[k-1][W]){
                res.add(k,weight[k]);
                W = W - weight[k];
            }
            if(W==0){
                break;
            }
        }
        System.out.println(res.toString());
        return dp[N][V];
    }

    public static int pack01_2(int[] weight,int[] valuce,int V){
        int N = weight.length;
        if(N==0){
            return 0;
        }
        int[] dp = new int[V+1];
        for(int i=0;i<N;i++){
            for(int j=V;j>=weight[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+valuce[i]);
            }
        }
        return dp[N];
    }

    public static int completePack_1(int V,int[] weight,int[] value){
        int N = weight.length;
        if(N==0){
            return 0;
        }
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(j<weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return dp[N][V];
    }

    public static int completePack_2(int V,int[] weight,int[] value){
        int N = weight.length;
        if(N==0){
            return 0;
        }
        int[] dp = new int[V+1];
        for(int i=0;i<N;i++){
            for(int j=weight[i];j<V+1;j++){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[N];
    }

    public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(j<weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=1;k<maxV+1;k++){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }
        return dp[N][V];
    }
}
