package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_합분해 {
    public static int n,k;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1][n+1];
        for(int i=0; i<=n; i++){
            dp[1][i] = 1;
            if(k>=2) dp[2][i] = i+1;
        }
        for(int i=0; i<=k; i++){
            dp[i][0] = 1;
        }

        for(int kk=3; kk<=k; kk++){
            for(int nn=1; nn<=n; nn++){
                dp[kk][nn] = (dp[kk-1][nn] + dp[kk][nn-1])%1000000000;
            }
        }
        System.out.println(dp[k][n]);
    }
}
