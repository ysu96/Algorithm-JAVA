package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751_CountingSort {
    public static boolean[] arr = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            arr[num+1000000] = true;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]){
                sb.append(i-1000000).append('\n');
            }

        }
        System.out.println(sb);
    }
}
