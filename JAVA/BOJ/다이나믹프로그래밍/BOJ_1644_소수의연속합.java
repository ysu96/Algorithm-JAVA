package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://firework-ham.tistory.com/10
public class BOJ_1644_소수의연속합 {
    public static int N;
    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
//        for (int i = 1; i <= 4000000; i++) {
//            if (isDecimal(i)) list.add(i);
//        }

        // 1. 소수 구하기 , 에라토스테네스의 체
        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!prime[i]) list.add(i);
        }

        int answer = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (true) {
            if(sum >= N) sum -= list.get(left++);
            else if(right == list.size()) break;
            else sum += list.get(right++);

            if(sum == N) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isDecimal(int n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
