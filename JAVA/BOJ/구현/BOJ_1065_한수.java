package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//브루트포스
public class BOJ_1065_한수 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=1; i<=N; i++){
            String s = Integer.toString(i);
            int len = s.length();
            if(len<=2){
                answer++;
                continue;
            }
            boolean chcek = true;
            int first = s.charAt(0)-'0';
            int second = s.charAt(1)-'0';
            for(int j=2; j<len; j++){
                if ((s.charAt(j) - '0') - (s.charAt(j - 1) - '0') != second - first) {
                    chcek = false;
                }
            }
            if(chcek) answer++;

        }
        System.out.println(answer);
    }
}
