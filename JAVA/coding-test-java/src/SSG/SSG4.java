package SSG;

import java.util.LinkedList;
import java.util.Queue;

public class SSG4 {
    // 상 하 좌 우 중 3개 이상이면 터짐

    // 밑으로 내리기 함수
    // 터뜨리기 함수
    // 터뜨릴거 찾는 함수?, 한꺼번에 터지기기

   public static int[][] board = new int[6][6];
   public static int[] dr = {-1, 1, 0, 0};
   public static int[] dc = {0, 0, -1, 1};

   public String[] solution(int[][] macaron){
       for (int[] m : macaron) {
           int idx = m[0]-1;
           int color = m[1];
           int row = 0;
           while(row < 5 && board[row + 1][idx] == 0){
               row++;
           }
           board[row][idx] = color;

           while(true){
               if(bomb() == 0) break;
               pushDown();
           }
       }

       printArr(board);
       String[] answer = new String[6];
       for(int i=0; i<6; i++){
           StringBuilder sb = new StringBuilder();
           for(int j = 0; j<6; j++){
               sb.append(board[i][j]);
           }
           answer[i] = sb.toString();
           System.out.println(answer[i]);
       }
        return answer;
   }

   public void pushDown(){
       for(int i=0; i<6; i++){ // 열
           for(int j=5; j >= 0; j--){ // 행
               if(board[j][i] != 0){
                   int loc = j;
                   if(loc == 5 || board[loc+1][i] != 0) continue;

                   while (loc < 6) {
                       if(loc == 5){
                           board[loc][i] = board[j][i];
                           board[j][i] = 0;
                           break;
                       }

                       if(board[loc+1][i] != 0){
                           board[loc][i] = board[j][i];
                           board[j][i] = 0;
                           break;
                       }
                       loc++;
                   }
               }
           }
       }
   }

   public int bomb(){
       int bombCnt = 0;
       boolean bombed = false;
       for(int i=0; i<6; i++){
           for(int j=0; j<6; j++){
               if(board[i][j] != 0){
                   bombCnt += bfs(i, j);
               }
           }
       }
       return bombCnt;
   }

    public int bfs(int r, int c){
       boolean[][] visited = new boolean[6][6];
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r, c});
        int cnt = 1;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cr = poll[0];
            int cc = poll[1];

            for(int k =0 ; k<4; k++){
                int nr = cr + dr[k];
                int nc = cc + dc[k];
                if(nr < 0 || nr >= 6 || nc < 0 || nc >= 6) continue;
                if(visited[nr][nc]) continue;
                if(board[cr][cc] == board[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                    cnt++;
                }
            }
        }

        if(cnt < 3) return 0;

        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(visited[i][j]) board[i][j] = 0;
            }
        }
        return 1;
    }

   public boolean bombComplete(){
       boolean[][] visited = new boolean[6][6];

       for(int i=0; i<6; i++){
           for(int j=0; j<6; j++){
                if(!visited[i][j] && board[i][j] != 0){

               }
           }
       }
       return false;
   }

    public static void printArr(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(""+arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SSG4 ssg4 = new SSG4();
        int[][] a = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
        int[][] b = {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}};
        ssg4.solution(b);
    }
}
