package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828_스택 {
    private static int N;
    private static Stack<Integer> stack = new Stack<Integer>();
    private static String op;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            if(op.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stack.add(x);

            } else if (op.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.pop());
                }

            } else if (op.equals("size")) {
                System.out.println(stack.size());

            } else if (op.equals("empty")) {
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);

            } else {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}
