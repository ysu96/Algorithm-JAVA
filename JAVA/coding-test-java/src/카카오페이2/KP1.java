package 카카오페이2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KP1 {
    // 가점 = (무주택 기간 + 1) * 2 + (청약 가입 기간 + 2) + (부양가족 수 + 1) * 5
    // 청약 주택과 동일 지역 거주자 중 가점 높은 순서로 당첨
    // 그래도 남으면 그 외 지역들 가점 높은 순서 당첨
    // 가점 동일하면 먼저 신청 우선
    // 지역별 우선순위 큐 저장?, 당첨 지역, 그 외 지역 pq
    // 가점 계산해서 넣기 ( Person (순서, 가점?)

    class Person implements Comparable<Person> {
        int idx;
        int score;

        Person(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            if(this.score > o.score) return -1;
            else if(this.score == o.score){
                if(this.idx < o.idx) return -1;
                else return 1;
            }else{
                return 1;
            }
        }
    }

    public static PriorityQueue<Person> pq1 = new PriorityQueue<>();
    public static PriorityQueue<Person> pq2 = new PriorityQueue<>();

    public int[] solution(int region, int num, int[][] info) {
        // region : 당첨 지역 1~3
        // num : 당첨자 수 1 ~ 100000
        //info : 1~ 100000

        int[] answer = new int[info.length];
        Arrays.fill(answer, -1);
        for (int i = 0; i< info.length; i++) {
            int a = info[i][0]; //거주 지역
            int b = info[i][1]; //무주택기간 0~15
            int c = info[i][2]; //청약 기간 0~15
            int d = info[i][3]; //부양 가족 1~6
            int score = (b + 1) * 2 + (c + 2) + (d + 1) * 5;
            if (a == region) {
                pq1.add(new Person(i, score));
            }else{
                pq2.add(new Person(i, score));
            }
        }

//        while (!pq2.isEmpty()) {
//            Person test = pq2.poll();
//            System.out.println("" + test.idx + "   " + test.score);
//        }
        int rank = 1;
        while (rank <= num && rank <= info.length) {
            if(!pq1.isEmpty()){
                Person p = pq1.poll();
                answer[p.idx] = rank;
            }else{
                if(!pq2.isEmpty()){
                    Person p = pq2.poll();
                    answer[p.idx] = rank;
                }
            }
            rank++;
        }

        for(int a : answer){
            System.out.println(a);
        }

        return answer;
    }

    public static void main(String[] args) {
        KP1 kp1 = new KP1();
        int[][] info = new int[][]{
                {1, 0, 2, 1}, {2, 6, 5, 2}, {3, 10, 2, 4}, {1, 1, 5, 6}, {2, 7, 10, 2}, {3, 8, 6, 3}
        };
        kp1.solution(2, 1, info);
    }
}
//region	num	info	result
//2	4	[[1, 0, 2, 1], [2, 6, 5, 2], [3, 10, 2, 4], [1, 1, 5, 6], [2, 7, 10, 2], [3, 8, 6, 3]]	[-1, 2, 3, 4, 1, -1]
//3	2	[[3, 8, 6, 2], [1, 12, 5, 2], [3, 2, 9, 5], [3, 6, 10, 1], [1, 10, 5, 3]]	[2, -1, 1, -1, -1]
//1	7	[[1, 0, 2, 1], [2, 6, 5, 2], [3, 10, 2, 4], [1, 1, 5, 6], [2, 7, 10, 2], [3, 8, 6, 3]]	[2, 6, 3, 1, 5, 4]
