/*
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        if(n!=0){
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for(int k=1;k<n;k++){
                dp[0][k] = grid[0][k] + dp[0][k-1];
            }
            for(int i = 1;i<m;i++)
                for(int j=0;j<n;j++){
                    if(j==0){
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }else {
                        dp[i][j] = grid[i][j]+ Math.min(dp[i][j-1],dp[i-1][j]);
                    }
                }
            res = dp[m-1][n-1];
            }
        return res;
    }

    public static int minPathSum_1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        if(n!=0) {
            int[] dp = new int[n];
            int[] temp = new int[n];
            dp[0] = grid[0][0];
            for (int k = 1; k < n; k++) {
                dp[k] = grid[0][k] + dp[k - 1];
            }
            for (int i = 1; i < m; i++) {
                temp = dp;
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        dp[j] = temp[j] + grid[i][j];
                    } else {
                        dp[j] = grid[i][j] + Math.min(temp[j - 1], temp[j]);
                    }
                }
            }
            res = dp[n - 1];
        }
        return res;
    }

    public static void main(String[] args){
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int a = minPathSum_1(nums);
        System.out.println(a);
    }
}
