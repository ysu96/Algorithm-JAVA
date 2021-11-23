package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 , BFS
class Node {
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ_7576_BFS {
    public static int N,M;
    public static int[][] graph;
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {-1,1,0,0};
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        boolean first = true;
        int day = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0) first =false;
                if(tmp == 1) queue.add(new Node(i, j));
                graph[i][j] = tmp;
            }
        }

        if(first){
            System.out.println(0);
        }else{
            while(!queue.isEmpty()) {
                Node n = queue.poll();
                int x = n.x;
                int y = n.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dr[i];
                    int ny = y + dc[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (graph[nx][ny] == 0) {
                            // 옮기기 전 날 + 1
                            graph[nx][ny] = graph[x][y] + 1;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }

            //모두 익지 못하는 상황
            for(int i=0; i<N; i++) {
                for (int j = 0; j < M; j++) {
                    if(graph[i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, graph[i][j]);
                }
            }
            // 다익은 일수
            System.out.println(day-1);
        }
    }
}
