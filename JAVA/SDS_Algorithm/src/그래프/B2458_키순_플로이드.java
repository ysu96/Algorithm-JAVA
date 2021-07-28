package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class B2458_키순_플로이드 {
    private static int N,M;
    private static int[][] graph;
    private static int INF = (int)1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for(int i= 1; i<=N; i++){
            for(int j=1; j<=N; j++){
                graph[i][j] = INF;
                if(i==j) graph[i][j] = 0;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        for(int k=1;k<=N;k++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++){
                    graph[a][b] = Math.min(graph[a][k]+graph[k][b], graph[a][b]);
                }
            }
        }

        int ans=0;

        for(int i=1;i<=N;i++){
            int cnt=0;
            for(int j=1;j<=N;j++){
                if(graph[i][j] != INF || graph[j][i] != INF) cnt++;
            }
            if(cnt==N) ans++;
        }
        System.out.println(ans);
    }
}
