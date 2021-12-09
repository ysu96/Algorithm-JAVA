package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS 최장 증가수열
// 맨 앞, 뒤에 밖에 못옮기므로 연속된 숫자 중 최장 길이 증가수열을 찾아야한다.
// dp로 그 전 숫자의 LIS길이 + 1 해서 구한다.
public class BOJ_7570_LIS2 {
    public static int n;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[arr[i]] = dp[arr[i]-1] + 1;
            max = Math.max(max, dp[arr[i]]);
        }
        System.out.println(n-max);
    }
}
