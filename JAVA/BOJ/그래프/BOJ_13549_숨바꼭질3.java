package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Subin{
    int cur;
    int time;

    Subin(int cur, int time) {
        this.cur = cur;
        this.time = time;
    }
}
public class BOJ_13549_숨바꼭질3 {
    public static int n,k;
    public static boolean[] visited = new boolean[100001];
    public static int[] dp = new int[100001];
    public static void bfs(int now) {
        // n+1, n-1, 2*n
        Queue<Subin> q = new LinkedList<>();
        q.add(new Subin(now, 0));
        visited[now] = true;
        dp[now] = 0;
        while (!q.isEmpty()) {
            Subin s = q.poll();
            if (s.cur == k) {
                System.out.println(dp[s.cur]);
                return;
            }

            if (s.cur+1 <= 100000 && dp[s.cur+1] > dp[s.cur]+1) {
                q.add(new Subin(s.cur+1, s.time+1));
                dp[s.cur+1] = dp[s.cur]+1;
            }

            if (s.cur-1 >= 0 && dp[s.cur-1] > dp[s.cur]+1) {
                q.add(new Subin(s.cur-1, s.time+1));
                dp[s.cur-1] = dp[s.cur]+1;
            }
            if (s.cur * 2 <= 100000 && dp[s.cur*2] > dp[s.cur]) {
                q.add(new Subin(s.cur*2, s.time));
                dp[s.cur * 2] = dp[s.cur];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, Integer.MAX_VALUE);
        bfs(n);
    }
}
