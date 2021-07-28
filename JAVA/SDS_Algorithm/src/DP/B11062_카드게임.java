package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11062_카드게임 {
    private static int[] a;
    private static int[][] m;
    private static int t;
    private static int n;

    public static int dp(int l, int r){

        if(m[l][r] != 0) return m[l][r];
        if(l==r){
            m[l][r] = a[l];
            return m[l][r];
        }
        if(r-l == 1){
            m[l][r] = Math.max(a[l], a[r]);
            return m[l][r];
        }
        if(r<l) return 0;
        m[l][r] = a[l] + Math.min(dp(l+2,r), dp(l+1, r-1));
        m[l][r] = Math.max(m[l][r], a[r]+Math.min(dp(l,r-2), dp(l+1, r-1)));

        return m[l][r];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for(int tt=0; tt<t; tt++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            a = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(st.nextToken());

            }
            m = new int[n][n];
            int ans = dp(0, n-1);
            System.out.println(ans);
        }
    }
}
