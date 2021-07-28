package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10845_큐 {
    private static int N;
    private static Queue<Integer> queue = new LinkedList<Integer>();
    private static String op;
    private static int last;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            if (op.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.add(x);
                last = x;

            } else if (op.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }

            } else if (op.equals("size")) {
                System.out.println(queue.size());

            } else if (op.equals("empty")) {
                if (queue.isEmpty()) System.out.println(1);
                else System.out.println(0);

            } else if (op.equals("front")){
                if (queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());

            } else {
                if (queue.isEmpty()) System.out.println(-1);
                else System.out.println(last);
            }
        }
    }
}
