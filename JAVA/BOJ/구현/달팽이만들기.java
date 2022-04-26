package JAVA.BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 달팽이만들기 {
    public static void main(String[] args) throws IOException {
        snail(10, false);

    }

    public static void snail(int N, boolean clockwise) {
        int[][] arr = new int[N][N];
        int[][][] dir = {{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}};
        int c = clockwise ? 0 : 1;
        int num = 1;
        int[][] snails = {{0,0,0}, {0, N-1,1}, {N-1, N-1,2}, {N-1, 0,3}};
        boolean flag = true;
        while(flag){
            flag = true;

            for(int i=0; i<4; i++){
                arr[snails[i][0]][snails[i][1]] = num;

                int nr = snails[i][0] + dir[c][snails[i][2]][0];
                int nc = snails[i][1] + dir[c][snails[i][2]][1];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0){
                    if(clockwise) snails[i][2] = (snails[i][2] + 1) % 4;
                    else snails[i][2] = (snails[i][2] + 3) % 4;
                }

                nr = snails[i][0] + dir[c][snails[i][2]][0];
                nc = snails[i][1] + dir[c][snails[i][2]][1];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0){
                    flag = false;
                    continue;
                }else{
                    snails[i][0] = nr;
                    snails[i][1] = nc;
                }
            }
            num++;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print("" + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
