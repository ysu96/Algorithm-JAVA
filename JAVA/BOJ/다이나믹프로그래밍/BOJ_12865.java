package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static int N,K;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N][2];
        dp = new int[N+1][K+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i][0] = weight;
            items[i][1] = value;
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++){
                if(items[i-1][0] <= j){
                    dp[i][j] = Math.max(items[i-1][1] + dp[i-1][j-items[i-1][0]], dp[i-1][j]);
                    // 물건 포함하거나 안하거나
                    // 물건 포함하고 남은 무게 중 최대값 더하기 (dp[i-1][j-items[i-1][0]])
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }


}
