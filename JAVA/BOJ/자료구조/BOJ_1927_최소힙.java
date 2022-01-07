package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
    public static int N;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else{
                pq.add(n);
            }
        }
    }
}
