package JAVA.SWExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++){
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
            }

            int max = arr[N-1];
            long sum = 0;
            for(int i=N-1; i>=0; i--){
                if (arr[i] < max){
                    sum += (max - arr[i]);
                }else{
                    max = arr[i];
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
