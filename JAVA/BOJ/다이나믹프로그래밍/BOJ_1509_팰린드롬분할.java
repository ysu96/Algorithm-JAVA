package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://lotuslee.tistory.com/6

//dp[i] : 0부터 i번째 위치까지 팰린드롬 분할의 최소 개수
//palindrome[j][i] : j번째부터 i번째까지의 문자열이 팰린드롬이면 true, 팰린드롬이 아니면 false

//점화식 : dp[i] = min(dp[j-1]) + 1
public class BOJ_1509_팰린드롬분할 {
    public static String str;
    public static int N;
    public static int[] dp;
    public static boolean[][] palindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
        dp = new int[N + 1];
        palindrome = new boolean[N + 1][N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        checkPalindrome();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[N]);

    }

    public static void checkPalindrome() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                boolean flag = true;
                int start = i;
                int end = j;
                while (start <= end) {
                    if (str.charAt(start) != str.charAt(end)) {
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if (flag) palindrome[i + 1][j + 1] = true;
            }
        }
    }
}
