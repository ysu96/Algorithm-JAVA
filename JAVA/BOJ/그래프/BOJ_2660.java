package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2660 {
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(arr[i], 100000);
        }
        for(int i=1; i<=N; i++){
            arr[i][i] = 0;
        }
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1) break;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
                }
            }
        }

        int[] scores = new int[N+1];
        int minScore = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            int score=0;
            for(int j=1; j<=N; j++){
                score = Math.max(score, arr[i][j]);
            }
            scores[i] = score;
            minScore = Math.min(minScore,score);
        }

        int cnt=0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(scores[i] == minScore) {
                cnt++;
                sb.append(i).append(' ');
            }
        }

        System.out.println(String.valueOf(minScore) + ' ' + cnt + '\n' + sb);
    }
}
