package JAVA.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 스택에는 연산자만 사용하고, 피연산자는 바로바로 출력한다
// 연산자의 우선 순위를 지정해서 stack에 넣기 전에, 현재 연산자의 우선순위보다 큰 연산자가 stack의 맨 위에 있다면 없을 때까지 pop한다. (우선순위가 큰 연산자가 먼저 계산되어야 하기 때문)
// )일 경우에는 (가 나올 때까지 stack 안의 연산자를 pop한다!

public class BOJ_1918_후위표기식 {
    public static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('*', 3);
        priority.put('/', 3);
        priority.put('+', 2);
        priority.put('-', 2);
        priority.put('(', 1);
        priority.put(')', 1);

        Stack<Character> op = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if (Character.isAlphabetic(c)) {
                answer.append(c);
            }
            else if(c == ')'){
                while (!op.isEmpty()) {
                    char last = op.pop();
                    if(last == '(') break;
                    answer.append(last);
                }
            }
            else if(c == '('){
                op.add(c);
            }
            else{
                while (!op.isEmpty() && priority.get(op.peek()) >= priority.get(c)) {
                    answer.append(op.pop());
                }
                op.add(c);
            }
        }
        while (!op.isEmpty()) {
            answer.append(op.pop());
        }
        System.out.println(answer.toString());
    }
}
