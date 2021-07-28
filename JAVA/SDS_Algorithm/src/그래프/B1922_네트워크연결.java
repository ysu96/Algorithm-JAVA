package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int a;
    int b;
    int weight;
    Edge(int a, int b, int weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight; //작은 무게가 앞에 가도록??
    }

}
public class B1922_네트워크연결 {
    private static int[] parent;
    private static ArrayList<Edge> edges = new ArrayList<Edge>();
    private static int N,M, ans =0;

    public static int find_parent(int x){
        if(parent[x] != x){
            parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }

    public static void union_parent(int x, int y){
        int x_parent = find_parent(x);
        int y_parent = find_parent(y);
        if (x_parent!=y_parent)
            parent[y_parent] = x_parent;
        else
            parent[x_parent] = y_parent;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, weight));
        }

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        Collections.sort(edges);

        for(Edge e : edges){
            if(find_parent(e.a) != find_parent(e.b)){
                System.out.println(e.weight +" " +  find_parent(e.a)+" "+ find_parent(e.b));
                union_parent(e.a, e.b);

                ans += e.weight;
            }
        }
        System.out.println(ans);

    }
}
