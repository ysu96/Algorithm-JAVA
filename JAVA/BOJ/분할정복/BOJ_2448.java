package JAVA.BOJ.분할정복;

import java.io.IOException;
import java.util.Scanner;

// 별찍기 11
public class BOJ_2448 {
    public static int N;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        String[] star = new String[N];
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        for (int k = 1; 3*Math.pow(2,k) <= N; k++) {
            startree(k, star);
        }
        for (String s : star) {
            System.out.println(s);
        }
    }

    public static String[] startree(int k, String[] star) {
        int bot = 3 * (int) Math.pow(2, k);
        int mid = bot / 2;

        for(int i=mid; i<bot; i++){
            star[i] = star[i - mid] + " " + star[i - mid];
        }

        String space = " ".repeat(mid);
        for(int i=0; i<mid; i++){
            star[i] = space + star[i] + space;
        }

        return star;
    }
}
