package SKFamily;
//dist(i, j) + dist(j, k) = dist(i, k)라는 의미는, 결과적으로 i와 k의 최단 이동거리 사이에 j가 존재한다는 의미입니다.
//
//즉, i와 k 사이에 j가 있으면 됩니다.
//가능한 경우는 크게 두 가지가 있는데,
//- j가 부모 노드이고, i와 k가 서로 다른 위치의 자식 노드일때
//- j는 그냥 노드고, i와 k 중 하나가 레벨 상으로 위에, 하나가 아래에 있는 경우
//
//전자의 경우, 그냥 가능한 노드의 수를 미리 세서 곱하면 끝나고,
//후자의 경우, (j의 자식들의 수) * (N - j와 j의 자식들의 수)를 계산하면 됩니다.
import java.util.ArrayList;
import java.util.List;

// i ~ k 사이의 노드의 개수가 경우의 수  : dist(i~k)-1
// 모든 가능한 경로의 합 - n(n-1)/2
// 가능한 모든 경로의 거리를 구하는 문제로 축소 가능
public class SK_p4 {
    public long solution(int n, int[][] edges) {
        long answer = 0;
        List<Integer>[] list = new List[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<n; i++){
            for (int j : list[i]) {
                if(list[j].size() == 1) continue;
                answer += (list[j].size() - 1);

            }
        }
        return answer;
    }
}
