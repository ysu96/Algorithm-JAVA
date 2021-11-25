package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://st-lab.tistory.com/139
// LCS , 최장길이 공통 수열 구하기
// LCS(Xi, Yj) : LCS(Xi-1, Yj-1) + 1    if (Xi == Yj)
// LCS(Xi, Yj) : max( LCS(Xi-1, Yj), LCS(Xi, Yj-1) )    if (Xi != Yj)
// x번째 원소와 y번째 원소가 같다면 (x-1, y-1) 의 LCS길이의 +1이 된다.
public class BOJ_9251_LCS {
    public static String a,b;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        dp = new int[a.length()+1][b.length()+1];

        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

//        for(int i=1; i<=a.length(); i++){
//            for(int j=1; j<=b.length(); j++){
//                System.out.print(dp[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
