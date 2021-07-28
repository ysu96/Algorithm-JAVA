package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516_게임개발_위상정렬 {
    static int N;
    static int[] indegree,time, result;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        time = new int[N+1];
        result = new int[N + 1];

        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            time[i] = a;

            while(true){
                int b = Integer.parseInt(st.nextToken());
                if(b==-1) break;
                arr[b].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0) {
                q.add(i);
                result[i] = time[i];
            }

        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int z : arr[cur]){
                indegree[z]--;
                result[z] = Math.max(result[z], result[cur]+time[z]);
                if(indegree[z] == 0) q.add(z);
            }
        }

        for(int i=1;i<=N;i++){
            System.out.println(result[i]);
        }
    }
}
