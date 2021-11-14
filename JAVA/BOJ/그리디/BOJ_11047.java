package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if (K/num == 0){
                break;
            }
            list.add(num);
        }

        for(int i=list.size()-1; i>=0; i--){
            answer += K / list.get(i);
            K = K % list.get(i);
        }
        System.out.println(answer);
    }
}
