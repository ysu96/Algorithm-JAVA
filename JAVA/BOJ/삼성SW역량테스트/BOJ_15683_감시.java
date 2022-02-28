package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
    public static int N, M, answer;
    public static int[][] arr;
    public static List<CCTV> cctvs = new ArrayList<>();

    static class CCTV {
        int x;
        int y;
        int type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());

                arr[i][j] = num;
                if (num > 0 && num < 6) {
                    cctvs.add(new CCTV(i, j, num));
                }
            }
        }
        if (cctvs.size() == 0) {
            answer = getArea(arr);
        } else {
            rotate(0, arr);
        }
        System.out.println(answer);
    }

    public static void print(int[][] room){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int idx, int[][] room) {
        if (idx == cctvs.size()) {
            answer = Math.min(answer, getArea(room));
//            print(room);
            return;
        }

        CCTV cur = cctvs.get(idx);
        switch (cur.type) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    int[][] copy = rotate1(cur, room, i);
                    rotate(idx + 1, copy);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    int[][] copy = rotate2(cur, room, i);
                    rotate(idx + 1, copy);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    int[][] copy = rotate3(cur, room, i);
                    rotate(idx + 1, copy);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    int[][] copy = rotate4(cur, room, i);
                    rotate(idx + 1, copy);
                }
                break;
            case 5:
                int[][] copy = rotate5(cur, room);
                rotate(idx + 1, copy);

        }
    }

    public static int[][] rotate5(CCTV cur, int[][] room) {
        int[][] copy = getCopy(room);
        copy = up(copy, cur);
        copy = down(copy, cur);
        copy = left(copy, cur);
        copy = right(copy, cur);
        return copy;
    }

    public static int[][] rotate4(CCTV cur, int[][] room, int dir) {
        // dir = 0 (위), 1(오른), 2(아래), 3(왼)
        int[][] copy = getCopy(room);

        if (dir == 0) {
            copy = left(copy, cur);
            copy = up(copy, cur);
            copy = right(copy, cur);

        } else if (dir == 1) {
            copy = up(copy, cur);
            copy = right(copy, cur);
            copy = down(copy, cur);
        } else if (dir == 2) {
            copy = right(copy, cur);
            copy = down(copy, cur);
            copy = left(copy, cur);
        } else {
            copy = down(copy, cur);
            copy = left(copy, cur);
            copy = up(copy, cur);
        }
        return copy;
    }

    public static int[][] rotate3(CCTV cur, int[][] room, int dir) {
        // dir = 0 (ㄴ), 1(아래 오른쪽), 2(ㄱ), 3(왼쪽 , 위)
        int[][] copy = getCopy(room);

        if (dir == 0) {
            copy = up(copy, cur);
            copy = right(copy, cur);
        } else if (dir == 1) {
            copy = right(copy, cur);
            copy = down(copy, cur);
        } else if (dir == 2) {
            copy = down(copy, cur);
            copy = left(copy, cur);
        } else {
            copy = left(copy, cur);
            copy = up(copy, cur);
        }
        return copy;
    }

    public static int[][] rotate2(CCTV cur, int[][] room, int dir) {
        // dir = 0 (가로), 1(세로)
        int[][] copy = getCopy(room);

        if (dir == 0) {
            copy = left(copy, cur);
            copy = right(copy, cur);
        } else {
            copy = up(copy, cur);
            copy = down(copy, cur);
        }
        return copy;
    }

    public static int[][] rotate1(CCTV cur, int[][] room, int dir) {
        // dir = 0 (위), 1(오른쪽), 2(아래), 3(왼쪽)
        int[][] copy = getCopy(room);

        if (dir == 0) {
            copy = up(copy, cur);
        } else if (dir == 1) {
            copy = right(copy, cur);
        } else if (dir == 2) {
            copy = down(copy, cur);
        } else {
            copy = left(copy, cur);
        }
        return copy;
    }

    public static int getArea(int[][] room) {
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 0) tmp++;
            }
        }
        return tmp;
    }

    public static int[][] up(int[][] room, CCTV cur){
        int[][] copy = getCopy(room);
        for (int i = cur.x - 1; i >= 0; i--) {
            if (copy[i][cur.y] == 0) copy[i][cur.y] = -1;
            else if (copy[i][cur.y] == 6) break;
            else continue;
        }
        return copy;
    }

    public static int[][] down(int[][] room, CCTV cur){
        int[][] copy = getCopy(room);
        for (int i = cur.x + 1; i < N; i++) {
            if (copy[i][cur.y] == 0) copy[i][cur.y] = -1;
            else if (copy[i][cur.y] == 6) break;
            else continue;
        }
        return copy;
    }

    public static int[][] left(int[][] room, CCTV cur){
        int[][] copy = getCopy(room);
        for (int i = cur.y - 1; i >= 0; i--) {
            if (copy[cur.x][i] == 0) copy[cur.x][i] = -1;
            else if (copy[cur.x][i] == 6) break;
            else continue;
        }
        return copy;
    }

    public static int[][] right(int[][] room, CCTV cur){
        int[][] copy = getCopy(room);
        for (int i = cur.y + 1; i < M; i++) {
            if (copy[cur.x][i] == 0) copy[cur.x][i] = -1;
            else if (copy[cur.x][i] == 6) break;
            else continue;
        }
        return copy;
    }

    public static int[][] getCopy(int[][] room){
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = room[i][j];
            }
        }
        return copy;
    }
}
