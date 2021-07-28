package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class B2042_구간합 {
    private static int N,M,K;
    private static long[] arr;
    private static long ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1){ //b번째 수를 c로 바꿔
                arr[b-1] = c;
            }
            else{ //b번째 수부터 c번째 수까지 합구해해
                for(int j=b-1; j<c; j++){
                    ans+=arr[j];
                }
                System.out.println(ans);
                ans = 0;
            }
        }
    }
}
