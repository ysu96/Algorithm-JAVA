package 자료구조;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5639_이진검색트리 {
    private static int[] a = new int[10000];
    private static int sz;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/test.in"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            a[sz] = Integer.parseInt(str.trim());
            sz++;
        }
        recur(0, sz-1);

    }
    public static void recur(int s, int e){
        // a[s] == 전위 순회에서는 root
        if(s==e){
            System.out.println(a[s]);
            return;
        }
        else if(s>e){
            return;
        }
        else{
            int where = s+1;
            while(where <= e){
                if(a[where] > a[s]) break;
                else where++;
            }
            //left
            recur(s+1, where-1);
            //right
            recur(where, e);

            System.out.println(a[s]);

        }
    }

}
