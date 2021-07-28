package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int start, d;
    Node(int start, int d){
        this.start = start;
        this.d = d;
    }
    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
}

public class B1753_최단경로_다익스트라 {
    static int V,E;
    static int start;
    static int[] distance;
    static ArrayList<Node>[] arr;
    static int INF = (int)1e9;
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] check = new boolean[V+1];

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(check[node.start]) continue;
            check[node.start] = true;
            for(Node n : arr[node.start]){
                if(distance[node.start] + n.d < distance[n.start]){
                    distance[n.start] = distance[node.start] + n.d;
                    pq.add(new Node(n.start, distance[n.start]));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());

        distance = new int[V+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        arr = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v,w));
        }

        dijkstra(start);

        for(int i=1;i<=V;i++){
            if(distance[i] >= INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }

    }
}
