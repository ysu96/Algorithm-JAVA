package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252_줄세우기_위상정렬 {
    static int n,m;
    static int[] indegree;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur+" ");
            for(int z:arr[cur]){
                indegree[z]--;
                if(indegree[z]==0) q.add(z);
            }
        }

    }
}
