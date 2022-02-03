package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_12852_1로2만들기_2 {
    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=N; i++){
            if(i % 3 == 0) {
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1])) + 1;
                } else {
                    dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                }
            }else{
                if(i%2 == 0){
                    dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
                }else{
                    dp[i] = dp[i-1] + 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(N);
        while(N != 1){
            if(N % 3 == 0) {
                if (N % 2 == 0) {
                    if(dp[N/3] > dp[N/2]){
                        if(dp[N/2] > dp[N-1]){
                            N = N-1;
                            list.add(N);
                        }
                        else{
                            N = N/2;
                            list.add(N);
                        }
                    }else{
                        if(dp[N/3] > dp[N-1]){
                            N = N-1;
                            list.add(N);
                        }else{
                            N = N/3;
                            list.add(N);
                        }
                    }
                } else {
                    if (dp[N/3] > dp[N-1]){
                        N = N-1;
                        list.add(N);
                    }else{
                        N = N/3;
                        list.add(N);
                    }
                }
            }else{
                if(N%2 == 0){

                }else{

                }
            }
        }
        System.out.println(dp[N]);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
