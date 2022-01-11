package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//BigInteger 사용한 큰 수 연산
public class BOJ_2407_조합 {
    public static int n,m;
    public static BigInteger[] dp = new BigInteger[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //(n)! / ((n-m)! * m!)
        if(m > (n/2)){
            m = n-m;
        }
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.TWO;
        dp[3] = new BigInteger("6");
        for(int i=4; i<=100; i++){
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }

        BigInteger answer = dp[n].divide(dp[n-m].multiply(dp[m]));
        System.out.println(answer);
    }

}
