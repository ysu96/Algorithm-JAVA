package JAVA.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//투포인터 사용?!
public class BOJ_2473_세용액 {
    public static int N;
    public static long a1,a2,a3;
    public static long max;
    public static long[] arr;
    public static long[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        max = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        answer = new long[3];
        for (int i = 0; i < N - 2; i++) {
            search(i);
        }
        System.out.println(String.format("%s %s %s", a1, a2, a3));
//        Arrays.sort(answer);
//        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

    }

    public static void search(int i) {
        int left = i + 1;
        int right = N - 1;
        while (left < right) {
            long sum = arr[i] + arr[left] + arr[right];
            long sumAbs = Math.abs(sum);
            if (sumAbs < max) {
                a1 = arr[i];
                a2 = arr[left];
                a3 = arr[right];
                answer[0] = arr[i];
                answer[1] = arr[left];
                answer[2] = arr[right];
                max = sumAbs;
            }
            if(sum > 0) right--;
            else left++;
        }
    }
}
