package 알고리즘기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        StringTokenizer st = new StringTokenizer(tc, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        if (k<5) { // a n t i c 는 꼭 알려줘야함
            System.out.println(answer);
            return;
        }
        for(int i =0; i<n; i++) {
            String str = br.readLine();
            String str2 = str.substring(4,str.length()-4);

        }

    }
}
