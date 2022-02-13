package JAVA.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_13547_팔씨름 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[] input = br.readLine().toCharArray();
            int len = input.length;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (input[i] == 'o') cnt++;
            }
            boolean answer = false;
            if (8 - cnt <= 15 - len) {
                answer = true;
            }
            if (answer) System.out.println("#" + test_case + " YES");
            else System.out.println("#" + test_case + " NO");
        }
    }
}
