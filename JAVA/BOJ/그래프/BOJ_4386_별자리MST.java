package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point4386{
    double x;
    double y;
    Point4386(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Edge4386 implements Comparable<Edge4386>{
    int a;
    int b;
    double dist;

    Edge4386(int a, int b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge4386 o) {
        if(this.dist < o.dist) return -1;
        else return 1;
    }

}

public class BOJ_4386_별자리MST {
    public static int N;
    public static List<Point4386> list = new ArrayList<>();
    public static PriorityQueue<Edge4386> edges = new PriorityQueue<>();
    public static int[] parent;
    public static boolean[] visited;
    public static double answer;

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

    public static double getDistance(Point4386 p1, Point4386 p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list.add(new Point4386(x, y));
        }

        for (int i = 0; i < N - 1; i++) {
            Point4386 p1 = list.get(i);
            for(int j=i+1; j<N; j++){
                Point4386 p2 = list.get(j);
                double dist = getDistance(p1, p2);
                edges.add(new Edge4386(i, j, dist));
            }
        }

        while (!edges.isEmpty()) {
            Edge4386 e = edges.poll();
            if (findParent(e.a) != findParent(e.b)) {
                union(e.a, e.b);
                answer += e.dist;
            }
        }
        System.out.println(answer);
    }
}
