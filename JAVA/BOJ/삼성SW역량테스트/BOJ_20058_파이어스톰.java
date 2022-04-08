package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20058_파이어스톰 {
    public static int N, Q, L;
    public static int[][] map;
    public static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        level = new int[Q];
        N = (int) Math.pow(2, N);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){
            level[i] = Integer.parseInt(st.nextToken());
        }

        for(int q=0; q<Q; q++){
            L = (int)Math.pow(2, level[q]);

            // L 간격으로 90도 시계방향 회전
            rotate();
            // 인접 확인, 얼음 줄이기기
        }
   }

   public static void rotate(){
        for(int i=0; i<N; i+=L){
            for(int j=0; j<N; j+=L){
                // i ~ i+L-1 , j ~ j+L-1 회전하기
                
            }
        }
   }

   public static int[][] deepCopy(int[][] map){
       int[][] tmp = new int[map.length][map.length];
       for(int i=0; i<map.length; i++){
           for(int j=0; j<map.length; j++){
               tmp[i][j] = map[i][j];
           }
       }
       return tmp;
   }
}
