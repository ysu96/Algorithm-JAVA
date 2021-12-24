package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static int N,C;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int low = 1;
        int high = arr[N-1] - arr[0];
        int dist;
        int answer = 0;

        while(low<=high){
            int mid = (low+high)/2;
            int start = arr[0];
            int cnt = 1;

            for(int i=1; i<N; i++){
                dist = arr[i]-start;
                if(dist >= mid){
                    cnt++;
                    start = arr[i];
                }
            }
            if (cnt >= C) {
                answer = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        System.out.println(answer);
    }
}
