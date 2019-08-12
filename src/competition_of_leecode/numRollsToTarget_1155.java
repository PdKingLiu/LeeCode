package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/8/12 8:51
 */
public class numRollsToTarget_1155 {

    /*这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。

        我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。

        如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。*/

    public int numRollsToTarget2(int d, int f, int target) {
        if (target > f * d) {
            return 0;
        }
        int[][] dp = new int[d + 1][f * d + 1];
        for (int i = 1; i <= f; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= i * f; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j - k >= 1) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[d][target];
    }


    /*回溯*/

    int now = 0;
    int count = 0;

    public int numRollsToTarget(int d, int f, int target) {
        backtrack(0, d, f, target);
        return count;
    }

    public void backtrack(int n, int d, int f, int target) {
        if (n > d) {
            return;
        }
        if (now == target) {
            count++;
        }
        for (int i = 0; i < f; i++) {
            if (now + i + 1 > target) {
                break;
            }
            now += i + 1;
            backtrack(n + 1, d, f, target);
            now -= i + 1;
        }
    }
}
