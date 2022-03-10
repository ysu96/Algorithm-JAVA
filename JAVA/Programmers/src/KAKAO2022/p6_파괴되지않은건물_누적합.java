package JAVA.Programmers.src.KAKAO2022;

// 누적합 알고리즘 사용하기?
//https://kimjingo.tistory.com/155
public class p6_파괴되지않은건물_누적합 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        int[][] tmp = new int[n + 1][m + 1]; //누적합 저장용
        for (int[] s : skill) {
            int degree = (s[0] == 1 ? -1 : 1) * s[5];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];

            tmp[r1][c1] += degree;
            tmp[r2 + 1][c2 + 1] += degree;
            tmp[r1][c2 + 1] -= degree;
            tmp[r2 + 1][c1] -= degree;
        }

        //가로방향 누적합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j+1] += tmp[i][j];
            }
        }

        //세로방향 누적합
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                tmp[i+1][j] += tmp[i][j];
            }
        }

        // 원 배열, 누적합 배열 합치기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += tmp[i][j];
                if(board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
