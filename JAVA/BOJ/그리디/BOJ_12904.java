package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        int len = T.length();
        while (S.length() != len) {
//            System.out.println(T);
            if (T.charAt(len - 1) == 'A') {
                T = T.substring(0, len-1);
            } else {
                T = T.substring(0, len - 1);
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<T.length(); i++){
                    sb.append(T.charAt(len-2-i));
                }
                T = sb.toString();
            }
            len--;
        }
        if(!T.equals(S)) System.out.println(0);
        else System.out.println(1);
    }
}
