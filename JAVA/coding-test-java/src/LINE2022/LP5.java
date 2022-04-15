package LINE2022;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LP5 {
    //2 ≤ abilities의 길이 ≤ 300,000
    //1 ≤ abilities의 원소 ≤ 1000000000 10억?
    //0 ≤ 2 * k ≤ abilities의 길이 + 1

    class Difference implements Comparable<Difference> {
        int a, b;
        int dif;

        Difference(int a, int b, int dif) {
            this.a = a;
            this.b = b;
            this.dif = dif;
        }

        @Override
        public int compareTo(Difference o) {
            if (this.dif > o.dif) return -1;
            else return 1;
        }
    }

    public long solution(int[] abilities, int k) {
        long answer = 0;
        Arrays.sort(abilities);

        // [9,9,8,6,3,2,1,1], [10,9,8,7,6]
        // 1. 최대값이랑 그 다음값이랑 같으면 우선권 x
        // * 2개씩 묶어서 그 차이가 최대인 순서대로 우선권 써야함

        PriorityQueue<Difference> pq = new PriorityQueue<>();
        for (int i = abilities.length - 1; i >= 0; i -= 2) {
            if (i == 0) {
                pq.add(new Difference(abilities[i], -1, abilities[i]));
            } else {
                int a = abilities[i];
                int b = abilities[i - 1];

                if (a == b) answer += b;
                else pq.add(new Difference(a, b, a-b));
            }

        }

        // 우선권 사용
        while (k > 0 && !pq.isEmpty()) {
            Difference poll = pq.poll();
            answer += poll.a;
            k--;
        }
        while (!pq.isEmpty()) {
            Difference poll = pq.poll();
            if (poll.b == -1) continue;
            answer += poll.b;
        }

        return answer;
    }

    public static void main(String[] args) {
        LP5 lp5 = new LP5();
        int[] ab = new int[]{7, 7, 7, 7, 7};
        long solution = lp5.solution(ab, 2);
        System.out.println(solution);
    }
}
