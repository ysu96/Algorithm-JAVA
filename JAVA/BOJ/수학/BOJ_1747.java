package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소수 & 팰린드롬
public class BOJ_1747 {
    public static int N;

    public static boolean check(int n){
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n%i == 0) return true;
        }
        return false;
    }

    public static boolean palendrom(int n){
        String s = Integer.toString(n);
        int len =0;
        if(s.length()%2 == 0) len = s.length()/2;
        else len = s.length()/2-1;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=N; i<=Integer.MAX_VALUE; i++){
            if(i==1) continue;
            if (palendrom(i) && !check(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
