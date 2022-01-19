package JAVA.BOJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// F(2n-1)  = F(n)^2 + F(n-1)^2
// F(2n) = ( F(n-1) + F(n+1) ) * F(n) = (2 * F(n-1) + F(n) ) * F(n)
public class BOJ_11444_피보나치6 {
    static long n;
    static final long mod = 1000000007;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long answer = fibo(n);
        System.out.println(answer);
    }

    public static long fibo(long n) {
        if (map.containsKey(n)) return map.get(n);
        else if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 1;

        //짝수
        if (n % 2 == 0) {
            long f = ((2 * fibo(n / 2 - 1) + fibo(n / 2)) * fibo(n / 2)) % mod;
            map.put(n, f);
            return f;
        }
        //홀수
        else {
            long m = (n + 1) / 2;
            long t1 = fibo(m);
            long t2 = fibo(m - 1);
            long f = (t1 * t1 + t2 * t2) % mod;
            map.put(n, f);
            return f;
        }
    }
}
