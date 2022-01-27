package JAVA.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_폭발문자열 {
    public static final String frula = "FRULA";
    public static String s, bomb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            stack.add(s.charAt(i));
            if (stack.size() >= bomb.length()) {

                boolean check = true;
                for(int j = 0; j<bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()) System.out.println(frula);
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
