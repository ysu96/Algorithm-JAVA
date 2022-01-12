package NTS2022;

// dp[cnt][sum][odd_sum]
// cnt : 그룹 개수, sum : 총 합, odd_sum : 홀수번째 총 합, dp[N][M][M/2] * 2 가 정답
// 초기값 dp[0][0][0] = 1 , 아무것도 안하면 1가지

// dp[2x+1][s][os] = l(1~k) 마지막 그룹에 l개를 쓰는 경우를 다 더하기 -> dp[2x][s-l][os-l] 총 합
public class Solution4 {
    public int solution(int n, int m, int k) {
        int[][][] dp = new int[n + 1][m + 1][m + 1];
        int MOD = 1000000007;
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= m; s++) {
                if (s > i * k) {
                    break;
                }

                for (int os = 1; os <= m; os++) { //odd sum, 홀수번째 그룹의 합
                    if (os > s) {
                        break;
                    }

                    if (i % 2 == 1) {
                        for (int l = 1; l <= k; l++) {
                            if (s < l || os < l) {
                                break;
                            }
                            dp[i][s][os] += dp[i - 1][s - l][os - l];
                            dp[i][s][os] %= MOD;
                        }
                    } else {
                        for (int l = 1; l <= k; l++) {
                            if (s < l) {
                                break;
                            }
                            dp[i][s][os] += dp[i - 1][s - l][os];
                            dp[i][s][os] %= MOD;
                        }
                    }
                }
            }
        }
        return dp[n][m][m / 2] * 2;
    }

    public static void main(String[] args) {
        Solution4 s4 = new Solution4();
        System.out.println(s4.solution(3, 8, 4));
        System.out.println(s4.solution(10, 6, 5));
    }
}
