package 카카오페이;

public class KP2 {
    public int[] solution(int rows, int columns, int[][] swipes) {

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int[][] graph = new int[rows + 1][columns + 1];
        int[][] temp = new int[rows + 1][columns + 1];
        int[] answer = new int[swipes.length];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                graph[i][j] = (i - 1) * columns + j;
                temp[i][j] = (i - 1) * columns + j;
            }
        }
        int cnt = 0;
//d 1 : 아래로 , 2: 위로, 3:오른쪽, 4: 왼쪽
        for (int[] swipe : swipes) {
            int ans = 0;

            int d = swipe[0];
            int r1 = swipe[1];
            int c1 = swipe[2];
            int r2 = swipe[3];
            int c2 = swipe[4];

            int rr = r2 - r1 + 1;
            int cc = c2 - c1 + 1;

            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {

                    int nr = (i + dr[d - 1]);
                    int nc = (j + dc[d - 1]);

                    if (nr > r2) {
                        nr %= rr;
                        graph[nr][nc] = temp[i][j];
                        ans += graph[nr][nc];
                    } else if (nr < r1) {
                        nr += rr;
                        graph[nr][nc] = temp[i][j];
                        ans += graph[nr][nc];
                    } else if (nc > c2) {
                        nc %= cc;
                        graph[nr][nc] = temp[i][j];
                        ans += graph[nr][nc];
                    } else if (nc < c1) {
                        nc += cc;
                        graph[nr][nc] = temp[i][j];
                        ans += graph[nr][nc];
                    } else {
                        graph[nr][nc] = temp[i][j];
                    }

                }
            }
            answer[cnt] = ans;
            cnt++;

            //temp 복사사
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    temp[i][j] = graph[i][j];
                    System.out.print(temp[i][j] + " ");
                }
                System.out.println();
            }

        }
        return answer;
    }


        public static void main(String[] args) {
            KP2 k = new KP2();
            int[] aa = k.solution(4,3,new int[][]{{1,1,2,4,3},{3,2,1,2,3},{4,1,1,4,3},{2,2,1,3,3}});
            for(int i: aa){
                System.out.print(i+" ");
            }
        }



}
