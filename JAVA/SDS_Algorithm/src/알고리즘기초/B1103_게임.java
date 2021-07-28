package 알고리즘기초;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//************************ 게임 ***************************

public class B1103_게임 {
    private static int N,M,ans,limit;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static char[][] board = new char[50][51];
    private static int[][] max_count = new int[50][50]; //시작부터 가장많이 점프한 횟수

    public static void dfs(int y, int x, int cnt){
        if(ans < cnt) {
            ans = cnt;
        }
        if(ans > limit) return;
        //예외처리
        if(y<0 || N<=y || x<0 || M<= x || board[y][x] == (char)-1) return;
        if(cnt <= max_count[y][x]) return;

        max_count[y][x] = cnt;

        int mul = board[y][x];

        for(int i=0; i<4; i++){
            dfs(y+dy[i]*mul, x+dx[i]*mul, cnt+1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        limit = N*M;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 처음 시작 점프 횟수가 0일 예정이라서 0보다 작은 -1로 초기화를 했는데,
                // 다른 방식으로도 구현이 가능합니다
                max_count[i][j] = -1;
            }
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();

            for(int j=0;j<M; j++){
                if(board[i][j] == 'H') board[i][j] = (char)-1;
                else board[i][j] -= '0';
//                System.out.println((int)board[i][j]);
            }
        }

        dfs(0,0,0);
        if(ans>limit) ans = -1;
        System.out.println(ans);

    }
}
