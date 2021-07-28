package 알고리즘기초;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//************************ N-Queens ***************************

public class B9663_NQueen {
    private static int n;
    private static int ans;
    private static int[][] chess = new int[14][14];

    public static void recur(int line){
        if(line == n){
            ans++;
            return;
        }

        //line어딘가에 퀸을 놓아본다
        for(int i=0; i<n;i++){
            if(chess[line][i] != -1) continue;
            chess[line][i] = line;
            //line에 놓았으니 (상)하좌우 대각선에 퀸 못놓게 처리

            //좌우
            for(int x=0; x<n; x++){
                if(chess[line][x] == -1)
                    chess[line][x] = line;
            }

            //하
            for(int y=line; y<n; y++){
                if(chess[y][i] == -1)
                    chess[y][i] = line;
            }

            //대각선 (왼쪽)
            for(int y=line, x = i; y<n && 0<=x; y++,x--){
                if(chess[y][x] == -1)
                    chess[y][x] = line;
            }
            //대각선 (오른쪽)
            for(int y=line, x = i; y<n && x<n; y++,x++){
                if(chess[y][x] == -1)
                    chess[y][x] = line;
            }

            //다음 줄 퀸을 놓음
            recur(line+1);


            //지금 퀸이 처리한 흔적을 지움
            //좌우
            for(int x=0; x<n; x++){
                if(chess[line][x] == line)
                    chess[line][x] = -1;
            }

            //하
            for(int y=line; y<n; y++){
                if(chess[y][i] == line)
                    chess[y][i] = -1;
            }

            //대각선 (왼쪽)
            for(int y=line, x = i; y<n && 0<=x; y++,x--){
                if(chess[y][x] == line)
                    chess[y][x] = -1;
            }
            //대각선 (오른쪽)
            for(int y=line, x = i; y<n && x<n; y++,x++){
                if(chess[y][x] == line)
                    chess[y][x] = -1;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i=0; i<14; i++){
            for(int j=0; j<14; j++){
                chess[i][j] = -1;
            }
        }
        recur(0);
        System.out.println(ans);
    }
}
