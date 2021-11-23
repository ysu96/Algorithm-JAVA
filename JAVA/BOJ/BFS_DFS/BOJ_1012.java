package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유기농 배추 dfs
public class BOJ_1012 {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tt = 0; tt<T; tt++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            graph = new int[N][M];
            visited = new boolean[N][M];

            int K = Integer.parseInt(st.nextToken());
            for(int kk =0; kk<K; kk++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[Y][X] = 1;
            }
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }

    }
    public static void dfs(int r, int c){
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (graph[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
