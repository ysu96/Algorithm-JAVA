package Wins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class P3 {
    public static int[] dp;

    public int solution(int n){
        // n을 3의 배수와 5의 배수로 나눠야함
        // dp[0] = 0;
        // dp[1] = -1;
        // dp[2] = -1;
        // dp[3] = 1;
        // dp[4] = -1;
        // dp[5] = 1;
        // dp[6] = 2;
        // dp[8] = 2;

        // dp[i] = dp[i-3]+1 or dp[i-5]+1
        // dp[i-3] == -1 && dp[i-5] == -1 이면 불가능
        int INF = Integer.MAX_VALUE;
        dp = new int[n+1];
        Arrays.fill(dp, INF);
        if(n == 3) return 1;
        if(n == 4) return -1;
        if(n == 5) return -1;
        dp[0] = 0;
        dp[3] = 1;
        dp[5] = 1;

        List<Integer> three = new ArrayList<>();
        List<Integer> five = new ArrayList<>();
        Set<>
        for(int i=6; i<=n; i++){
            if(dp[i-3] == INF && dp[i-5] == INF){
            }
            else{
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            }
//            if(dp[i-3] == -1){
//                if(dp[i-5] == -1){
//                    continue;
//                }else{
//                    dp[i] = dp[i-5] + 1;
//                }
//            }else{
//                if(dp[i-5] == -1){
//                    dp[i] = dp[i-3] + 1;
//                }else{
//                    dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
//                }
//            }
        }

        if(dp[n] == INF) return -1;
        return dp[n];
    }
    public static void main(String[] args) {
        P3 p3 = new P3();
        System.out.println(p3.solution(1000000000));
        p3.solution(3);
    }
}
