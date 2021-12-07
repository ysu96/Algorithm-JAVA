package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17070 파이프 옮기기1 dfs
public class BOJ_17070 {
    public static int n,ans;
    public static int[][] arr;

    public static void dfs(int r1, int c1, int r2, int c2){
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
            if(r2+1<n && c2+1<n){
                if(arr[r2][c2+1]==0 && arr[r2+1][c2]==0 && arr[r2+1][c2+1]==0){
                    dfs(r2,c2,r2+1,c2+1);
                }
            }
        }
        //대각선으로 놓여져 있는 경우
        else{ //대각선
            //오른쪽으로 밀기
            if(c2+1 < n && arr[r2][c2+1] == 0){
                dfs(r2,c2, r2,c2+1);
            }
            //아래로 밀기
            if(r2+1<n && arr[r2+1][c2]==0){
                dfs(r2,c2,r2+1,c2);
            }
            //대각선으로 밀기
            if(r2+1<n && c2+1<n){
                if(arr[r2][c2+1]==0 && arr[r2+1][c2]==0 && arr[r2+1][c2+1]==0){
                    dfs(r2,c2,r2+1,c2+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,1);
        System.out.println(ans);
    }
}
