package Autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        boolean check = true;
        if(N%2 == 1){
            check = false;
        }else{
            for(int i=0; i<N/2; i++){
                if(S.charAt(i) != S.charAt(i+N/2)){
                    check = false;
                    break;
                }
            }
        }
        if(check) System.out.println("Yes");
        else System.out.println("No");
    }
}
