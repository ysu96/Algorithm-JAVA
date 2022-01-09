package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리에서 가장 먼 두 노드의 길이 찾기 , 지름
class TreeNode {
    int dest;
    int w;

    TreeNode(int dest, int w) {
        this.dest = dest;
        this.w = w;
    }
}

//트리
public class BOJ_1167 {
    public static int N, answer, maxNode;
    public static List<TreeNode>[] list;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int v;
            while ((v = Integer.parseInt(st.nextToken())) != -1) {
                int dist = Integer.parseInt(st.nextToken());
                list[idx].add(new TreeNode(v, dist));
            }
        }

        visited = new boolean[N + 1];
        dfs(1, 0);
//        System.out.println(maxNode);

        answer = 0;
        visited = new boolean[N + 1];
        dfs(maxNode, 0);
//        System.out.println(maxNode);
        System.out.println(answer);
    }

    public static void dfs(int v, int len) {
        if (len > answer) {
            answer = len;
            maxNode = v;
        }

        visited[v] = true;

        for (TreeNode tn : list[v]) {
            if (!visited[tn.dest]) {
                dfs(tn.dest, tn.w + len);
                visited[tn.dest] = true;
            }
        }
    }

}
