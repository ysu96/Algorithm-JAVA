package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합_투포인터 {
    public static int N, S;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int head = 0;
        int tail = 0;
        int sum = 0;
        int cnt = Integer.MAX_VALUE;
        while(true){
            if(sum >= S){
                cnt = Math.min(cnt, tail - head);
                sum -= arr[head++];
            }
            else if(tail == N){
                break;
            }
            else{
                sum += arr[tail++];
            }
        }
        if(cnt == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(cnt);
    }
}
