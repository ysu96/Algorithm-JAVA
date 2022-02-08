package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2 {
    public static int N;
    public static int[][] weight, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        weight = new int[N][3];
        dp = new int[N][3];
        int[] idx = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            weight[i][0] = Integer.parseInt(st.nextToken());
            weight[i][1] = Integer.parseInt(st.nextToken());
            weight[i][2] = Integer.parseInt(st.nextToken());
        }
        int answer = (int) 1e9;
        for(int k=0; k<3; k++){
            for(int i=0; i<3; i++){
                dp[0][i] = (int)1e9;
            }
            dp[0][k] = weight[0][k];
            for(int i=1; i<N; i++){
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + weight[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + weight[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + weight[i][2];
            }
            for(int i=0; i<3; i++){
                if(i == k) continue;
                answer = Math.min(answer, dp[N - 1][i]);
            }
        }
        System.out.println(answer);
    }
}
