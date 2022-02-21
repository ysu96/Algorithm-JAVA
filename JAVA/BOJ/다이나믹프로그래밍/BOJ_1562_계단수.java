package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://loosie.tistory.com/171
// 비트마스킹 **

//dp[n][num][bit] += dp[n-1][num+1][bit] + dp[n-1][num-1][bit];
//길이가 n-1이고 끝자리 수가 num라고 하면 이는 계단 수이기 때문에 (끝자리에 num+1이 들어올 경우) + (끝자리에 num-1이 들어올 경우)를 더해주면 된다.

//*  i : i자리 숫자
//		 *  j 끝나는 숫자 , k 마킹된 숫자
//			  ex) 	j=9, 10 0000 0000
//
//					k =1, 10 0000 0001
//					...
//					k = 9, 10 0000 1001
//					...
//					k = 1023, 11 1111 1111

public class BOJ_1562_계단수 {
    public static int N;
    public static long ans;
    public static long[][][] dp;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][11][1 << 10];
        for(int i=1; i<10; i++){
            dp[1][i][1<<i] = 1;
        }
        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<1024; k++){
                    int bit = k | (1 << j);
                    if(j == 0){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % MOD;
                    }else if(j == 9){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % MOD;
                    } else{
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k] + dp[i-1][j-1][k]) % MOD;
                    }
                }
            }
        }
        for(int i=0; i<10; i++){
            ans = (ans + dp[N][i][1023]) % MOD;
        }
        System.out.println(ans);
    }
}
