package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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
    public static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] shark = {0, 0};
    public static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                fishes[i][j] = new Fish(i, j, num, dir);
                q.add(new Fish(i, j, num, dir));
            }
        }

        moveShark(0, fishes, shark, q);
        System.out.println(score);
    }

    public static void print(Fish[][] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Fish f = arr[i][j];
                System.out.print("(" + f.num + "," + f.dir + ") ");
            }
            System.out.println();
        }
    }

    public static void moveShark(int sum, Fish[][] arr2, int[] shark, PriorityQueue<Fish> pq) {
        Fish[][] arr = copyArr(arr2);

        // 1. 상어가 먹기
        sum += arr[shark[0]][shark[1]].num;
        arr[shark[0]][shark[1]].num = -1;

        // 현재 물고기 큐 갱신
        pq = update(arr);

        // 2. 물고기들 순서대로 이동
        arr = move(arr, pq, shark);

//        print(arr);

        // 3. 상어 이동
        int sr = shark[0];
        int sc = shark[1];
        int sdir = arr[shark[0]][shark[1]].dir;
        int cnt = 0;

        while (true) {
            int nsr = sr + dr[sdir];
            int nsc = sc + dc[sdir];
            if (nsr < 0 || nsr >= 4 || nsc < 0 || nsc >= 4) break;
            if (arr[nsr][nsc].num != -1) {
                shark[0] = nsr;
                shark[1] = nsc;
                cnt++;

                moveShark(sum, arr, shark, pq);
            }
            sr = nsr;
            sc = nsc;
        }

        // 먹을거 없음
        if (cnt == 0) {
            score = Math.max(score, sum);
        }
    }

    public static Fish[][] copyArr(Fish[][] arr){
        Fish[][] tmp = new Fish[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                tmp[i][j] = new Fish(i, j, arr[i][j].num, arr[i][j].dir);
            }
        }
        return tmp;
    }

    public static PriorityQueue<Fish> update(Fish[][] arr) {
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j].num == -1) continue;
                pq.add(new Fish(i, j, arr[i][j].num, arr[i][j].dir));
            }
        }
        return pq;
    }

    public static Fish[][] move(Fish[][] arr, PriorityQueue<Fish> pq, int[] shark) {
        Fish[][] tmp = copyArr(arr);

        while (!pq.isEmpty()) {
            Fish poll = pq.poll();
            int num = poll.num;
            int r = 0, c = 0, dir = 0, cnt = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (tmp[i][j].num == num) {
                        r = i;
                        c = j;
                        dir = tmp[i][j].dir;
                        break;
                    }
                }
            }

            while (true) {
                if (cnt == 8) break; //이동할 칸 없음

                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr >= 0 && nc >= 0 && nr < 4 && nc < 4 && !(nr == shark[0] && nc == shark[1])) {
                    tmp[r][c] = new Fish(r, c, tmp[nr][nc].num, tmp[nr][nc].dir);
                    tmp[nr][nc] = new Fish(nr, nc, num, dir);
                    break;
                } else {
                    dir = dir + 1 == 9 ? 1 : dir + 1;
                }
                cnt++;
            }
        }
        return tmp;
    }
}
