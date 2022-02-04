package JAVA.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
    public static int N, max;
    public static int a1, a2;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        max = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            search(i, i + 1, N - 1);
        }
        System.out.println(String.format("%s %s", a1, a2));

    }

    public static void search(int a, int start, int end) {
        if(start > end) return;

        int mid = (start + end) / 2;

        int sum = arr[mid] + arr[a];
        if (Math.abs(sum) < max) {
            a1 = arr[a];
            a2 = arr[mid];
            max = Math.abs(sum);
        }

        if(sum < 0){
            search(a, mid + 1, end);
        }else{
            search(a, start, mid - 1);
        }
    }
}
