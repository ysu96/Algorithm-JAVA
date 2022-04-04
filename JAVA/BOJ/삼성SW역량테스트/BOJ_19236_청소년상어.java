package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {
    static class Fish implements Comparable<Fish> {
        int r;
        int c;
        int num;
        int dir;

        Fish(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
        }

        @Override
        public int compareTo(Fish o) {
            return num - o.num;
        }
    }

    public static Fish[][] fishes = new Fish[4][4];
    public static PriorityQueue<Fish> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                fishes[i][j] = new Fish(i, j, num, dir);
                q.add(new Fish(i, j, num, dir));
            }
        }

        // 1. 상어가 먹기
        // 1-1. 상어가 갈 수 있는 위치 전부 보내보기 (백트래킹)
        // 2. 상어 먹을거 없으면 최대값 갱신

        // 3. 물고기들 순서대로 이동
        move();

        // 현재 물고기 큐 갱신?
        update();

    }

    public static void update(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(fishes[i][j].num == -1) continue;
                q.add(new Fish(i, j, fishes[i][j].num, fishes[i][j].dir));
            }
        }
    }
    public static void move(){
        while (!q.isEmpty()) {
            Fish poll = q.poll();
            //이동하기
        }
    }
}
