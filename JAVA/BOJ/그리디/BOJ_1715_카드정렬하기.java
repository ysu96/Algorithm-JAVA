package JAVA.BOJ.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
    public static int N;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        long answer = 0;

        while (!pq.isEmpty()) {
            int tmp = pq.poll();
            if(pq.size() == 0){
                break;
            }
            int tmp2 = pq.poll();
            answer += (tmp + tmp2);
            pq.add(tmp + tmp2);
        }
        System.out.println(answer);
    }
}
