package solution.easy;

/**
 * 0-1背包问题
 * 考察动态规划
 * 如何找出状态转移方程, 并选择最优解
 */
public class 背包问题 {

    public static Integer getMaxValue(int N, int M, int[] wt, int[] val) {
        // dp表示 前N个物品,在重量为M时, 总收益最大
        int[][] dp = new int[N+1][M+1];
        for (int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                // 表示背包剩余空间 < 0, 这时候 dp[n][m] = dp[n - 1][m]
                if(m - wt[n - 1] < 0) {
                    dp[n][m] = dp[n - 1][m];
                }else{
                    // Math.max(不放入这个n, 放入这个n)
                    dp[n][m] = Math.max(dp[n-1][m], dp[n-1][m - wt[n - 1]] + val[n-1]);
                }
            }
        }
        return dp[N][M];
    }

    public static void main(String[] args) {
        int N = 3; // 3个物品
        int M = 4; // 背包容量为4
        int wt[] = {2,1,3};
        int val[] = {4,2,3};
        Integer maxValue = getMaxValue(N, M, wt, val);
        System.out.println(maxValue);
    }
}
