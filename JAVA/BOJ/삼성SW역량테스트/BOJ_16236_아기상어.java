package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236_아기상어 {
    public static int N, answer;
    public static int[][] arr;
    public static boolean[][] visited;

    public static Loc shark;
    public static int size = 2;
    public static int eaten = 0;

    public static ArrayList<Loc> list = new ArrayList<>();
    public static int[] dr = {-1, 0, 0, 1};
    public static int[] dc = {0, -1, 1, 0};

    static class Loc {
        int r, c, time;

        Loc(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Loc(i, j, 0);
                    arr[i][j] = 0;
                }
            }
        }

        simulation();
        System.out.println(answer);
    }

    public static void simulation() {
        Queue<Loc> q = new LinkedList<>();
        q.add(shark);
        visited[shark.r][shark.c] = true;

        while(true){
            while(!q.isEmpty()){
                Loc cur = q.poll();
                int time = cur.time;

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (!validation(nr, nc)) continue;
                    if (visited[nr][nc]) continue;

                    if(arr[nr][nc] < size && arr[nr][nc] != 0){
                        q.add(new Loc(nr, nc, time + 1));
                        visited[nr][nc] = true;
                        list.add(new Loc(nr, nc, time + 1));
                    }

                    if(arr[nr][nc] == size || arr[nr][nc] == 0){
                        q.add(new Loc(nr, nc, time + 1));
                        visited[nr][nc] = true;
                    }
                }
            }

            if (!list.isEmpty()) {
                eat();
                q.clear();
                visited = new boolean[N][N];
                q.add(shark);
                visited[shark.r][shark.c] = true;
            }else{
                return;
            }
        }
    }

    public static void eat(){
        Collections.sort(list, new Comparator<Loc>() {
            @Override
            public int compare(Loc o1, Loc o2) {
                if(o1.time == o2.time){
                    if(o1.r == o2.r){
                        if(o1.c > o2.c) return 1;
                        else return -1;
                    }else{
                        if(o1.r > o2.r) return 1;
                        else return -1;
                    }
                } else if (o1.time > o2.time) {
                    return 1;
                } else{
                    return -1;
                }
            }
        });

        Loc cur = list.get(0);
        shark.r = cur.r;
        shark.c = cur.c;
        eaten++;
        if(eaten == size){
            eaten = 0;
            size++;
        }

        answer += cur.time;
        arr[cur.r][cur.c] = 0;
        list.clear();
    }

    public static boolean validation(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
