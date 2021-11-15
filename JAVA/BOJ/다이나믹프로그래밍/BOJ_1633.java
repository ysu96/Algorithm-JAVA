package 다이나믹프로그래밍;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1633 {
    public static int[][][] dp = new int[1001][16][16];
    public static int[] white = new int[1001];
    public static int[] black = new int[1001];
    public static int idx = 0;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            white[idx] = scanner.nextInt();
            black[idx] = scanner.nextInt();
            idx++;
        }
        for(int i=0; i<idx; i++){
            for(int w=0; w<=15; w++){
                for(int b=0; b<=15; b++){
                    if (w+1 <= 15){
                        dp[i+1][w+1][b] = Math.max(dp[i+1][w+1][b], dp[i][w][b]+white[i]);
                    }

                    if (b+1 <= 15) {
                        dp[i + 1][w][b + 1] = Math.max(dp[i + 1][w][b + 1], dp[i][w][b] + black[i]);
                        dp[i + 1][w][b] = Math.max(dp[i + 1][w][b], dp[i][w][b]);
                    }
//                    System.out.println(1);
                }
            }
        }
        System.out.println(dp[idx][15][15]);


    }
}
