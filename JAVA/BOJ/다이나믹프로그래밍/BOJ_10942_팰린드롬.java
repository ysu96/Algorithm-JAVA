package JAVA.BOJ.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//palindrome[j][i] : j번째부터 i번째까지의 문자열이 팰린드롬이면 true, 팰린드롬이 아니면 false
public class BOJ_10942_팰린드롬 {
    public static int N, M;
    public static int[] arr;
    public static boolean[][] palindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        palindrome = new boolean[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        setDp();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if(palindrome[S][E]) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }

    public static boolean checkPalindrome(int s, int e) {
        while (s <= e) {
            if (arr[s] != arr[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    private static void setDp() {
        //처음
        for (int i=1; i<=N; i++) {
            palindrome[i][i] = true;//i~i는 자기 자신 = 팰린드롬
            if (arr[i] == arr[i-1]) {
                //바로 뒤와 같으면 길이2짜리 팰린드롬
                palindrome[i-1][i] = true;
            }
        }

        for (int i=2; i<N; i++) {//i+1~n-1길이
            for (int j=1; j<=N-i; j++) {
                if (arr[j] == arr[j+i] && palindrome[j+1][j+i-1]) {
                    //처음==끝 && 처음+1~ == 끝-1~
                    palindrome[j][j+i] = true;
                }
            }
        }
    }//setDp
}
