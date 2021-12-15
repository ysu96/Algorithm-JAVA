package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398_연속합2 {
    public static int n;
    public static int[] arr;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][2];
        // 0 : 이전까지의 최댓값과 자기 자신의 합, 자기 자신 중에서 최댓값
        // 1 : 자기 자신을 제거해야 할 경우와 제거 안 해도 될 경우
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int answer = arr[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(answer);
    }
}
