package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
    public static int N,M,x,y, K;
    public static int[][] map;
    public static int[] op;
    public static Dice dice;

    static class Dice{
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

        public void east(){
            int tmp = top;
            this.top = left;
            this.left = bottom;
            this.bottom = right;
            this.right = tmp;
        }

        public void west(){
            int tmp = top;
            this.top = right;
            this.right = bottom;
            this.bottom = left;
            this.left = tmp;
        }

        public void north(){
            int tmp = top;
            this.top = down;
            this.down = bottom;
            this.bottom = up;
            this.up = tmp;
        }

        public void south(){
            int tmp = top;
            this.top = up;
            this.up = bottom;
            this.bottom = down;
            this.down = tmp;
        }
    }

    public static void copy(int x, int y) {
        if(map[x][y] == 0){
            map[x][y] = dice.bottom;
        }else{
            dice.bottom = map[x][y];
            map[x][y] = 0;
        }
    }

    public static boolean check(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        op = new int[K];
        dice = new Dice(0, 0, 0, 0, 0, 0);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        for(int i=0; i<K; i++){
            int oper = op[i];
            if(!check(x + dx[oper], y + dy[oper])) continue;
            x += dx[oper];
            y += dy[oper];
            switch (oper) {
                case 1:
                    dice.east();
                    break;
                case 2:
                    dice.west();
                    break;
                case 3:
                    dice.north();
                    break;
                case 4:
                    dice.south();
                    break;
            }
            copy(x, y);
            System.out.println(dice.top);
        }
    }
}
