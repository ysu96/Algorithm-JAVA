package 카카오뱅크;

import java.util.LinkedList;
import java.util.List;

public class P4 {
    public int solution(int[][] tower, int k) {
        int answer = 0;
        boolean[] check = new boolean[11];
        List<Integer>[] list = new List[11]; // 높이를 인덱스로 높이별로 원소 모으기
        for (int[] t : tower) {
            int height = t[1];
            if (!check[height]) {
                check[height] = true;
                list[height] = new LinkedList<>();
            }
            list[height].add(t[0]);
        }

        for (int i = 1; i < 11; i++) {
            if (check[i]) {
                answer += countGroup(list[i], k);
            }
        }
        return answer;
    }

    public static int countGroup(List<Integer> list, int k) {
        int loc = list.get(0);
        int cnt = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - loc > k) {
                cnt++;
            }
            loc = list.get(i);
        }
        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        P4 p4 = new P4();
        p4.solution(new int[][]{{0, 2},
                {2, 3},
                {3, 2},
                {5, 3},
                {6, 2},
                {7, 3},
                {9, 4},
                {10, 2},
                {11, 2},
                {12, 4},
                {14, 2},
                {15, 3},
                {16, 2}}, 3);
    }
}
