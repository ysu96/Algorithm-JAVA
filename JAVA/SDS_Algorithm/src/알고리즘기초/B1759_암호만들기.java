package 알고리즘기초;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//************************ 암호만들기 ***************************

public class B1759_암호만들기 {
    private static int l;
    private static int c;
    private static char[] arr;
    private static char[] ans;

    public static boolean check(){
        int a = 0;
        int b =0;
        for(int i=0; i<l; i++){
            if(ans[i] == 'a' || ans[i]=='e' || ans[i]=='i' || ans[i]=='o' || ans[i]=='u'){
                a++;
            }
            else{
                b++;
            }
        }
        if(a>=1 && b>=2) return true;
        else return false;
    }

    public static void recur(int where, int from){
        //final condition
        if(where == l){
            if (check()) {
                String str = new String(ans);
                System.out.println(str);
            }
            return;
        }

        for(int i=from; i<c; i++){
            ans[where] = arr[i];
            //***빠르게 할려면 이 시점에 미리 자음 모음 개수 세어놓어야함!!!*** 함수 매개변수로 넣어주기
            //중간에 잘하면 가지치기도 가능
            recur(where+1, i+1);
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        ans = new char[l];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        recur(0,0);


    }
}
