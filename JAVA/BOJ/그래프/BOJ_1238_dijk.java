package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//파티 : 다익스트라
class House {
    int x;
    int dist;

    House(int x, int dist) {
        this.x = x;
        this.dist = dist;
    }
}

public class BOJ_1238_dijk {
    public static int N, M, X;
    public static int[] distance;
    public static List<House>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
            distance[i] = (int) 1e9;
        }

        distance[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[a].add(new House(b, t));
        }

        int answer = 0;
        int[] sumDist = new int[N + 1];
        dijkstra(X);
        for (int i = 1; i <= N; i++) {
            sumDist[i] = distance[i];
        }

        for (int i = 1; i <= N; i++) {
            distance = new int[N + 1];
            Arrays.fill(distance, (int) 1e9);
            distance[i] = 0;
            sumDist[i] += dijkstra(i);
        }
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            answer = Math.max(sumDist[i], answer);
        }

        System.out.println(answer);
    }

    public static int dijkstra(int start) {
        Queue<House> q = new LinkedList<>();
        q.add(new House(start, 0));

        while (!q.isEmpty()) {
            House cur = q.poll();
            for (House h : list[cur.x]) {
                if (distance[h.x] > distance[cur.x] + h.dist) {
                    distance[h.x] = distance[cur.x] + h.dist;
                    q.add(new House(h.x, distance[h.x]));
                }
            }
        }
        return distance[X];
    }
}
