package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고 : https://alwaysbemoon.tistory.com/225
public class BOJ_20057_토네이도 {
    public static int N, answer;
    public static int[][] map;
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {-1, 0, 1, 0};
    public static int dir;
    public static int move = 1; // 방향 두번 꺾을때마다 이동횟수 1 증가


    static int[][] dsr = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsc = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1,1,2,7,7,2,10,10,5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado();
        System.out.println(answer);
    }

    public static void tornado() {
        // 시작 : map[N/2][N/2]  -> [0][0] 까지
        int r = N / 2, c = N / 2;

        while (true) {
            for (int i = 0; i < 2; i++) { //두 번 꺾기
                for (int j = 0; j < move; j++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        return;
                    }
                    moveSand(nr, nc);
                    r = nr;
                    c = nc;
                }
                dir = (dir + 1) % 4; // 방향 바꾸기
            }

            move++; // 이동 횟수 증가
        }
    }

    // 1. 달팽이 움직일때마다 모래 이동 구현
    // 2. 모래가 밖으로 나갈때마다 answer +
    public static void moveSand(int r, int c) {
        int y = map[r][c];
        int left = y;
        map[r][c] = 0;
        for(int i=0; i<9; i++){
            int nsr = r + dsr[dir][i];
            int nsc = c + dsc[dir][i];
            int sand = (y * sandRatio[i]) / 100;
            if(!validate(nsr, nsc)) answer += sand;
            else map[nsr][nsc] += sand;
            left -= sand;
        }

        //알파 계산
        int ar = r + dr[dir];
        int ac = c + dc[dir];
        if(!validate(ar,ac)) answer += left;
        else map[ar][ac] += left;
    }

    public static boolean validate(int r, int c){
        return (r>=0 && r<N && c>=0 && c<N);
    }
}
