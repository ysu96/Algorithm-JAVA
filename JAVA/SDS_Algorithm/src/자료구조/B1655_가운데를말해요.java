package 자료구조;

import java.util.Comparator;
import java.util.PriorityQueue;

public class B1655_가운데를말해요 {
    static PriorityQueue<Integer> min_pq; //자바는 작은값이 앞에있음
    static PriorityQueue<Integer> max_pq; //큰 값 앞에 오게


    public static void main(String[] args) {
        min_pq = new PriorityQueue<Integer>();
        min_pq.add(10);
        min_pq.add(20);
        min_pq.add(30);
        System.out.println(min_pq.peek());

        max_pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return -1;
                else return 1;
            }
        });

        max_pq.add(10);
        max_pq.add(20);
        max_pq.add(30);
        System.out.println(max_pq.peek());

    }
}
