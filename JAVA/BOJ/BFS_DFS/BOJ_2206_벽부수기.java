package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2206 벽 부수고 이동하기
// 벽 최대 1개 부술수 있음 (N,M) (1000,1000)
// 벽 안부수고 일단 가보기 bfs v^2
// 벽을 하나씩 부수고 bfs v^3
public class BOJ_2206_벽부수기 {
    public static int N, M;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[][] visited = new int[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        int cnt = -1;
        int[] start = {0,0,1,0}; // r, c, distance, drill
        visited[0][0] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                cnt = cur[2];
                break;
            }
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr>=N || nr<0 || nc>=M || nc<0) continue;

                if(visited[nr][nc] > cur[3]){
                    if(arr[nr][nc] == 1 && cur[3] == 0){ // 벽 부수기 가능
                        visited[nr][nc] = 1;
                        q.add(new int[]{nr, nc, cur[2] + 1, 1});

                    } else if (arr[nr][nc] == 0) {
                        visited[nr][nc] = cur[3];
                        q.add(new int[]{nr,nc,cur[2]+1, cur[3]});
                    }
                }
            }
        }
        return cnt;
    }
}
