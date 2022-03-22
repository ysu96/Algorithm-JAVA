package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288_주사위굴리기2 {

    public static int N, M, K;
    public static int[][] map;
    public static Dice dice;
    public static int[] dr = {0, -1, 0, 1};
    public static int[] dc = {1, 0, -1, 0};
    public static int answer;

    static class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static class Dice {
        int top;
        int bottom;
        int left; //옆면
        int right; //옆면
        int up;//옆면
        int down;//옆면

        Dice(int top, int bottom, int left, int right, int up, int down) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
        }

        public void east() {
            int tmp = top;
            this.top = left;
            this.left = bottom;
            this.bottom = right;
            this.right = tmp;
        }

        public void west() {
            int tmp = top;
            this.top = right;
            this.right = bottom;
            this.bottom = left;
            this.left = tmp;
        }

        public void north() {
            int tmp = top;
            this.top = down;
            this.down = bottom;
            this.bottom = up;
            this.up = tmp;
        }

        public void south() {
            int tmp = top;
            this.top = up;
            this.up = bottom;
            this.bottom = down;
            this.down = tmp;
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new Dice(1, 6, 4, 3, 2, 5);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = 0; //시작은 동쪽
        int r = 0, c = 0;

        //K번 이동
        for (int i = 0; i < K; i++) {
            if (!check(r + dr[dir], c + dc[dir])) {
                dir = (dir + 2) % 4;
            }

            r += dr[dir];
            c += dc[dir];

            // 점수획득 method ( r, c);
            int score = countScore(r, c);
            answer += score;

            switch (dir) {
                case 0:
                    dice.east();
                    break;
                case 1:
                    dice.north();
                    break;
                case 2:
                    dice.west();
                    break;
                case 3:
                    dice.south();
                    break;
            }

            // 다음 방향 정하기
            if (dice.bottom > map[r][c]) {
                //90 clockwise
                dir = (dir + 3) % 4;
            } else if (dice.bottom < map[r][c]) {
                // 90 counterclockwise
                dir = (dir + 1) % 4;
            }
        }

        System.out.println(answer);
    }

    public static void printDice(Dice dice){
        System.out.println("  " + dice.up + "  ");
        System.out.println(dice.left+ " " + dice.top + " " + dice.right);
        System.out.println("  " + dice.down + "  ");
        System.out.println("  " + dice.bottom + "  ");
    }

    public static int countScore(int r, int c){
        int num = map[r][c];
        int cnt = 1;

        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(!check(nr, nc)) continue;

                if(map[nr][nc] == num && !visited[nr][nc]){
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }
        return cnt * num;
    }
}
