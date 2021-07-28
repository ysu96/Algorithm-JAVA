package 시간복잡도;
import java.io.*;
import java.util.*;

public class B2003_수들의합2 {
    private static int N, M;
    private static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        // 완전탐색 비슷하게
        // 투포인터는??
        /*
        int s = 0, e = 0, sum = 0;
        while (s < N && e < N) {
            for ( ; e < N ; e++) {
                sum += A[e];
                if (sum == M) {
                    answer++;
                    e++;
                    break;
                }
                else if (sum > M) {
                    e++;
                    break;
                }
            }
            while (s < N && sum >= M) {
                sum -= A[s];
                s++;
                if (sum == M) {
                    answer++;
                }
            }
        }
        */
        int sum = 0;
        for (int s = 0, e = 0 ; e < N ; e++) {
            sum += A[e];
            while (sum > M) {
                sum -= A[s];
                s++;
            }
            if (sum == M) answer++;
        }
        System.out.println(answer);
    }
}


