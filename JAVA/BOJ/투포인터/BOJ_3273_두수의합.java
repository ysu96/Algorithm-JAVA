package JAVA.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
    public static int N, x;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int answer = 0;
        while (left < right) {
            int n = arr[left] + arr[right];
            if (n > x) {
                right--;
            } else if (n < x) {
                left++;
            } else {
                answer++;
                left++;
                right--;
            }
        }
        System.out.println(answer);
    }
}
