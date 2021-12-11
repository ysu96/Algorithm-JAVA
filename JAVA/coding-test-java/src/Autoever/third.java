package Autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class third {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int lineCnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            String tmp = st.nextToken();
            if(lineCnt + tmp.length() <= K){
                sb.append(tmp).append(" ");
                lineCnt += tmp.length();
            }else{
                sb.append("\n").append(tmp).append(" ");
                lineCnt = tmp.length();
            }
        }
        System.out.println(sb);
    }
}
