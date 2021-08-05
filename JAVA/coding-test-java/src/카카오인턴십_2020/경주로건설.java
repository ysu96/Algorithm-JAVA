package 카카오인턴십_2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 경주로건설 {

    class Node{
        int r;
        int c;
        int weight;
        int direction;
        Node(int r, int c, int weight, int direction){
            this.r = r;
            this.c = c;
            this.weight = weight;
            this.direction = direction;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][] cost = new int[n][n];
        int INF = (int)1e9;
        for(int i =0; i<n; i++){
            Arrays.fill(cost[i], INF);
        }

        Queue<Node> q = new LinkedList<Node>();
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};
        //direction : 0-> left , 1->right, 2->up, 3->down, -1: start
        q.add(new Node(0,0,0, -1));

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.weight > cost[cur.r][cur.c]){
                continue;
            }
            else{
                cost[cur.r][cur.c] = cur.weight;
            }

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr<0 || nr>=n || nc<0 || nc>=n || board[nr][nc] == 1) continue;

                if(cur.direction == -1){
                    q.add(new Node(nr,nc,cur.weight+100,i));
                }
                else if(cur.direction == 0 || cur.direction == 1){ //직전 방향이 왼쪽이면
                    if(i==2 || i==3){ //코너
                        q.add(new Node(nr,nc,cur.weight+600, i));
                    }
                    else{
                        q.add(new Node(nr,nc,cur.weight+100,i));
                    }
                }
                else if(cur.direction == 2 || cur.direction == 3){
                    if(i==0 || i==1){
                        q.add(new Node(nr,nc,cur.weight+600, i));
                    }
                    else{
                        q.add(new Node(nr,nc,cur.weight+100,i));
                    }
                }

            }
        }
        answer = cost[n-1][n-1];
        return answer;
    }

    public static void main(String[] args) {
        경주로건설 a = new 경주로건설();
        int[][] board = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        System.out.println(a.solution(board));
    }
}
