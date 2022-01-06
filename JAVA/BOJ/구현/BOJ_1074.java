package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Z
public class BOJ_1074 {
    public static int N, r, c;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);
        divide(len, r, c);
        System.out.println(cnt);
//        for(int i=0; i<len; i++){
//            for(int j=0; j<len; j++){
//                System.out.print(arr[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
    }

    public static void divide(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        int n = size / 2;
        if (r < n && c < n) {
            divide(n, r, c);
        } else if (r < n && c >= n) {
            cnt += n * n;
            divide(n, r, c - n);
        } else if (r >= n && c < n) {
            cnt += n * n * 2;
            divide(n, r - n, c);
        } else {
            cnt += n * n * 3;
            divide(n, r - n, c - n);
        }
    }
}
