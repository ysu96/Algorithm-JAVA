package 라인스튜디오인턴;

public class Line4 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public int solution(int[][] grid) {
        int answer = -1;
        int len = grid.length;
        int[][] tops = new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(grid[i][j] != 0){
                    boolean check = true;
                    int mintop = Integer.MAX_VALUE;

                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < len && nc >= 0 && nc < len) {
                            // 주변에 0이 있으면 1이 최대
                            if(grid[nr][nc] == 0){
                                check = false;
                                break;
                            }
                            //주변 탑들의 최소값 찾기
                            else{
                                if(tops[nr][nc] != 0)
                                    mintop = Math.min(tops[nr][nc], mintop);
                            }
                        }
                    }
                    if(check){
                        tops[i][j] = mintop+1;
                    }
                    else{
                        tops[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                System.out.print(tops[i][j]);
                answer = Math.max(answer, tops[i][j]);
            }
            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args) {
        Line4 l4 = new Line4();
        l4.solution(new int[][]{{0, 0, 1, 1, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {1, 1, 1, 1, 1},{0, 0, 1, 0, 1}});
    }
}
