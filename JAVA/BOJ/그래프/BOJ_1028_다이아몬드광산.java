package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1028_다이아몬드광산 {
    static int R, C;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        int maxSize = (Math.min(R, C) - 1) / 2 + 1;
        int answer = 0;

        // size 1부터 있는지 탐색
        for (int k = 1; k <= maxSize; k++) {
            boolean find = false;
            // 0~2
            for (int i = 0; i <= R - (k * 2 - 1); i++) {
                for (int j = 0; j <= C - (k * 2 - 1); j++) {
                    if (isDiamond(k, i, j)) {
//                        System.out.println("size : " + k + " i : " + i + " j : " + j);
                        find = true;
                        answer = k;
                        break;
                    }
                }
                if (find) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isDiamond(int size, int r, int c) {
        // r, c 시작, k*2 - 1 범위만큼 탐색
        // i = 0 : 2
        // i = 1 : 1, 3
        // i = 2 : 0, 4
        // i = 3 : 1, 3
        // i = 4 : 2
        // start1 = i + size - 1, start1 = i + size - 1
        // start2 = start1 - 1, start2 = start1 + 1
        // start가 r 과 똑같으면 그 후엔 다시 +1, -1?

        if (size == 1) {
            if (arr[r][c] == 1) return true;
            else return false;
        }

        int cnt = 0;
        int A = c + size - 1, B = c + size - 1;

        if (arr[r][A] == 1) cnt++;
        if (arr[r + size * 2 - 2][A] == 1) cnt++;

        if(arr[r + size - 1][c] == 1 && arr[r + size -1][c + (size * 2 - 2)] == 1){
            cnt+=2;
        }else{
            return false;
        }

        if(size == 2){
            if(cnt == 4) return true;
            else return false;
        }

        for (int i = 1; i < size-1; i++) {
            A--;
            B++;
            if (arr[i + r][A] == 1 && arr[i + r][B] == 1 && arr[r + size * 2 - 2 - i][A] == 1 && arr[r + size * 2 - 2 - i][B] == 1) {
                cnt += 4;
            } else {
                return false;
            }
        }

        if (cnt == size * 4 - 4) return true;
        else return false;
    }
}
