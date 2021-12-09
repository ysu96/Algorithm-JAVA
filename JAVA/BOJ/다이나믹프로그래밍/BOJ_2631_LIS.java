package 다이나믹프로그래밍;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LIS : 가장 긴 증가수열 구하기 알고리즘
public class BOJ_2631_LIS {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //LIS
        int lis =0 ;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            lis = Math.max(lis, dp[i]);
        }
        System.out.println(n-lis);
    }
}
