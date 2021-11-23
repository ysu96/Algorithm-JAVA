package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리 dp
public class BOJ_1149_dp {
    public static int n;
    public static int[][] dp;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][3];
        dp= new int[n + 1][3];

        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        int answer = Math.min(Math.min(dp(n, 0), dp(n,1)), dp(n,2));
        System.out.println(answer);
    }

    public static int dp(int i, int color){
        if(dp[i][color] == 0){
            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
            if(color == 0){
                dp[i][0] = Math.min(dp(i-1, 1), dp(i-1, 2)) + arr[i][0];
            }
            else if (color == 1){
                dp[i][1] = Math.min(dp(i-1, 0), dp(i-1,2)) + arr[i][1];
            }
            else{
                dp[i][2] = Math.min(dp(i-1, 0), dp(i-1,1)) + arr[i][2];
            }
        }
        return dp[i][color];
    }
}
