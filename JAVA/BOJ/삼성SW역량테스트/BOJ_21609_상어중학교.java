package JAVA.BOJ.삼성SW역량테스트;
import java.util.*;
import java.io.*;

public class BOJ_21609_상어중학교 {
    static int N, M, score;
    static int[][] arr;
    static BlockGroup curGroup;
    static Queue<BlockGroup> groupQueue;

    static class BlockGroup {
        int size;
        Queue<Block> blocks = new LinkedList<>();
        int rainbow;
        Block standard;
    }

    static class Block {
        int r;
        int c;
        int color;

        Block(int r, int c, int color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createGroup();

        while (isGroupExist()) {
            curGroup = findGroup();
            deleteGroup();
            gravity();
            rotate();
            gravity();
            createGroup();
        }

        System.out.println(score);
    }

    public static boolean isGroupExist() {
        if (groupQueue.size() != 0)
            return true;
        return false;
    }

    public static void createGroup() {
        groupQueue = new LinkedList<BlockGroup>();
        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] >= 1) {

                    BlockGroup bg = new BlockGroup();
                    bg.standard = new Block(i, j, arr[i][j]);
                    bg.blocks.add(bg.standard);

                    visited[i][j] = true;

                    Queue<Block> q = new LinkedList<>();
                    Queue<Block> rainbowTmp = new LinkedList<>();
                    q.add(bg.standard);
                    while (!q.isEmpty()) {
                        Block b = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = b.r + dr[k];
                            int nc = b.c + dc[k];
                            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
                                continue;

                            if (arr[nr][nc] == bg.standard.color) {
                                visited[nr][nc] = true;
                                q.add(new Block(nr, nc, arr[nr][nc]));
                                bg.blocks.add(new Block(nr, nc, arr[nr][nc]));
                                continue;
                            }

                            if (arr[nr][nc] == 0) {
                                visited[nr][nc] = true;
                                bg.rainbow++;
                                q.add(new Block(nr, nc, 0));
                                bg.blocks.add(new Block(nr, nc, 0));
                                rainbowTmp.add(new Block(nr, nc, 0));
                            }

                        }
                    }
                    bg.size = bg.blocks.size();
                    if (bg.size < 2)
                        continue;
                    if (bg.size - bg.rainbow == 0)
                        continue;
                    groupQueue.add(bg);

                    while(!rainbowTmp.isEmpty()) {
                        Block rb = rainbowTmp.poll();
                        visited[rb.r][rb.c] = false;
                    }
                }
            }
        }

    }

    public static BlockGroup findGroup() {
        BlockGroup tmp = groupQueue.poll();

        while (!groupQueue.isEmpty()) {
            BlockGroup bg = groupQueue.poll();
            if (tmp.size < bg.size) {
                tmp = bg;
                continue;
            }

            if (tmp.size == bg.size) {
                if (tmp.rainbow < bg.rainbow) {
                    tmp = bg;
                } else if (tmp.rainbow == bg.rainbow) {
                    if (tmp.standard.r < bg.standard.r) {
                        tmp = bg;
                    } else if (tmp.standard.r == bg.standard.r) {
                        if (tmp.standard.c < bg.standard.c) {
                            tmp = bg;
                        }
                    }
                }
            }
        }

        return tmp;
    }

    public static void deleteGroup() {
        score += curGroup.size * curGroup.size;
        Queue<Block> q = curGroup.blocks;
        while (!q.isEmpty()) {
            Block b = q.poll();
            arr[b.r][b.c] = -2;
        }
    }

    public static void gravity() {
        // 검은색 블록을 제외한 모든 블록이 행의 번호가 큰 칸으로 이동한다. 이동은 다른 블록이나 격자의 경계를 만나기 전까지.
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == -2) {
                    int r = i;
                    int c = j;
                    while (r >= 0 && r < N) {
                        if (arr[r][c] == -1)
                            break;
                        if (arr[r][c] >= 0) {
                            arr[i][j] = arr[r][c];
                            arr[r][c] = -2;
                            break;
                        }
                        r--;
                    }
                }
            }
        }
    }

    public static void rotate() {
        // 반시계 방향 회전
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[N - 1 - j][i] = arr[i][j];
            }
        }
        arr = tmp;
    }
}
