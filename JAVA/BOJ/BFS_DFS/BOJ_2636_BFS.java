package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_BFS {
    public static int R,C;
    public static int[][] arr;
    public static boolean[][] visited;

    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int chzs = 0;
        while(!clear(arr)){
            int tmp = 0;
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(arr[i][j] == 1){
                        tmp++;
                    }
                }
            }
            chzs = tmp;

            visited = new boolean[R][C];
            isC(0,0);

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(arr[i][j] == -1){
                        arr[i][j] = 0;
                    }
                }
            }
            time++;

        }
        System.out.println(time);
        System.out.println(chzs);
    }

    public static void isC(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(visited[nr][nc]) continue;

                if (arr[nr][nc] == 0){
                    queue.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
                else if (arr[nr][nc] == 1){
                    arr[nr][nc] = -1;
                }
            }
        }
    }
    public static boolean clear(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] != 0) return false;
            }
        }
        return true;
    }
}
