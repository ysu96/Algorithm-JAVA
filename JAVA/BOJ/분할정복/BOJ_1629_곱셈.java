package JAVA.BOJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//거듭제곱 알고리즘, 분할정복
public class BOJ_1629_곱셈 {
    public static int A,B,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long answer = pow(A, B, C);
        System.out.println(answer%C);
    }

    public static long pow(int a, int b, int c){
        if(b == 0) return 1;
        else if(b==1) return a;
        else if(b%2 == 0){
            long n = pow(a, b/2, c) % c;
            return (n*n)%c;
        }else{
            long n = pow(a, b/2, c) % c;
            return (((n*n)%c) * a)%c;
        }
    }
}
