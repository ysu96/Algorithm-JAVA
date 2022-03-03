package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7569_토마토 {
    public static int N, M, H;
    public static int[][][] tomato;

    public static Queue<Point> q = new LinkedList<>();

    static class Point {
        int x;
        int y;
        int z;

        Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        q.add(new Point(i, j, k));
                    }
                }
            }
        }
        int answer = 0;
        answer = bfs();
        System.out.println(answer);
    }

    public static int bfs(){
        int[] dr = {0, 0, -1, 1, 0, 0};
        int[] dc = {-1, 1, 0, 0, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 6; i++) {
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];
                int nh = p.z + dh[i];

                if (!validateRange(nh, nr, nc)) continue;

                if (tomato[nh][nr][nc] == 0) {
                    tomato[nh][nr][nc] = tomato[p.z][p.x][p.y] + 1;
                    q.add(new Point(nh, nr, nc));
                }
            }
        }
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, tomato[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        return result-1;
    }

    public static boolean validateRange(int h, int r, int c) {
        if (h < 0 || h >= H) return false;
        if (r < 0 || r >= N) return false;
        if (c < 0 || c >= M) return false;
        return true;
    }
}
