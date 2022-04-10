package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197_백조의호수 {
    static int R, C, answer;
    static char[][] arr;
    static int[] L1, L2;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'L') {
                    if (L1 == null) L1 = new int[]{i, j};
                    else L2 = new int[]{i, j};
                }

                if (arr[i][j] != 'X') {
                    water.add(new int[]{i, j});

                }
            }
        }

        q.add(L1);
        visited[L1[0]][L1[1]] = true;

        boolean flag = false;
        while (true) {
            Queue<int[]> next = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];
                if (r == L2[0] && c == L2[1]) {
                    flag = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!validate(nr, nc) || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if (arr[nr][nc] == 'X') {
                        // 다음에 탐색할 얼음
                        next.add(new int[]{nr, nc});
                        continue;
                    }

                    q.add(new int[]{nr, nc});
                }
            }

            if (flag) break;
            q = next;

            // 얼음 녹이기, 녹인 얼음 다음 물 큐에 넣기
            int size = water.size();
//            System.out.println(size);
            for (int i = 0; i < size; i++) {
                int[] poll = water.poll();
                int r = poll[0];
                int c = poll[1];
                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (!validate(nr, nc)) continue;
                    if(arr[nr][nc] == 'X'){
                        water.add(new int[]{nr, nc});
                        arr[nr][nc] = '.';
                    }
                }
            }
//            print(arr);
            answer++;
        }
        System.out.println(answer);
        // 백조1이 있는 공간집합과 백조2가 있는 공간집합이 만나는 순간 정답
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean validate(int i, int j) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }

    public static char[][] copyArr(char[][] arr) {
        char[][] tmp = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }
}
