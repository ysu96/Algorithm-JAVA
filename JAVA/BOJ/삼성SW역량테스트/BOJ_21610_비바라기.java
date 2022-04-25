package JAVA.BOJ.삼성SW역량테스트;
import java.io.*;
import java.util.*;

public class BOJ_21610_비바라기 {
    static int N, M, answer;
    static int[][] arr, magic;
    static Queue<int[]> clouds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        magic = new int[M][2];
        clouds = new LinkedList<int[]>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            magic[i][0] = Integer.parseInt(st.nextToken());
            magic[i][1] = Integer.parseInt(st.nextToken());
        }

        // 구름 생성
        create();

        for (int[] m : magic) {
            int d = m[0];
            int s = m[1];
            move(d, s);
            copyBug();
            createAndReduce();
        }

        calculate();
        System.out.println(answer);
    }

    public static void create() {
        clouds.add(new int[] { N, 1 });
        clouds.add(new int[] { N, 2 });
        clouds.add(new int[] { N - 1, 1 });
        clouds.add(new int[] { N - 1, 2 });
    }

    public static void move(int d, int s) {
        int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
        int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
        Queue<int[]> tmp = new LinkedList<int[]>();
        while (!clouds.isEmpty()) {
            int[] c = clouds.poll();
            int nr = (c[0] + dr[d] * s - 1 + N*50) % N + 1;
            int nc = (c[1] + dc[d] * s - 1 + N*50) % N + 1;
            tmp.add(new int[] { nr, nc });
            arr[nr][nc]++;
        }
        clouds = tmp;
    }

    public static void copyBug() {
        int[] dr = { -1, -1, 1, 1};
        int[] dc = { -1, 1, -1, 1};
        for(int i=0; i<clouds.size(); i++) {
            int[] c = clouds.poll();
            int sum = 0;
            for(int j=0; j<4; j++) {
                int nr = c[0] + dr[j];
                int nc = c[1] + dc[j];
                if(nr < 1 || nc < 1 || nr > N || nc > N || arr[nr][nc] <= 0) continue;
                sum++;
            }
            arr[c[0]][c[1]] += sum;
            clouds.add(c);
        }
    }

    public static void createAndReduce() {
        boolean[][] check = new boolean[N+1][N+1];
        while(!clouds.isEmpty()) {
            int[] c = clouds.poll();
            check[c[0]][c[1]] = true;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(arr[i][j] >= 2 && !check[i][j]) {
                    clouds.add(new int[] {i,j});
                    arr[i][j] -= 2;
                }
            }
        }
    }

    public static void calculate() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                answer += arr[i][j];
            }
        }
    }
}

