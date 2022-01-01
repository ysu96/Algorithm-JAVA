package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133 {
    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;
        dp[6] = 41;
        for(int i=8; i<=N; i+=2){
            dp[i] = dp[i-2]*3;
            for(int j=i-4; j>=0 ; j-=2){
                dp[i]+= dp[j]*2;
            }
        }
        System.out.println(dp[N]);
    }
}
