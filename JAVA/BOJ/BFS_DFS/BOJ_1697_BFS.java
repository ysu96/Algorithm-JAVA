package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 숨바꼭질 , bfs, dp도 가능!
public class BOJ_1697_BFS {
    public static int N, K;
    public static int[] graph = new int[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph[N] = 0;
        queue.add(N);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x==K){
                System.out.println(graph[x]);
                return;
            }
            if(x-1 >= 0 && x-1<100001){
                if(graph[x-1] == 0){
                    graph[x-1] = graph[x]+1;

                    queue.add(x-1);
                }

            }
            if(x+1 >= 0 && x+1 < 100001){
                if (graph[x+1] == 0){
                    graph[x+1] = graph[x]+1;
                    queue.add(x+1);
                }
            }
            if(2*x >= 0 && 2*x < 100001){
                if(graph[x*2] == 0){
                    graph[x*2] = graph[x]+1;
                    queue.add(x*2);
                }
            }
        }
    }
}
