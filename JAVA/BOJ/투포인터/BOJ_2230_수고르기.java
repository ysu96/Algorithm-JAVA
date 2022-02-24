package JAVA.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230_수고르기 {
    public static int N, M;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (left <= right && right < N) {
            int n = A[right] - A[left];

            if (n >= M) {
                answer = Math.min(answer, n);
                left++;
            } else {
                right++;
            }
        }
        System.out.println(answer);
    }
}
