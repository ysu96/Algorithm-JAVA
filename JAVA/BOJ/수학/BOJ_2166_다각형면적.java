package JAVA.BOJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166_다각형면적 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        long sumA = 0, sumB = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];

        for (int i = 0; i < N; i++) {
            sumA += x[i] * y[i+1];
            sumB += x[i+1] * y[i];
        }
        double ans = Math.abs(sumA - sumB) / 2.0;
        System.out.println(String.format("%.1f", ans));
    }
}
