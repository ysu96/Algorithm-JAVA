package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {
    public static int N, M;
    public static int[][] apps;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        apps = new int[N][2];
        dp = new int[N][10001]; //  확보가능한 최대 메모리 크기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apps[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apps[i][1] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 0;
        //dp[0][0] = 0 → 0번째까지 입력된 앱을 사용할 때 비용0으로 확보가능한 최대 메모리 크기는 0

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int memory = apps[i][0];
            int cost = apps[i][1];

            for(int j=0; j<=10000; j++){
                if(i==0){
                    if(j >= cost) dp[i][j] = memory;
                }
                else{
                    if(j >= cost) dp[i][j] = Math.max(dp[i-1][j-cost] + memory, dp[i-1][j]);
                    else dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}
