package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9252_LCS2 {
    public static String s1,s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        for(int i=0; i<=s1.length(); i++){
            Arrays.fill(dp[i], "");
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i-1);
                }
                else{
                    if (dp[i][j - 1].length() > dp[i - 1][j].length()) {
                        dp[i][j] = dp[i][j - 1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()].length());
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
