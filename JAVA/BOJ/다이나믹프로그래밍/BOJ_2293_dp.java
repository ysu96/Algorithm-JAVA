package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://dragon-h.tistory.com/10
// 동전 1
public class BOJ_2293_dp {
    public static int n,k;
    public static int[] arr;
    public static int[] dp = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            for(int j= arr[i]; j<=k ; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);

    }
}
