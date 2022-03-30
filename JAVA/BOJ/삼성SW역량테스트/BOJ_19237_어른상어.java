package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
    public static int N, M, K;
    public static int sharkCnt;
    public static int answer;
    public static Smell[][] map;
    public static Queue<Shark> sharks;

    //지도에 저장할 것
    // 상어 번호, 방향, 향기 남은 시간
    static class Smell {
        int shark;
        int dir;
        int time;

        Smell(int shark, int dir, int time) {
            this.shark = shark;
            this.dir = dir;
            this.time = time;
        }
    }

    static class Shark {
        int id;
        int r;
        int c;
        int dir;

        Shark(int id, int r, int c, int dir) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Smell[N][N];
        sharks = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            //격자
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    map[i][j] = new Smell(0, 0, 0);
                } else {
                    map[i][j] = new Smell(num, 0, 0);
                    sharkCnt++;
                    sharks.add(new Shark(num, i, j, 0));
                }
            }
        }

        // 상어 방향
        st = new StringTokenizer(br.readLine());
        int[] dirInput = new int[sharkCnt + 1];
        for (int k = 1; k <= sharkCnt; k++) {
            int dir = Integer.parseInt(st.nextToken());
            dirInput[k] = dir;
        }


        //각 상어의 방향 우선순위가 상어 당 4줄씩 차례대로 주어진다
        // ex ) priority[1][1][0] --> 1번 상어가 1(위쪽)을 향할때 방향의 우선순위 0번
        int[][][] priority = new int[sharkCnt + 1][5][4];
        for(int i=1; i<=sharkCnt; i++){
            //위 아래 왼쪽 오른쪽
            for(int j=1; j<=4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<4; k++){
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        while (true) {
            //1번 상어만 격자에 남았는지
            if(isComplete()) break;

            // 1000초가 넘었는데 다른 상어가 격자에 남아있는지
            if(answer > 1000){
                answer = -1;
                break;
            }

            //이동
            //move();
            //방향 업데이트
            //updateDir();
        }
    }

    public static boolean isComplete(){
        if(sharks.size() == 1){
            return true;
        }else{
            return false;
        }
    }
}
