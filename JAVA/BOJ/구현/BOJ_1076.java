package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1076 {
    public static String[] arr = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c1 = br.readLine();
        String c2 = br.readLine();
        String c3 = br.readLine();
        int i1 = Arrays.asList(arr).indexOf(c1);
        int i2 = Arrays.asList(arr).indexOf(c2);
        int i3 = Arrays.asList(arr).indexOf(c3);

        StringBuilder answer = new StringBuilder();
        if (i1 == 0 && i2 == 0) answer.append(0);
        else if (i1 == 0) {
            answer.append(i2);
            answer.append("0".repeat(i3));
        } else {
            answer.append(i1).append(i2);
            answer.append("0".repeat(i3));
        }
        System.out.println(answer);
    }
}
