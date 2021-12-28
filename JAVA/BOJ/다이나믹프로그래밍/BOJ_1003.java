package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치
public class BOJ_1003 {
    public static int T,N;
    public static int[] num0, num1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            num0 = new int[41];
            num1 = new int[41];
            num0[0] = 1; num0[1] = 0;
            num1[0] = 0; num1[1] = 1;
            for(int i=2; i<=N; i++){
                num0[i] = num0[i-1] + num0[i-2];
                num1[i] = num1[i-1] + num1[i-2];
            }

            System.out.println(String.valueOf(num0[N]) + " " + num1[N]);
        }
    }

}
