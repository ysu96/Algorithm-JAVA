package JAVA.BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// A -> B
public class BOJ_16953_bfs {
    public static int A,B, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        answer = bfs(B);
        System.out.println(answer);
    }
    //1000000000

    //거꾸로 B에서부터 A로 바꿔보기
    //1. B가 2로 나누어 떨어지지 않거나, 맨 끝자리가 1이 아니라면 A로 만드는 것이 불가능하다.
    //2. B가 2로 나누어 떨어진다면, B를 2로 나눈다.
    //3. B의 맨 끝자리가 1이라면, 1을 없앤다.
    static int bfs(int s){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 1});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int pos = poll[0];
            int cnt = poll[1];
            if(pos == A) return cnt;
            if(pos < A) return -1;

            String posStr = Integer.toString(pos);

            if(pos%2 != 0 && posStr.charAt(posStr.length()-1) != '1'){
                continue;
            }

            if(pos % 2 == 0){
                q.add(new int[]{pos / 2, cnt + 1});
            }
            if(posStr.charAt(posStr.length()-1) == '1'){
                q.add(new int[]{Integer.parseInt(posStr.substring(0, posStr.length()-1)), cnt+1});
            }
        }
        return -1;
    }
}
