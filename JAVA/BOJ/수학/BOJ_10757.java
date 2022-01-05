package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10757 {
    public static String A,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        int len = Math.max(A.length(), B.length());
        int[] AA = new int[len+1];
        int[] BB = new int[len+1];

        for(int i=0; i<A.length(); i++){
            AA[i+len-A.length()+1] = A.charAt(i)-'0';
        }
        for(int i=0; i<B.length(); i++){
            BB[i+len-B.length()+1] = B.charAt(i)-'0';
        }

        int[] result = new int[len + 1];
        int carry = 0;
        for(int i=len; i>=0; i--){
            int add = AA[i] + BB[i] + carry;
            if(add > 9){
                result[i] = add%10;
                carry = add/10;
            }else{
                result[i] = add;
                carry = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(result[0] != 0) sb.append(result[0]);
        for (int i=1; i<result.length; i++) sb.append(result[i]);
        System.out.println(sb.toString());
    }
}
