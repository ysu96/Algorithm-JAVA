package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_dp {
    public static int n;
    public static int[][] triangle;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = triangle[0][0];
        for(int i=0; i<n-1; i++){
            for(int j=0; j<=i; j++){
                dp[i+1][j] = Math.max(triangle[i+1][j]+dp[i][j], dp[i+1][j]) ;
                dp[i+1][j+1] = Math.max(triangle[i+1][j+1]+dp[i][j], dp[i+1][j+1]) ;
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        System.out.println(answer);
    }
}
