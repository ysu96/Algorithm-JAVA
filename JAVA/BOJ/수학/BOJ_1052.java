package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이진수로 변환 후 1의 개수가 물병의 개수임
//숫자를 1씩 더해가며 이진수 변환, 1의 개수 찾기
public class BOJ_1052 {
    public static int N, K, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int tmp = N;
        while(true){
            int cnt = 0;
            String bin = Integer.toBinaryString(tmp);
            for(int i=0; i< bin.length(); i++){
                if(bin.charAt(i) == '1') cnt++;
            }
            if(cnt<= K){
                answer = tmp-N;
                break;
            }
            tmp++;
        }
        System.out.println(answer);
    }
}
