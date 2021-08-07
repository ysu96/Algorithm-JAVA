package 카카오인턴십_2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 수식최대화 {
    public long calc(long a,long b,char op) {
        if(op == '*') return a * b;
        else if(op =='+') return a+b;
        else return a - b;
    }

    public long solution(String expression) {
        long answer = 0;
        int oper_num = 0;
        int[][] priors = {{0, 1, 2}, {0, 2, 1},{1, 0, 2}, {1, 2, 0},{2, 0, 1},{2, 1, 0}};
        char[] operands = {'*', '+', '-'};
//        int[][] priors = {{0, 1, 2}};

        Set<Character> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> num_list = new ArrayList<Long>();
        ArrayList<Character> op_list = new ArrayList<Character>();


        for(int i=0; i<expression.length(); i++){
            //숫자가 아니면
            if(!Character.isDigit(expression.charAt(i))){
                s.add(expression.charAt(i));
                op_list.add(expression.charAt(i));
                num_list.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
            else{
                sb.append(expression.charAt(i));
            }
        }
        num_list.add(Long.parseLong(sb.toString()));




        for(int[] prior : priors){

            ArrayList<Long> _num_list = new ArrayList<>();
            ArrayList<Character> _op_list = new ArrayList<>();
            _num_list.addAll(num_list);
            _op_list.addAll(op_list);

            for(int i=0; i<3; i++){
                Stack<Long> num_stack = new Stack<Long>();
                Stack<Character> op_stack = new Stack<Character>();
                num_stack.add(_num_list.get(0));

                for(int j=0; j<_op_list.size(); j++){
                    if(_op_list.get(j) == operands[prior[i]]){
                        long a = num_stack.pop();
                        long b = _num_list.get(j+1);
                        char op = _op_list.get(j);

                        num_stack.add(calc(a,b,op));
                    }
                    else{
                        num_stack.add(_num_list.get(j+1));
                        op_stack.add(_op_list.get(j));
                    }
                }
                _num_list.clear();
                _num_list.addAll(num_stack);


                _op_list.clear();
                _op_list.addAll(op_stack);
            }

            answer = Math.max(answer, Math.abs(_num_list.get(0)));

        }

        return answer;
    }

    public static void main(String[] args) {
        수식최대화 a = new 수식최대화();
        System.out.println(a.solution("2*2*2*2*2-2*2*2"));
    }
}
