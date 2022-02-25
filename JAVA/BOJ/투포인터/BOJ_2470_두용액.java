package JAVA.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int answer = Integer.MAX_VALUE;
        int a=0,b=0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (answer > Math.abs(sum)) {
                a = arr[left];
                b = arr[right];
                answer = Math.abs(sum);
            }
            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(String.format("%d %d", a, b));
    }
}
