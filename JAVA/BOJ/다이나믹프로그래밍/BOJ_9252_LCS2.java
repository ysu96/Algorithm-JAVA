package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9252_LCS2 {
    public static String s1,s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i][j - 1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        int n = s1.length();
        int m = s2.length();
        while (n > 0 && m > 0) {
            if (dp[n][m] == dp[n][m - 1]) {
                m--;
            } else if (dp[n][m] == dp[n - 1][m]) {
                n--;
            }else{
                stack.add(s1.charAt(n-1));
                n--;
                m--;
            }
        }
        String answer = "";
        int cnt = dp[s1.length()][s2.length()];
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.println(cnt);
        if(cnt != 0) System.out.println(answer);
    }
}
