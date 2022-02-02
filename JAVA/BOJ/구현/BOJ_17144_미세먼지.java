package JAVA.BOJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지 {
    public static int R, C, T;
    public static int[][] arr;
    public static int[] dr = {0, 0, -1, 1};
    public static int[] dc = {-1, 1, 0, 0};
    public static int a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    a = i;
                }
            }
        }

        int[][] arrCopy = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arrCopy[i][j] = arr[i][j];
            }
        }

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] == -1) continue;
                    arrCopy[i][j] = diffusion(arr, i, j);
                }
            }
            arrCopy = air(arrCopy);

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] = arrCopy[i][j];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arrCopy[i][j] > 0) sum += arrCopy[i][j];
            }
        }
        System.out.println(sum);
    }

    public static int diffusion(int[][] arrCopy, int r, int c) {
        int tmp = 0;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (arrCopy[nr][nc] == -1) continue;
            cnt++;
            if (arrCopy[nr][nc] < 5) continue;
            else tmp += arrCopy[nr][nc] / 5;

        }

        return arrCopy[r][c] - ((arrCopy[r][c] / 5) * cnt) + tmp;
    }

    public static int[][] air(int[][] arr) {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        int a1 = a - 1;
        int a2 = a;

        //위쪽
        tmp[a1][1] = 0;
        for (int i = 2; i < C; i++) {
            tmp[a1][i] = arr[a1][i - 1];
        }
        for (int i = a1 - 1; i >= 0; i--) {
            tmp[i][C - 1] = arr[i + 1][C - 1];
        }
        for (int i = C - 2; i >= 0; i--) {
            tmp[0][i] = arr[0][i + 1];
        }
        for (int i = 1; i < a1; i++) {
            tmp[i][0] = arr[i - 1][0];
        }

        //아래쪽
        tmp[a2][1] = 0;
        for (int i = 2; i < C; i++) {
            tmp[a2][i] = arr[a2][i - 1];
        }
        for (int i = a2 + 1; i < R; i++) {
            tmp[i][C - 1] = arr[i - 1][C - 1];
        }
        for (int i = C - 2; i >= 0; i--) {
            tmp[R - 1][i] = arr[R - 1][i + 1];
        }
        for (int i = R - 2; i > a2; i--) {
            tmp[i][0] = arr[i + 1][0];
        }

        return tmp;
    }

    public static void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
