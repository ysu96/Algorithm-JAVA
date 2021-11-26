package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1107_브루트포스 {
    public static int m;
    public static int n;
    public static boolean[] broken;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        String line = br.readLine();
        for(int i=0; i<m; i++) {
            broken[Integer.parseInt(line.split(" ")[i])] = true;
        }
        int min_cnt = Math.abs(n - 100);    // +,- 로만 누르는 경우
        for(int i=0; i<1000000; i++){
            int len = check(i);
            if(len>0){
                int press = Math.abs(n - i);  // +,- 버튼 누르는 횟수
                min_cnt = Math.min(min_cnt, len + press);   // 최소 이동 횟수 계산
            }
        }
        System.out.println(min_cnt);

    }
    static int check(int n) {
        if (n == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) {   // 고장난 버튼이 있는 경우
                return 0;
            }
            n /= 10;
            len += 1;   // 숫자버튼 누르는 횟수 증가
        }
        return len;
    }
}
