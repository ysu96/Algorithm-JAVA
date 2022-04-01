package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {
    public static int N, M, K;
    public static int answer;
    public static int[] sharkDir;
    public static Smell[][] map;
    public static Queue<Shark> sharks;
    public static int[][][] priority;
    public static int[] dr = {0, -1, 1, 0, 0};
    public static int[] dc = {0, 0, 0, -1, 1};


    //지도에 저장할 것
    // 상어 번호, 방향, 향기 남은 시간
    static class Smell {
        int shark;
        int time;

        Smell(int shark, int time) {
            this.shark = shark;
            this.time = time;
        }
    }

    static class Shark {
        int id;
        int r;
        int c;

        Shark(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
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
                    map[i][j] = new Smell(0, 0);
                } else {
                    map[i][j] = new Smell(num, K);
                    sharks.add(new Shark(num, i, j));
                }
            }
        }

        // 상어 방향
        st = new StringTokenizer(br.readLine());
        sharkDir = new int[M + 1];
        for (int k = 1; k <= M; k++) {
            int dir = Integer.parseInt(st.nextToken());
            sharkDir[k] = dir;
        }

        //각 상어의 방향 우선순위가 상어 당 4줄씩 차례대로 주어진다
        // ex ) priority[1][1][0] --> 1번 상어가 1(위쪽)을 향할때 방향의 우선순위 0번
        priority = new int[M + 1][5][4];
        for (int i = 1; i <= M; i++) {
            //위 아래 왼쪽 오른쪽
            //1, 2, 3, 4
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        while (true) {
            //1번 상어만 격자에 남았는지
            if (isComplete()) break;
//            printMap();
//            System.out.println();

            // 1000초가 넘었는데 다른 상어가 격자에 남아있는지
            if (answer >= 1000) {
                answer = -1;
                break;
            }

            //이동
            move();

            //냄새 숫자 줄이기
            reduceSmell();
            answer++;
        }
        System.out.println(answer);
    }

    public static void reduceSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j].time--;
                if (map[i][j].time <= 0) map[i][j].shark = 0;
            }
        }
    }

    //각 상어가 이동 방향을 결정할 때는, 먼저 인접한 칸 중 아무 냄새가 없는 칸의 방향으로 잡는다.
    // 그런 칸이 없으면 자신의 냄새가 있는 칸의 방향으로 잡는다. 이때 가능한 칸이 여러 개일 수 있는데, 그 경우에는 특정한 우선순위를 따른다.
    public static void move() {
        List<Shark> newSharks = new LinkedList<>();
        boolean[][] isShark = new boolean[N][N];

        while (!sharks.isEmpty()) {
            Shark shark = sharks.poll();
            int r = shark.r;
            int c = shark.c;
            int id = shark.id;
            int dir = sharkDir[id];
            // 인접 칸 중 아무냄새 없는 칸 구하기

            Queue<Shark> candidate1 = new LinkedList<>();
            Queue<Shark> candidate2 = new LinkedList<>();
            for (int i = 1; i <= 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                //여기선 id에 방향을 넣어줌
                if (map[nr][nc].time <= 0) candidate1.add(new Shark(i, nr, nc)); //빈 칸이 있으면
                else if (map[nr][nc].shark == id) candidate2.add(new Shark(i, nr, nc)); //자신의 냄새가 있는 칸의 방향으로 잡기
            }

            int first = 5;
            Queue<Shark> candidate = candidate1.size() != 0 ? candidate1 : candidate2;
            while (!candidate.isEmpty()) {
                Shark poll = candidate1.poll();
                for (int i = 0; i < 4; i++) {
                    int ndir = priority[id][dir][i];
                    if (poll.id == ndir) {
                        if (first > i) first = i;
                    }
                }
            }

            //이러고 priority[id][shark.dir][first]의 방향으로 가면 됨??
            int ndir = priority[id][dir][first];
            int nr = r + dr[ndir];
            int nc = c + dc[ndir];

            //옮기려는곳에 이미 상어가 이동해있으면
            if (isShark[nr][nc]) {
                for (Shark sk : newSharks) {
                    if (sk.r == nr && sk.c == nc) {
                        sk.id = Math.min(sk.id, id);
                        map[nr][nc].shark = sk.id;
                    }
                }
            } else {
                isShark[nr][nc] = true;
                newSharks.add(new Shark(id, nr, nc));
                map[nr][nc].shark = id;
            }

            //상어 방향 업데이트
            sharkDir[id] = ndir;
        }

        for (Shark s : newSharks) {
            map[s.r][s.c].time = K + 1;
        }

        sharks.addAll(newSharks);
    }

    public static boolean isComplete() {
        return sharks.size() == 1;
    }

    public static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("(" + map[i][j].shark + ", " + map[i][j].time + ") ");
            }
            System.out.println();
        }
    }
}
