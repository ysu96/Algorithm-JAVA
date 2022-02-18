package JAVA.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//투 포인터 참고 풀이
//https://lotuslee.tistory.com/30?category=963570
//https://lotuslee.tistory.com/84
public class BOJ_1208_부분수열의합2 {
    public static int N, S;
    public static long[] arr;
    public static List<Long> left, right;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new long[N];
        left = new ArrayList<>();
        right = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        subsequence(0, N / 2, 0, left);
        subsequence(N / 2, N, 0, right);
        Collections.sort(left);
        Collections.sort(right);

        int l = 0;
        int r = right.size() - 1;
        long cnt = 0;
        while (l < left.size() && r >= 0) {
            long sum = left.get(l) + right.get(r);
            if (sum == S) {
                long tmp = left.get(l);
                long cntL = 0;
                while (l < left.size() && tmp == left.get(l)) {
                    cntL++;
                    l++;
                }

                tmp = right.get(r);
                long cntR = 0;
                while (r >= 0 && tmp == right.get(r)) {
                    cntR++;
                    r--;
                }
                cnt += (cntL * cntR);
            } else if (sum < S) {
                l++;
            } else {
                r--;
            }
        }
        if (S == 0) cnt -= 1;
        System.out.println(cnt);
    }

    public static void subsequence(int idx, int end, long sum, List<Long> list) {
        if (end == idx) {
            list.add(sum);
            return;
        }

        subsequence(idx + 1, end, sum + arr[idx], list); //더한거
        subsequence(idx + 1, end, sum, list); // 안더한거
    }
}
