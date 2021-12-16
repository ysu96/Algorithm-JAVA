package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    public static int R,C;
    public static char[][] arr;
    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,1,-1};
    public static int answer;
    public static Set<Character> set = new HashSet<>();

    public static void dfs(int r, int c, int count){
        if(set.contains(arr[r][c])){
            answer = Math.max(answer, count);
            return;
        }
        set.add(arr[r][c]);
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
            dfs(nr,nc, count+1);
        }
        set.remove(arr[r][c]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for(int i=0; i<R; i++){
            String tmp = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
        dfs(0,0,0);
        System.out.println(answer);

    }
}
