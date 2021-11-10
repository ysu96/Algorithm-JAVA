package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 수 정렬하기 2
public class BOJ_2751 {
    public static List<Integer> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            l.add(num);
        }
        Collections.sort(l);
        for(int i=0;i<n;i++){
            sb.append(l.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}
