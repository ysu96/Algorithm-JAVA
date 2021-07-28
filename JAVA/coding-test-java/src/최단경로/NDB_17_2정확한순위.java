package 최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NDB_17_2정확한순위 {
    private static int[][] graph;
    private static int N,M;
    private static int INF = (int) 1e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for(int i=1; i<=N; i++){
            graph[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        int ans = 0;
        for(int i=1;i<=N;i++){
            int count = 0;
            for(int j=1;j<=N;j++){
                if(graph[i][j] != INF || graph[j][i] != INF){
                    count++;
                }
            }
            if(count == N) ans++;
        }

        System.out.println(ans);
    }
}
