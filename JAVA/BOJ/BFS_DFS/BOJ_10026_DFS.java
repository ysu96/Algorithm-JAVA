package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10026_DFS {
    public static int n;
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,1,-1};

    public static void dfs(int r, int c, boolean check){
        visited[r][c] = true;
        char now = arr[r][c];
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                if(!check){
                    if(now == arr[nr][nc]){
                        dfs(nr,nc,check);
                    }
                }else{
                    if(now == 'R' || now == 'G'){
                       if(arr[nr][nc] == 'R' || arr[nr][nc] == 'G'){
                           dfs(nr,nc,check);
                       }
                    }else{
                        if(now == arr[nr][nc]){
                            dfs(nr,nc,check);
                        }
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        int normal = 0;
        int unnormal = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j,false);
                    normal++;
                }
            }
        }
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j,true);
                    unnormal++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(normal).append(' ').append(unnormal);
        System.out.println(sb);

    }
}
