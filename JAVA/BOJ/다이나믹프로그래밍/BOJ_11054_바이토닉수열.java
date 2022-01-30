package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054_바이토닉수열 {
    public static int N;
    public static int[] arr, dpASC, dpDESC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dpASC = new int[N];
        dpDESC = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 한 인덱스의 LIS와 뒤에서부터의 LDS의 길이를 더하면 바이토닉 부분 수열의 길이가 됨

        // LIS 최장 증가 부분수열 길이 구하기
        for (int i = 0; i < N; i++) {
            dpASC[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpASC[i] = Math.max(dpASC[j] + 1, dpASC[i]);
                }
            }
        }

        // LDS 최장 감소 부분수열 길이 구하기
        for (int i = N - 1; i >= 0; i--) {
            dpDESC[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpDESC[i] = Math.max(dpDESC[j] + 1, dpDESC[i]);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dpASC[i] + dpDESC[i] - 1);
        }
        System.out.println(answer);
    }
}
