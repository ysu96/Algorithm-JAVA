package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상범 빌딩
class Loc{
    int r;
    int c;
    int l;
    int time;
    Loc(int r, int c, int l, int time){
        this.r = r;
        this.c = c;
        this.l = l;
        this.time = time;
    }
}
public class BOJ_6593_BFS {
    public static int L,R,C;
    public static int[][][] arr;
    public static boolean[][][] visited;
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static int[] dl = {-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) break;
            arr = new int[L][R][C];
            visited = new boolean[L][R][C];
            Loc start = null;
            for(int l = 0; l<L; l++){
                for(int i=0; i<R; i++){
                    String line = br.readLine();
                    for(int j=0; j<C; j++){
                        switch (line.charAt(j)){
                            case 'S':
                                arr[l][i][j] = 2; //start
                                start = new Loc(i,j,l,0);
                                break;
                            case 'E':
                                arr[l][i][j] = 3; //end;
                                break;
                            case '#':
                                arr[l][i][j] = 1; //block;
                                break;
                            case '.':
                                arr[l][i][j] = 0; //empty
                        }
                    }
                }
                br.readLine();
            }

            Queue<Loc> queue = new LinkedList<>();
            queue.add(start);
            boolean escape = false;
            while (!queue.isEmpty()) {
                Loc now = queue.poll();
                visited[now.l][now.r][now.c] = true;
                if(arr[now.l][now.r][now.c] == 3){
                    System.out.println("Escaped in "+now.time+" minute(s).");
                    escape = true;
                    break;
                }
                for(int i=0; i<4; i++){
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    int nl = now.l;
                    if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                    if(!visited[nl][nr][nc] && arr[nl][nr][nc] != 1){
                        visited[nl][nr][nc] = true;
                        queue.add(new Loc(nr,nc,nl, now.time+1));
                    }
                }
                for(int i=0; i<2; i++){
                    int nl = now.l + dl[i];
                    int nr = now.r;
                    int nc = now.c;
                    if(nl<0 || nl>=L) continue;
                    if(!visited[nl][nr][nc] && arr[nl][nr][nc] != 1){
                        visited[nl][nr][nc] = true;
                        queue.add(new Loc(nr,nc,nl,now.time+1));
                    }
                }
            }
            if(!escape) System.out.println("Trapped!");

        }
    }
}
