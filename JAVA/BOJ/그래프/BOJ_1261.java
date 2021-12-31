package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class AOJ implements Comparable<AOJ>{
    int r,c,cnt;
    AOJ(int r, int c, int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(AOJ o) {
        return this.cnt - o.cnt;
    }
}

public class BOJ_1261 {
    public static int[] dr = {0,0,-1,1};
    public static int[] dc = {-1,1,0,0};
    public static int N,M;
    public static int[][] arr, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Character.getNumericValue(tmp.charAt(j));
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0,0);
        System.out.println(dist[N-1][M-1]);
    }
    public static void bfs(int fr, int fc){
        dist[fr][fc] = 0;
        PriorityQueue<AOJ> q = new PriorityQueue<>();
        q.add(new AOJ(fr, fc, 0));
        while (!q.isEmpty()) {
            AOJ now = q.poll();

            if (now.r == N - 1 && now.c == M - 1) {
                break;
            }

            for(int i=0; i<4; i++){
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if (arr[nr][nc] == 0) {
                    if(now.cnt < dist[nr][nc]){
                        q.add(new AOJ(nr,nc, now.cnt));
                        dist[nr][nc] = now.cnt;
                    }
                }else{
                    if(now.cnt+1 < dist[nr][nc]){
                        q.add(new AOJ(nr, nc, now.cnt+1));
                        dist[nr][nc] = now.cnt+1;
                    }
                }
            }
        }
    }
}
