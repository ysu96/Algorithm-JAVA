package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {
    public static int n,m;
    public static List<Bus2>[] city;
    public static int[] distance;
    public static boolean[] visited;

    static class Bus2 implements Comparable<Bus2> {

        int loc;
        int dist;
        int cnt;
        List<Integer> history = new ArrayList<>();

        Bus2(int loc, int dist, List<Integer> history, int cnt) {
            this.loc = loc;
            this.dist = dist;
            this.cnt = cnt;
            this.history = history;
        }

        @Override
        public int compareTo(Bus2 o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        city = new List[n + 1];
        for(int i=1; i<=n; i++){
            city[i] = new ArrayList<>();
        }
        distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        visited = new boolean[n + 1];

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            city[a].add(new Bus2(b, w, List.of(b), 1));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start,end);
    }

    public static void dijkstra(int s, int e){
        visited[s] = true;
        distance[s] = 0;
        PriorityQueue<Bus2> queue = new PriorityQueue<>();
        queue.add(new Bus2(s, 0, List.of(s), 1));

        while (!queue.isEmpty()) {
            Bus2 cur = queue.poll();

            if(cur.loc == e){
                System.out.println(distance[e]);
                System.out.println(cur.cnt);
                for (int i : cur.history){
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
                return;
            }

            for(Bus2 b : city[cur.loc]){
                List<Integer> list = new ArrayList<>();
                list.addAll(cur.history);
                if (b.dist + distance[cur.loc] < distance[b.loc]) {
                    distance[b.loc] = b.dist + distance[cur.loc];
                    list.add(b.loc);
                    queue.add(new Bus2(b.loc, distance[b.loc], list, cur.cnt+1));
                }
            }
        }

    }
}
