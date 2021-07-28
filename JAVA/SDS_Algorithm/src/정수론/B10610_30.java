package 정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10610_30 {
    private static long sum;
    private static String N;
    private static long[] count = new long[128];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();

        for(int i=0; i<N.length(); i++){
            sum+= N.charAt(i) - '0';
            count[N.charAt(i)]++;
        }

        if(sum % 3 != 0 || count['0'] == 0){
            System.out.println(-1);

        }
        else{
            for(int i='9'; i>= '0'; i--){
                for(int j =0; j<count[i]; j++){
                    System.out.print((char)i);
                }
            }
        }


    }
}
