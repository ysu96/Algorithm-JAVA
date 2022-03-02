package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    public static int N;
    public static int[][] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        dp = new int[N+1];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=N-1; i>=0; i--){
            int t = arr[i][0];
            int p = arr[i][1];
            if(i + t > N) {
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(dp[i + t] + p, dp[i + 1]);
            }
//            System.out.println(dp[i]);
        }
        System.out.println(dp[0]);
    }
}
