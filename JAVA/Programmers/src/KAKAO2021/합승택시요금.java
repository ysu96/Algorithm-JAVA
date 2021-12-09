package KAKAO2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 다익스트라 또는 플로이드 와셜로 풀이 가능
// 플로이드 와셜 풀이 시 중간에 내려서 따로 가는 경우를 고려해야함
//  for(int i = 1; i <= n; i++) {
//            answer = Math.min(answer, dp[s][i] + dp[i][a] +dp[i][b]);
//        }
public class 합승택시요금 {
    public static boolean[] visited;
    public static int[] dist;
    public static List<Dest>[] dest;
    class Dest implements Comparable<Dest>{
        int idx;
        int weight;

        Dest(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Dest o) {
            return weight - o.weight;
        }
    }
    public int[] dijkstra(int s, int[] dist){
        dist[s] = 0;
        PriorityQueue<Dest> pq = new PriorityQueue<>();
        pq.add(new Dest(s,0));
        while (!pq.isEmpty()) {
            Dest poll = pq.poll();
            int nIdx = poll.idx;
            int nWeight = poll.weight;
            for (Dest next : dest[nIdx]) {
                if (dist[nIdx] + next.weight < dist[next.idx]) {
                    dist[next.idx] = dist[nIdx] + next.weight;
                    pq.add(new Dest(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = (int)1e9;
        dest = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            dest[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            dest[fare[0]].add(new Dest(fare[1], fare[2]));
            dest[fare[1]].add(new Dest(fare[0], fare[2]));
        }
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] startS = new int[n+1];
        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(startS, Integer.MAX_VALUE);
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        startS = dijkstra(s, startS);

        for(int i=1; i<=n; i++){
            int together = startS[i] + startA[i] + startB[i];
            System.out.println(together);
            answer = Math.min(answer, together);
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        합승택시요금 a = new 합승택시요금();
//        a.solution(6,4,6, 2,
//                new int[][]{
//                        {4, 1, 10},
//                        {3, 5, 24},
//                        {5, 6, 2},
//                        {3, 1, 41},
//                        {5, 1, 24},
//                        {4, 6, 50},
//                        {2, 4, 66},
//                        {2, 3, 22},
//                        {1, 6, 25}});
        a.solution(7,3,4,1,new int[][]{
                {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}
        });
    }
}
