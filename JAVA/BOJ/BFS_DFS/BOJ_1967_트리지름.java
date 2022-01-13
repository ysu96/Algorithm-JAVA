package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//가장 긴 지름을 만드는 노드 node1과 node2가 있다고 가정한다면, 임의의 노드 1개에서 가장 먼 노드는 node1이나 node2 이다.
//여기서 긴 지름에 참여하는 노드 1개를 구하고 나머지 하나의 노드를 구하면 node1과 node2를 둘 다 구할 수 있습니다.

class Node_1967{
    int x;
    int w;

    Node_1967(int x, int w) {
        this.x = x;
        this.w = w;
    }
}

public class BOJ_1967_트리지름 {
    public static int n;
    public static List<Node_1967>[] list;
    public static int[] distance;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        distance = new int[n+1];
        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node_1967(b, w));
            list[b].add(new Node_1967(a, w));
        }
        int idx = bfs(1);
        bfs(idx);
        System.out.println(max);
    }

    public static int bfs(int start){
        Queue<Node_1967> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, (int) 1e9);
        distance[start] = 0;
        visited[start] = true;
        max = 0;
        int idx = 1; // 노드가 하나일 때를 대비해 1로 초기화

        q.add(new Node_1967(start, 0));
        while (!q.isEmpty()) {
            Node_1967 cur = q.poll();
            for (Node_1967 n : list[cur.x]) {
                if(!visited[n.x]){
                    distance[n.x] = cur.w + n.w;
                    visited[n.x] = true;
                    if(max < distance[n.x]){
                        max = distance[n.x];
                        idx = n.x;
                    }
                    q.add(new Node_1967(n.x, distance[n.x]));
                }
            }
        }
        return idx;
    }
}
