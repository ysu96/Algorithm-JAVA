package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
    public static int N,K;
    public static int[] arr;
    public static int answer, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        answer = (int) 1e9;
        cnt = 0;

        Arrays.fill(arr, (int) 1e9);
        // 수빈이가 할 수 있는거 x-1, x+1, 2*x
        // K 도착하면 min answer 구하기, 똑같으면 cnt++
        // 거리가 더 짧으면 탐색 들어가지마
        bfs(N);
        System.out.println(answer);
        System.out.println(cnt);
    }

    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        arr[s] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            if(x == K){
                if(answer > arr[x]){
                    answer = arr[x];
                    cnt = 1;
                }else if(answer == arr[x]){
                    cnt++;
                }
                continue;
            }

            // x-1
            if(x-1 >= 0 && arr[x-1] >= arr[x]+1){
                arr[x-1] = arr[x]+1;
                q.add(x - 1);
            }
            // x+1
            if (x + 1 <= 100000 && arr[x + 1] >= arr[x] + 1) {
                arr[x+1] = arr[x]+1;
                q.add(x + 1);
            }
            // 2*x
            if (x*2 <= 100000 && arr[x*2] >= arr[x] + 1) {
                arr[x*2] = arr[x]+1;
                q.add(x*2);
            }
        }
    }
}
