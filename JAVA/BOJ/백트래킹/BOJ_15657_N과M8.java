package JAVA.BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N과M8 {
    public static int N,M;
    public static int[] arr, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0, 0);
    }

    public static void back(int n, int idx){
        if(idx == M){
            StringBuilder sb = new StringBuilder();
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = n; i<N; i++){
            answer[idx] = arr[i];
            back(i, idx+1);
        }
    }
}
