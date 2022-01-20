package 네이버ETECH;

public class etech2 {
    static long[] fibos;

    long fibo2(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return fibo2(n-1) + fibo2(n-2);
    }

    long fibo3(int n){
        long[] fff = new long[n+1];
        if(n == 0) return 0;
        else if(n == 1 || n == 2) return 1;
        fff[0] = 0;
        fff[1] = 1;
        fff[2] = 1;

        for(int i=3; i<=n; i++){
            fff[i] = fff[i-1] + fff[i-2];
        }
        return fff[n];
    }

    long fibo(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        if(fibos[n] != 0) return fibos[n];
        else{
            fibos[n] = fibo(n-1) + fibo(n-2);
            return fibos[n];
        }
    }

    public static void main(String[] args) {
        etech2 et = new etech2();
        fibos = new long[101];
        fibos[0] = 0;
        fibos[1] = 1;
        fibos[2] = 1;
        System.out.println(et.fibo(2));
        System.out.println(et.fibo(3));
        System.out.println(et.fibo(4));
        System.out.println(et.fibo(10));
        System.out.println(et.fibo(50));
        System.out.println(et.fibo3(5));
    }
}
