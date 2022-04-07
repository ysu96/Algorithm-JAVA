package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_토네이도 {
    public static int N, answer;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 : map[N/2][N/2]  -> [0][0] 까지
        int r = N / 2, c = N / 2;
        

        // 달팽이 구현

            // 1. 달팽이 움직일때마다 모래 이동 구현
            // 2. 모래가 밖으로 나갈때마다 answer +

        System.out.println(answer);
    }

    public static void moveSand(int r, int c){

    }
}
