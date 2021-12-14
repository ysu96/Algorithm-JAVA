package Socar;

import java.util.Stack;

public class problem1 {

    public int solution(String s){
        int answer = 0;
        char c = getBlank(s);
        String tmp = "";
        for(int i=0; i<=s.length(); i++){
            tmp = s.substring(0,i) + c + s.substring(i,s.length());
            //System.out.println(tmp);
            if(check(tmp)) {
                answer++;
                System.out.println(tmp);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public char getBlank(String s){
        int a=0,b=0,c=0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='{') a++;
            else if (s.charAt(i) == '}') a--;
            else if (s.charAt(i) == '[') b++;
            else if (s.charAt(i) == ']') b--;
            else if (s.charAt(i) == '(') c++;
            else if (s.charAt(i) == ')') c--;
        }

        if(a==-1) return '{';
        else if(a==1) return '}';
        else if(b==-1) return '[';
        else if(b==1) return ']';
        else if(c==-1) return '(';
        else return ')';
    }

    public boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char cc = s.charAt(i);
            if(cc=='{' || cc=='[' || cc=='('){
                stack.add(cc);
            } else{
                if(stack.isEmpty()) return false;
                else{
                    char nc = stack.pop();
                    if((nc=='{' && cc!='}') || (nc=='[' && cc!=']') ||(nc=='(' && cc!=')')) return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }

    public static void main(String[] args) {
        problem1 a = new problem1();
        a.solution("(()()()");
    }
}
