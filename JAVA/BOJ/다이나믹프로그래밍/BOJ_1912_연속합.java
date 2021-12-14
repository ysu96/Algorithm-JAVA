package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이전부터 계속 연속한 값 vs 현재부터 연속된 값 의 경우를 따지면 된다.
public class BOJ_1912_연속합 {
    public static int n;
    public static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
