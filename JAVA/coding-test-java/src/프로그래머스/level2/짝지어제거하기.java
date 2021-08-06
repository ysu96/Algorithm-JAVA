package 프로그래머스.level2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                char last = stack.peek();
                char cur = s.charAt(i);
                if(last == cur){
                    stack.pop();
                }
                else{
                    stack.push(cur);
                }
            }
        }
        return stack.isEmpty()? 1:0;

    }

    public static void main(String[] args) {
        짝지어제거하기 a = new 짝지어제거하기();
        System.out.println(a.solution("aaaaa"));
    }
}
