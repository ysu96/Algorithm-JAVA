package JAVA.BOJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11005_진법변환2 {
    public static int n,b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            stack.push(n % b);
            n /= b;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if(num >= 10){
                sb.append((char)(num - 10 + 'A'));
            }else{
                sb.append(num);
            }
        }
        System.out.println(sb);
    }
}
