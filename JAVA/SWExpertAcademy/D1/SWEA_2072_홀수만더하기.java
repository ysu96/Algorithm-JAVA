package JAVA.SWExpertAcademy.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2072_홀수만더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];
        StringTokenizer st;
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i=0; i<10; i++){
                int n = Integer.parseInt(st.nextToken());
                if(n % 2 != 0) sum += n;
            }
            answer[t] = sum;
        }
        for(int t = 0; t<T; t++){
            System.out.println("#" + (t+1) + " " + answer[t]);
        }
    }
}
