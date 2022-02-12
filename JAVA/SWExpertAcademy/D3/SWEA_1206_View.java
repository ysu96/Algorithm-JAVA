package JAVA.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t<=10; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=2; i<N-2; i++){
                if(arr[i-1] > arr[i] || arr[i+1] > arr[i]) continue;
                if(arr[i-2] > arr[i] || arr[i+2] > arr[i]) continue;
                int left = Math.max(arr[i - 2], arr[i - 1]);
                int right = Math.max(arr[i + 2], arr[i + 1]);
                int max = Math.max(left, right);
                cnt += (arr[i] - max);
            }
            System.out.println("#"+ t + " " + cnt);
        }
    }
}
