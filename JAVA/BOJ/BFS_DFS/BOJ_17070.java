package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pipe {
    int r1,r2,c1,c2;
    Pipe(int r1, int c1, int r2, int c2){
        this.r1 = r1;
        this.c1 = c1;
        this.r2 = r2;
        this.c2 = c2;
    }
}

public class BOJ_17070 {
    public static int n,ans;
    public static int[][] arr, visited;
    public static Stack<Pipe> pipes = new Stack<>();
    public static void dfs(int r1, int c1, int r2, int c2){
        pipes.add(new Pipe(r1,c1,r2,c2));
        if(r2==n-1 && c2==n-1){
            ans++;
            return;
        }
        //가로로 놓여져 있는 경우
        if(r1 == r2){ //가로
            //오른쪽으로 밀기
            if(c2+1<n && arr[r2][c2+1] ==0){ //오른쪽이 벽이 아니면?
                dfs(r2,c2,r2,c2+1);
            }
            //대각선 아래로 밀기
            if(r2+1<n && c2+1<n){
                if(arr[r2][c2+1]==0 && arr[r2+1][c2]==0 && arr[r2+1][c2+1]==0){
                    dfs(r2,c2,r2+1,c2+1);
                }
            }
        }
        //세로로 놓여져 있는 경우
        else if(c1 == c2){ //세로
            //아래로 밀기
            if(r2+1<n && arr[r2+1][c2] ==0){
                dfs(r2,c2,r2+1,c2);
            }
            //대각선 아래로 밀기

        }
        //대각선으로 놓여져 있는 경우
        else{ //대각선
            //오른쪽으로 밀기
            //아래로 밀기
        }
        // 오른쪽으로 밀기
        //가로
        if(r1 == r2){ //가로
            //오른쪽이 벽이 아니면?
            //재귀?
            if(c2+1<n && arr[r2][c2+1] !=0){
                dfs(r2,c2,r2,c2+1);
            }
        }
        else if(c1 == c2){ //세로
            if(c2+1<n && arr[r2][c2+1] !=0){
                dfs(r2,c2,r2,c2+1);
            }
        }
        else{ //대각선

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,1);

    }
}
