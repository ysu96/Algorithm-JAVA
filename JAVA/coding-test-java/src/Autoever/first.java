package Autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class first {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 0;
        if(B > A*20){
            answer = A*N;
        }
        else{
            answer += (int)(N/20) * B;
            if(N%20 * A > B) answer += B;
            else answer+= (N%20) * A;
        }
        System.out.println(answer);
    }
}
