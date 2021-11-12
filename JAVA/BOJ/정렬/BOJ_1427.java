package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//소트인사이드
public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        for(int i = s.length()-1; i>0; i--){
            int num = (int) (N / (Math.pow(10,i)));
            int left = (int) (N % (Math.pow(10,i)));
            list.add(num);
            N = left;
        }
        list.add(N);
        Collections.sort(list);
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for(int i =0; i< s.length(); i++){
            sb.append(list.get(i));
        }
        System.out.println(sb);

    }
}
