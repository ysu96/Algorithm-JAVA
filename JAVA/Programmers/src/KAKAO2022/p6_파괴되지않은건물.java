package JAVA.Programmers.src.KAKAO2022;

// 정확성은 10분컷
// 문제는 효율성!!!
// 25분까지 고민 - 포기함


public class p6_파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        for (int[] s : skill) {
            int degree = (s[0] == 1 ? -1 : 1) * s[5];
            for(int i=s[1]; i<=s[3]; i++){
                for(int j=s[2]; j<=s[4]; j++){
                    board[i][j] += degree;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
