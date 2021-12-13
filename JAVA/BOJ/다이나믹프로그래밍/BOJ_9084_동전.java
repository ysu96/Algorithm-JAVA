package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 0원 만드는 경우의 수 1로 다 초기화
// 2. 현재 동전 없이 만든 경우의 수 + 현재 동전 1개 뺀 값 경우의 수 + 2개 뺀 경우의 수 + .... 못 뺄때까지
public class BOJ_9084_동전 {
    public static int T, N, M;
    public static int[] arr;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[N+1][M+1];

            for(int ii=0; ii<=N; ii++){
                dp[ii][0] = 1;
            }

            for(int k=1; k<=N; k++){
                for(int z=1; z<=M; z++){
                    int tmp = arr[k];
                    dp[k][z] += dp[k-1][z];
                    while(z-tmp >=0){
                        dp[k][z]+= dp[k-1][z-tmp];
                        tmp += arr[k];
                    }
                }
            }
            System.out.println(dp[N][M]);
        }
    }
}
