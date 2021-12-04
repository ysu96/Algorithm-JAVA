package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2589 보물섬
//가장 최단거리가 긴 두 육지(L) 찾아서 그 거리 출력
// BFS를 모든 점에서 돌려서 최장거리 출력
class Bomul{
    int r;
    int c;
    Bomul(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class BOJ_2589_BFS {
    public static int n,m;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,-1,1};
    public static Queue<Bomul> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                if(line.charAt(j) == 'W'){ // 바다
                    arr[i][j] = 0;
                }else{ // 육지
                    arr[i][j] = 1;
                }
            }
        }
        int[][] tmp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[i][j] = arr[i][j];
            }
        }
        int max = 0;
        queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(arr[i][j] != 0){ //육지면
                    visited = new boolean[n][m];
                    queue.add(new Bomul(i,j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()){
                        Bomul now = queue.poll();

                        for(int z=0; z<4; z++){
                            int nr = now.r + dr[z];
                            int nc = now.c + dc[z];
                            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                            if(arr[nr][nc] != 0 && !visited[nr][nc]){
                                visited[nr][nc] = true;
                                tmp[nr][nc] = tmp[now.r][now.c]+1;
                                max = Math.max(max, tmp[nr][nc]);
                                queue.add(new Bomul(nr, nc));
                            }
                        }
                    }
                }
                for(int ii=0; ii<n; ii++){
                    for(int jj=0; jj<m; jj++){
                        tmp[ii][jj] = arr[ii][jj];
                        //System.out.print(tmp[ii][jj]);
                    }
                    //System.out.println();
                }

            }
        }
        System.out.println(max-1);
    }
}
