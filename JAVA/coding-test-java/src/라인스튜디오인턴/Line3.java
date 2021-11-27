package 라인스튜디오인턴;

public class Line3 {
    static int index = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    // 0:오른쪽, 1:아래쪽, 2:왼쪽, 3;위쪽
    public int solution(int[][] board, int[][] durability) {
        int answer = 0;
        int nr = 0;
        int nc = 0;
        int len = board.length;
        while(true){
            System.out.println("r :"+nr+" c : "+nc+" answer : "+answer);
            if(nr<0 || nr>=len || nc<0 || nc>=len){
                return answer;
            }

            answer++;
            int obstacle = board[nr][nc];
            if(obstacle == 1){
                durability[nr][nc]--;
                if(durability[nr][nc] == 0){
                    board[nr][nc] = 0;
                }

                //오른쪽방향, 아래방향
                if(index == 0 || index == 1){
                    index = (index+2)%4;
                    answer--;
                }
                else if(index == 2){
                    index = 1;
                }
                else{
                    index = 0;
                }
            }
            if(obstacle == 2){
                durability[nr][nc]--;
                if(durability[nr][nc] == 0){
                    board[nr][nc] = 0;
                }

                //왼쪽방향, 아래방향
                if(index == 1 || index == 2){
                    index = (index+2)%4;
                    answer--;
                }
                //위쪽 -> 왼쪽
                else if(index == 3){
                    index = 2;
                }
                //오른쪽 -> 아래
                else{
                    index = 1;
                }

            }
            if(obstacle == 3){
                durability[nr][nc]--;
                if(durability[nr][nc] == 0){
                    board[nr][nc] = 0;
                }

                //오른쪽방향, 위쪽방향
                if(index == 0 || index == 3){
                    index = (index+2)%4;
                    answer--;
                }
                //왼쪽 -> 위
                else if(index == 2){
                    index = 3;
                }
                //아래 -> 오른쪽
                else{
                    index = 0;
                }
            }
            if(obstacle == 4){
                durability[nr][nc]--;
                if(durability[nr][nc] == 0){
                    board[nr][nc] = 0;
                }

                //왼쪽방향, 위쪽방향
                if(index == 2 || index == 3){
                    index = (index+2)%4;
                    answer--;
                }
                //오른쪽 -> 위
                else if(index == 0){
                    index = 3;
                }
                //아래쪽 -> 왼
                else{
                    index = 2;
                }
            }
            if(obstacle == 5){
                durability[nr][nc]--;
                if(durability[nr][nc] == 0){
                    board[nr][nc] = 0;
                }
                index = (index+2)%4;
                answer--;
            }

            nr = nr+dr[index];
            nc = nc + dc[index];

        }
    }

    public static void main(String[] args) {
        Line3 l3 = new Line3();
//        {{0, 2, 0}, {0, 5, 0}, {0, 0, 0}}

        int[][] board = {{0, 0, 2, 0}, {1, 0, 3, 2}, {0, 0, 0, 0}, {3, 0, 0, 4}};
        int[][] durability =  {{0, 0, 2, 0},{5, 0, 2, 5}, {0, 0, 0, 0},{5, 0, 0, 5}};
        System.out.println(l3.solution(board, durability));
    }
}
