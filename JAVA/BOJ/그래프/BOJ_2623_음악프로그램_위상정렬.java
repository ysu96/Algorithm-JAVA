package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2623_음악프로그램_위상정렬 {
    public static int N, M;
    public static List<Integer>[] list;
    public static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        list = new List[N + 1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            String[] split = br.readLine().split(" ");
            for(int j=1; j<split.length-1; j++){
                int cur = Integer.parseInt(split[j]);
                int next = Integer.parseInt(split[j + 1]);
                list[cur].add(next);
                indegree[next]++;
            }
        }
        topologicalSort();
    }

    public static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) {
                q.add(i);
                answer.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : list[cur]) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    q.add(i);
                    answer.add(i);
                }
            }
        }
        if(answer.size() < N) System.out.println(0);
        else{
            for (int i : answer) {
                System.out.println(i);
            }
        }

    }
}
