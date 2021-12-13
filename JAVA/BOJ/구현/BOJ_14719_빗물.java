package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
    public static int H,W;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(br.readLine());

        int tmp = 0;
        for(int i=0; i<W; i++){
            int height = Integer.parseInt(st.nextToken());
            arr[i] = height;
        }

        int answer = 0;

        for(int i=1; i<W-1; i++){
            int now = arr[i];
            int left = now;
            int right = now;
            //왼쪽 최대 벽
            for(int j=i-1; j>=0; j--){
                if(arr[j] > left){
                    left = arr[j];
                }
            }
            //오른쪽 최대벽
            for(int j=i+1; j<W; j++){
                if (arr[j] > right) {
                    right = arr[j];
                }
            }

            if(left > now && right > now){
                answer += (Math.min(left,right) - arr[i]);
            }
        }
        System.out.println(answer);
    }
}
