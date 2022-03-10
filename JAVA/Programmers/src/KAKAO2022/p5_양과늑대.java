package JAVA.Programmers.src.KAKAO2022;

import java.util.ArrayList;
import java.util.List;

public class p5_양과늑대 {
    public List<Integer>[] arr;
    public boolean[] visited;
    public int answer;

    public int solution(int[] info, int[][] edges) {
        int len = info.length;
        arr = new List[len];
        visited = new boolean[len];
        answer = 0;

        for(int i=0; i<len; i++){
            arr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            arr[a].add(b);
            arr[b].add(a);
        }

        visited[0] = true;
        boolean[] nexts = new boolean[info.length];
        for (int i : arr[0]) {
            nexts[i] = true;
        }
        nexts[0] = true;

        dfs(0, 1, 0, nexts, info);

        return answer;
    }

    public void dfs(int cur, int lamb, int wolf, boolean[] nexts, int[] info) {
        answer = Math.max(answer, lamb);

        for (int i = 0; i < nexts.length; i++) {
            if (nexts[i] && !visited[i]) {
                if(info[i] == 1 && lamb-wolf == 1) continue;

                int parent = 0;
                for(int j : arr[i]){
                    if(nexts[j]){
                        parent = j;
                    }
                    nexts[j] = true;
                }
                visited[i] = true;

                if(info[i] == 1) dfs(i, lamb, wolf+1, nexts, info);
                else dfs(i, lamb + 1, wolf, nexts, info);

                visited[i] = false;
                for(int j : arr[i]){
                    nexts[j] = false;
                }
                nexts[parent] = true;
            }
        }
    }
}
