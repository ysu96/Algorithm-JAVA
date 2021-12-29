package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소 스패닝 트리
class Node implements Comparable<Node>{
    int a,b,w;
    Node(int a, int b, int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}
public class BOJ_1197_MST {
    public static int V,E,A,B,C;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static int[] parent;

    public static int findParent(int x){
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int a, int b){
        int pa = findParent(a);
        int pb = findParent(b);
        if(pa<pb){
            parent[pb] = pa;
        }
        else{
            parent[pa] = pb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.add(new Node(A, B, C));
        }
        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int pa = findParent(n.a);
            int pb = findParent(n.b);
            if(pa==pb) continue;
            union(n.a, n.b);
            answer+=n.w;
        }
//        for(int i=1; i<=V; i++){
//            System.out.println(parent[i]);
//        }
        System.out.println(answer);
    }
}
