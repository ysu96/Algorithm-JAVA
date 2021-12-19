package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//감소하는 수
public class BOJ_1038 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N <= 10) System.out.println(N);
        else if(N>=1023) System.out.println(-1);
        else{
            Queue<Long> queue = new LinkedList<>();
            int cnt = 0;
            for(int i=1; i<10; i++){
                queue.add((long) i);
                cnt++;
            }
            while(cnt<N){
                // 큐에서 하나씩 빼서
                // 마지막 자리 숫자를 가져옴(tmp)
                // tmp보다 작은 숫자들을 뒤에 붙여서 큐에 추가
                // cnt가 N이 될때 숫자를 출력
                Long poll = queue.poll();
                long tmp = poll%10;
                for(int i=0; i<tmp; i++){
                    queue.add(poll * 10 + i);
                    cnt++;
                    if(cnt == N){
                        System.out.println(poll*10 + i);
                    }
                }
            }
        }
    }
}
