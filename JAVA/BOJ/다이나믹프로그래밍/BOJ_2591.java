package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//카드게임 1~34
public class BOJ_2591 {
    public static String N;
    public static int[] dp;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=1; i<N.length(); i++){
            int tmp = N.charAt(i)-'0';
            if(tmp != 0) dp[i+1] = dp[i];

            if(Integer.parseInt(N.substring(i-1, i+1)) <= 34 && N.charAt(i-1)-'0'!=0){
                dp[i+1] += dp[i-1];
            }
        }
        System.out.println(dp[N.length()]);
    }
}
