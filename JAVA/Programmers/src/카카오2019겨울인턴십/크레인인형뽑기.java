package JAVA.Programmers.src.카카오2019겨울인턴십;

import java.util.Stack;

public class 크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int len = board.length;
        int answer = 0;
        for (int m : moves) {
            for(int i=0; i<len; i++){
                if(board[i][m-1] != 0){
                    if(stack.isEmpty()) stack.add(board[i][m-1]);
                    else{
                        if (stack.peek() == board[i][m-1]) {
                            answer += 2;
                            stack.pop();
                        }
                        else{
                            stack.add(board[i][m - 1]);
                        }
                    }
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
