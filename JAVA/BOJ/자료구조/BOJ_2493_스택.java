package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int idx;
    int height;

    Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}
public class BOJ_2493_스택 {
    public static Stack<Top> stack = new Stack<>();
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty()){
                while (true) {
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.add(new Top(i, num));
                        break;
                    }

                    if(stack.peek().height > num){
                        sb.append(stack.peek().idx+1);
                        sb.append(' ');
                        stack.add(new Top(i, num));
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            else{
                sb.append(0);
                sb.append(' ');
                stack.add(new Top(i, num));
            }
        }
        System.out.println(sb.toString());
    }
}
