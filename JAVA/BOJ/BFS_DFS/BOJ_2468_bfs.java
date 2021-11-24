package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Area {
    int r;
    int c;

    Area(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class BOJ_2468_bfs {
    public static int n;
    public static int[][] arr;
    public static int[][] arr2;
    public static boolean[][] visited;
    public static int height;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static Queue<Area> queue = new LinkedList<>();

    public static void bfs(int ii, int jj) {
        queue.add(new Area(ii, jj));
        while (!queue.isEmpty()) {
            Area poll = queue.poll();
            int r = poll.r;
            int c = poll.c;
            visited[r][c] = true;
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(arr2[nr][nc] > 0 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.add(new Area(nr,nc));
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        arr2 = new int[n][n];

        int cnt =0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, arr[i][j]);
            }
        }

        for (int h = 0; h < height; h++) {

            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr2[i][j] = arr[i][j]-h;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr2[i][j] > 0 && !visited[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
            cnt =0;
        }
        System.out.println(answer);
    }
}

