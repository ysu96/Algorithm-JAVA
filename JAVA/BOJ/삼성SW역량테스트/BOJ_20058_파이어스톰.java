package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_파이어스톰 {
    public static int N, Q, L;
    public static int[][] map;
    public static int[] level;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sum, cell;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        level = new int[Q];
        N = (int) Math.pow(2, N);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < Q; q++) {
            L = (int) Math.pow(2, level[q]);
            rotate(); // L 간격으로 90도 시계방향 회전
//            print(map);
//            System.out.println();
            reduceIce();// 인접 확인, 얼음 줄이기
//            print(map);
        }

        // 남은 얼음 합 구하기
        // 가장 큰 덩어리 칸 개수 구하기
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum += map[i][j];
                if(!visited[i][j] && map[i][j] > 0){
                    cell = Math.max(cell, bfs(i, j));
                }
            }
        }

        System.out.println(sum);
        System.out.println(cell);
    }

    public static int bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];

            for(int k=0; k<4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(!visited[nr][nc] && map[nr][nc] > 0){
                    count++;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return count;
    }

    public static void reduceIce(){
        int[][] tmp = deepCopy(map);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(tmp[i][j] == 0) continue;

                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(map[nr][nc] > 0) cnt++;
                }

                if(cnt < 3){
                    tmp[i][j]--;
                }
            }
        }
        map = tmp;
    }

    public static void rotate() {
        for (int i = 0; i < N; i += L) {
            for (int j = 0; j < N; j += L) {
                // i ~ i+L-1 , j ~ j+L-1 회전하기
                rotatePart(i, j);
//                print(map);
//                System.out.println();
            }
        }
    }

    public static void rotatePart(int r, int c) {
        int[][] tmp = new int[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                tmp[i][j] = map[r+L-1-j][c+i];
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                map[r+i][c+j] = tmp[i][j];
            }
        }
    }

    public static int[][] deepCopy(int[][] map) {
        int[][] tmp = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    public static void print(int[][] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
