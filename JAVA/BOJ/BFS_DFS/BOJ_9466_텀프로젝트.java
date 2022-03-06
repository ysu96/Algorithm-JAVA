package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://bcp0109.tistory.com/32
public class BOJ_9466_텀프로젝트 {
    static int T, n, answer;
    static int[] arr;
    static boolean[] check, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            check = new boolean[n + 1];
            visited = new boolean[n + 1];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                dfs(i);
            }
            System.out.println(n - answer);
        }
    }

    public static void dfs(int idx){
        if(visited[idx]) return;

        visited[idx] = true;
        int next = arr[idx];

        if (!visited[next]) dfs(next);
        else{
            if(!check[next]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                answer++;
                for(int i=next; i != idx; i = arr[i])
                    answer++;
            }
        }
        check[idx] = true;
    }
}
