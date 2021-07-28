package 최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int x;
    int y;
    int distance;

    Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if(distance < o.distance) return -1;
        else return 1;
    }
}
public class NDB_17_3화성탐사 {
    private static int T, N;
    private static int[][] map;
    private static int[][] dist;
    private static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                Arrays.fill(dist[i], INF);
            }

            int x=0, y=0;
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(x,y,map[x][y]));
            dist[x][y] = map[x][y];

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int cx = cur.x;
                int cy = cur.y;
                int cdist = cur.distance;
                if(dist[cx][cy] < cdist) continue;

                for(int i=0; i<4; i++){
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];
                    if(nx>=N || nx<0 || ny>=N || ny<0) continue;

                    if(cdist+map[nx][ny] < dist[nx][ny]){
                        pq.add(new Node(nx,ny, cdist+map[nx][ny]));
                        dist[nx][ny] = cdist+map[nx][ny];
                    }
                }
            }
            System.out.println(dist[N-1][N-1]);
        }
    }
}
