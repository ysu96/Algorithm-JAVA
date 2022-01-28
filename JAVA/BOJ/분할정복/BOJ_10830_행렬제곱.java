package JAVA.BOJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830_행렬제곱 {
    public static int N;
    public static long B;
    public static long[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new long[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j] = Long.parseLong(st.nextToken()) % 1000;
            }
        }

        long[][] answer = matrixPow(matrix, B);
        StringBuilder sb = new StringBuilder();
        for (long[] row : answer) {
            for(int i=0; i<N; i++){
                sb.append(row[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static long[][] matrixPow(long[][] mat, long n){
        if(n == 1){
            return mat;
        }

        long[][] half = matrixPow(mat, n / 2);
        long[][] ans = multiply(half, half);
        if(n % 2 == 1){
            ans = multiply(ans, matrix);
        }
        return ans;
    }

    //행렬 곱셈
    public static long[][] multiply(long[][] a, long[][] b){
        long[][] result = new long[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {

                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= 1000;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
                }
            }
        }
        return result;
    }

}
