package JAVA.BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M 5
public class BOJ_15654 {
    public static int N,M;
    public static int[] arr, answer;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0,0);
    }

    public static void backtracking(int n, int idx){
        if(idx == M){
            //출력
            for (int i : answer) {
                System.out.print(Integer.toString(i)+ " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;

            answer[idx] = arr[i];
            visited[i] = true;
            backtracking(n+1, idx+1);
            visited[i] = false;
        }
    }

}
