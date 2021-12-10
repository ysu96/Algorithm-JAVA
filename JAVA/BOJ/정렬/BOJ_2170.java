package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Line implements Comparable<Line>{
    int x;
    int y;
    Line(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Line o) {
        //종료시간 같으면 시작 앞인거 앞으로오게
        if(o.x == x)
            return y-o.y;
        //종료 빠른거부터 정렬
        return x-o.x;
    }
}
public class BOJ_2170 {
    public static int n;
    public static PriorityQueue<Line> arr = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Line(a, b));
        }
        int start;
        int end;
        int answer = 0;
        Line p = arr.poll();
        start = p.x;
        end = p.y;
        answer = end - start;
        while (!arr.isEmpty()) {
            Line poll = arr.poll();
            if (end > poll.x) {
                if(end > poll.y) continue;
                else{
                    answer += (poll.y - end);
                    end = poll.y;
                }
            }else{
                answer += (poll.y-poll.x);
                end = poll.y;
            }
        }
        System.out.println(answer);
    }
}
