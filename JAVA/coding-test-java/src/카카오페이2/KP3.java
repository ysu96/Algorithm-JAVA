package 카카오페이2;

import java.util.LinkedList;
import java.util.Queue;

public class KP3 {
    // arr
    public static boolean[][][][] arr;
    public static int N, M;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public int solution(int rows, int columns, int[][] maze, int r1, int c1, int r2, int c2) {
        N = rows * rows;
        M = columns * columns;
        arr = new boolean[N + 1][M + 1][N + 1][M + 1];


        for (int[] m : maze) {
            int a1 = m[0];
            int b1 = m[1];
            int a2 = m[2];
            int b2 = m[3];

            mark(a1, b1, a2, b2, rows, columns);
        }

        // 최단 경로 찾기

        return bfs(r1, c1, r2, c2);
    }

    public static int bfs(int r1, int c1, int r2, int c2){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1, c1, 0});
        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[r1][c1] = true;
        int answer = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int dist = poll[2];

            if (r == r2 && c == c2) {
                answer = poll[2];
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                System.out.println("" + nr + "  " + nc);

                if(nr < 1 || nr > N || nc < 1 || nc > M) continue;
                if(!arr[r][c][nr][nc]) continue; // 벽
                if(visited[nr][nc]) continue;
                q.add(new int[]{nr, nc, dist + 1});
                visited[nr][nc] = true;
            }
        }

        return answer;
    }

    public static void mark(int a1, int b1, int a2, int b2, int rows, int columns){
        if (a1 == a2) {
            int sr = rows * (a1 - 1) + 1; // 3
            int b = Math.min(b1, b2) * columns; // 1

            for (int i = sr; i < sr + rows; i++) { // 3 ~ 4
                arr[i][b][i][b + 1] = true;
                arr[i][b + 1][i][b] = true;
            }
        } else {
            int sc = columns * (b1 - 1) + 1;
            int a = Math.min(a1, a2) * rows;
            for (int i = sc; i < sc + columns; i++) {
                arr[a][i][a + 1][i] = true;
                arr[a + 1][i][a][i] = true;
            }
        }

        // 각 칸 길 뚫어주고
        for (int i = 0; i < N; i += rows) {
            for (int j = 0; j < M; j += columns) {
                arr[a1 + i][b1 + j][a2 + i][b2 + j] = true;
                arr[a2 + i][b2 + j][a1 + i][b1 + j] = true;
            }
        }
    }

    public static void main(String[] args) {
        KP3 kp3 = new KP3();
        int[][] maze = new int[][]{
                {1,1,2,1},{2,1,2,2},{2,2,2,3},{1,2,1,3},{2,2,1,2}
        };
        kp3.solution(25, 25, maze, 3, 1, 1, 9);
    }
}

// 1121  -> 1424 -> 1727
// 3141  -> 3444 -> 3747

//rows	columns	maze	r1	c1	r2	c2	result
//2	3	[[1,1,2,1],[2,1,2,2],[2,2,2,3],[1,2,1,3],[2,2,1,2]]	3	1	1	9	12
//3	3	[[1,1,1,2],[1,2,2,2],[1,3,2,3],[2,2,2,3],[2,1,2,2],[2,1,3,1],[2,2,3,2],[3,2,3,3]]	9	1	1	9	16

//