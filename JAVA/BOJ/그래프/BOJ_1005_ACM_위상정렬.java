package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1005_ACM_위상정렬 {
    static int T;
    static int N, K;
    static int[] cost, indegree;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cost = new int[N + 1];
            list = new List[N + 1];
            for(int i=1; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N + 1];
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                list[X].add(Y);
                indegree[Y]++;
            }
            int W = Integer.parseInt(br.readLine());
            topologicalSort(W);
        }
    }

    public static void topologicalSort(int W){
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];
        for(int i=1; i<=N; i++){
            result[i] = cost[i];
            if(indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : list[cur]) {
                result[i] = Math.max(result[i], result[cur] + cost[i]);
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        System.out.println(result[W]);
    }
}
