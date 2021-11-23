package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_dp {
    public static int n;
    public static int[] grape;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grape = new int[n+1];
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            grape[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grape[1];
        if(n>1){
            dp[2] = grape[2]+grape[1];
        }
        for(int i=3 ;i<=n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]));
            //1. 현재 잔 안마시기
            //2. 이전 이전 잔 + 현재 잔 마시기
            //3. 이전이전이전 잔 + 이전 잔 + 현재 잔 마시기
        }

        System.out.println(dp[n]);
    }
}
