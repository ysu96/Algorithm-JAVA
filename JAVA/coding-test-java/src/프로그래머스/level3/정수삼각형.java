package 프로그래머스.level3;

import java.util.Arrays;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for(int i =0; i<n;i++){
            Arrays.fill(dp[i],0);
        }

        dp[0][0] = triangle[0][0];
        for (int i=1; i< n; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            for (int j=1; j<=i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }
        }

        for(int i =0 ;i<n; i++){
            answer = Math.max(dp[n-1][i], answer);
        }


        return answer;
    }
}
