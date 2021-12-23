package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1009 {
    public static int T,a,b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tt =0 ; tt<T; tt++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int tmp = 1;
            for(int i=0; i<b; i++){
                tmp*=a;
                tmp = tmp%10;
            }
            if(tmp == 0) tmp = 10;
            System.out.println(tmp);
        }
    }
}
