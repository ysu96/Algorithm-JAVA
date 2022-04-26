package JAVA.BOJ.구현;

public class 순열조합만들기 {
    static int[] arr;
    static boolean[] check;
    static int N, cnt;

    public static void main(String[] args) {
        N = 5;
        arr = new int[]{1, 2, 3, 4, 5};
        check = new boolean[5];
        per(0);
        System.out.println(cnt);
        System.out.println();

        cnt = 0;
        check = new boolean[5];
        combi(0,0);
        System.out.println(cnt);
    }

    //순열 5P3 = 5!/(5-3)! = 60
    public static void per(int n){
        if(n == 3){
            for(int i=0; i<N; i++){
                if(check[i]) System.out.print("" + arr[i] + " ");
            }
            System.out.println();
            cnt++;
            return;
        }

        for(int i=0; i<N; i++){
            if(!check[i]){
                check[i] = true;
                per(n+1);
                check[i] = false;
            }
        }
    }

    //조합 5C3 = 5!/(5-3)! * 3! = 10
    public static void combi(int idx, int n){
        if(n == 3){
            for(int i=0; i<N; i++){
                if(check[i]) System.out.print("" + arr[i] + " ");
            }
            System.out.println();
            cnt++;
            return;
        }

        for(int i=idx; i<N; i++){
            check[i] = true;
            combi(i + 1, n + 1);
            check[i] = false;
        }
    }
}
