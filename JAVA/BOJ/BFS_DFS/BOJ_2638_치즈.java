package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
    public static int N, M;
    public static int[][] arr;
    public static int[][] air;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        air = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true){
            findAir();
            remove();
            answer++;
            if(isComplete()) break;
        }
        System.out.println(answer);

    }

    public static void remove() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 1){
                    int cnt = 0;

                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                        if(air[nr][nc] == 1) cnt++;
                    }
                    //삭제하자
                    if(cnt >= 2){
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    public static boolean isComplete(){
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static void findAir() {
        air = new int[N][M];
        int[] start = {0, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(start);
        air[0][0] = 1;
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            air[r][c] = 1;
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if (arr[nr][nc] == 0 && !visited[nr][nc]) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
