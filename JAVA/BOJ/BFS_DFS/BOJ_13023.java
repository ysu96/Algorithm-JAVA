package BFS_DFS;

//ABCDE - dfs / dfs 마지막에 visited[now] = false 해줘야댐
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {
    public static int n,m;
    public static List<Integer>[] arr;
    public static boolean[] visited;
    public static boolean ans;

    public static void dfs(int now, int count){
        visited[now] = true;
        if(count == 5){
            ans = true;
            return;
        }

        for(int i : arr[now]){
            if(!visited[i]){
                dfs(i, count+1);
            }
        }
        visited[now] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=0; i<n; i++){
            visited = new boolean[n];
            dfs(i,1);
            if(ans) break;
        }
        if(ans) System.out.println(1);
        else System.out.println(0);
    }
}
