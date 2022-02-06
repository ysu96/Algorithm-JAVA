package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Village implements Comparable<Village>{
    int a,b,w;
    Village(int a, int b, int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Village o) {
        return this.w - o.w;
    }
}

public class BOJ_1647_MST {
    public static int N,M;
    public static PriorityQueue<Village> pq = new PriorityQueue<>();
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Village(a, b, w));
        }

        int last = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            Village cur = pq.poll();
            if (findParent(cur.a) != findParent(cur.b)) {
                union(cur.a, cur.b);
                last = cur.w;
                answer += cur.w;
            }
        }
        System.out.println(answer-last);
    }
}
