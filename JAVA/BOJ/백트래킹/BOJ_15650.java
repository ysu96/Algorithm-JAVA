package JAVA.BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M 2
public class BOJ_15650 {
    public static int N,M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solution(1, 0);
    }

    public static void solution(int n, int idx) {
        if (idx == M) {
            //출력
            for (int i : arr) {
                System.out.print(Integer.toString(i)+ " ");
            }
            System.out.println();
            return;
        }

        for(int i=n; i<=N; i++){
            arr[idx] = i;
            solution(i+1, idx+1);
        }

    }
}
