package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리부모찾기 {
    public static List<Integer>[] tree;
    public static int N;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new List[N + 1];
        parent = new int[N + 1];

        for(int i=1; i<=N; i++){
            tree[i] = new LinkedList<>();
        }
        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        solution();
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void solution(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int n : tree[cur]) {
                if(parent[n] == 0){
                    parent[n] = cur;
//                    System.out.println(n);
                    q.add(n);
                }
            }
        }
    }
}
