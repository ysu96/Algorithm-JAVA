package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20056_파이어볼 {
    public static int N, M, K;
    public static List<Fireball>[][] map;
    public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        Queue<Fireball> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Fireball(r - 1, c - 1, m, s, d));
        }

        while (K > 0) {
            map = new List[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            //이동
            while (!q.isEmpty()) {
                Fireball cur = q.poll();
                int nr = (cur.r + (dr[cur.d] * cur.s) + N*cur.s) % N;
                int nc = (cur.c + (dc[cur.d] * cur.s) + N*cur.s) % N;
                map[nr][nc].add(new Fireball(nr, nc, cur.m, cur.s, cur.d));
//                System.out.println("K : " + K + " nr : " + nr + " nc : " + nc);
            }

            //합체
            Queue<Fireball> left = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].size() > 1) {
                        Fireball first = map[i][j].get(0);
                        int sumM = first.m;
                        int sumS = first.s;
                        int cnt = map[i][j].size();
                        int sumD = 0;
                        if (first.d % 2 == 0) { //짝수 방향
                            sumD = 1;
                        }
                        boolean dirCheck = true;

                        for (int k = 1; k < map[i][j].size(); k++) {
                            Fireball cur = map[i][j].get(k);
                            if (cur.d % 2 == 0 && sumD == 0) dirCheck = false;
                            else if (cur.d % 2 != 0 && sumD == 1) dirCheck = false;
                            sumM += cur.m;
                            sumS += cur.s;
                        }

                        int newM = sumM / 5;
                        int newS = sumS / cnt;
                        int[] newD;
                        if (newM == 0) continue;

                        if (dirCheck) newD = new int[]{0, 2, 4, 6};
                        else newD = new int[]{1, 3, 5, 7};

                        for (int k = 0; k < 4; k++) {
                            left.add(new Fireball(i, j, newM, newS, newD[k]));
                        }
                    } else if (map[i][j].size() == 1) {
//                        System.out.println("r : " + i + "c : " + j);
                        Fireball cur = map[i][j].get(0);
                        left.add(new Fireball(cur.r, cur.c, cur.m, cur.s, cur.d));
                    }
                }
            }
            q = left;
//            System.out.println(q.size());
            K--;
        }

        //정답구하기
        int answer = 0;
        while (!q.isEmpty()) {
            Fireball poll = q.poll();
            answer += poll.m;
        }
        System.out.println(answer);
    }
}
