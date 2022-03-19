package SKFamily2;

public class SKP3 {
    public int solution(int[][] a, int[][] b, int m) {
        int answer = -1;
        dfs(m);
        return answer;
    }

    public void dfs(int m) {
        if(m == 0) {
            // m이 0이면 1번 작업 ㄱ?

            return;
        }

        // 가능한 경우의 수 다 바꾸기
//        for(int i=0; i<len; i++){
//            for(int j=i+1; j<lne; j++){
//                // i, j 바꾸기
//                // m--, 재귀 호출
//            }
//        }
    }
}
