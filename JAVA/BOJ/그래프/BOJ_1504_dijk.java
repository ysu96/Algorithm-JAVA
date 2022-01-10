package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//다익스트라
class Node1504{
    int x;
    int dist;

    Node1504(int x, int dist) {
        this.x = x;
        this.dist = dist;
    }
}

public class BOJ_1504_dijk {
    public static int N,E, v1, v2;
    public static List<Node1504>[] list;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new LinkedList<>();
        }
        if(E == 0){
            System.out.println(-1);
            return;
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node1504(b, c));
            list[b].add(new Node1504(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        // 1->v1->v2->N
        // 1->v2->v1->N

        distance = new int[N + 1];
        Arrays.fill(distance, (int)1e9);
        distance[1] = 0;
        dijkstra(1);
        int tov1 = distance[v1];
        int tov2 = distance[v2];

        distance = new int[N + 1];
        Arrays.fill(distance, (int)1e9);
        distance[v1] = 0;
        dijkstra(v1);
        int v1tov2 = distance[v2];
        int v1toN = distance[N];

        distance = new int[N + 1];
        Arrays.fill(distance, (int)1e9);
        distance[v2] = 0;
        dijkstra(v2);
        int v2tov1 = distance[v1];
        int v2toN = distance[N];

        int result1 = 0;
        result1 = tov1 + v1tov2 + v2toN;
        int result2 = 0;
        result2 = tov2 + v2tov1 + v1toN;
        int answer = 0;
        if(result1 >= (int)1e9 && result2>= (int)1e9) answer = -1;
        else answer = Math.min(result1, result2);

        System.out.println(answer);
    }

    public static void dijkstra(int start) {
        Queue<Node1504> q = new LinkedList<>();
        q.add(new Node1504(start, 0));

        while (!q.isEmpty()) {
            Node1504 cur = q.poll();
            for (Node1504 h : list[cur.x]) {
                if (distance[h.x] > distance[cur.x] + h.dist) {
                    distance[h.x] = distance[cur.x] + h.dist;
                    q.add(new Node1504(h.x, distance[h.x]));
                }
            }
        }
    }
}
