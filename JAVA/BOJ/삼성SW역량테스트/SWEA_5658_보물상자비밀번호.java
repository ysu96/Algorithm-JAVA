package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int len = N / 4; //이만큼만 회전하면 댐, 숫자는 최대 N개까지 나올 수 있음

            HashSet<Integer> candidate = new HashSet<>();
            PriorityQueue<Integer> answer = new PriorityQueue<>(Comparator.reverseOrder());
            String str = br.readLine();

            for (int i = 0; i < len; i++) {
                // 숫자 4개 세기
                for (int j = 0; j < 4; j++) {
                    String num = str.substring(j * len, j * len + len);
                    int dec = hex2dec(num);
                    if (!candidate.contains(dec)) {
                        answer.add(hex2dec(num));
                        candidate.add(hex2dec(num));
                    }
                }

                // 회전
                str = str.charAt(N - 1) + str.substring(0, N - 1);
            }

            for (int i = 0; i < K - 1; i++) {
                answer.poll();
            }

            System.out.println("#" + tc + " " + answer.poll());
        }
    }

    public static int hex2dec(String hex) {
        int dec = 0;
        int power = hex.length() - 1;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            if ('A' <= c && c <= 'F') {
                dec += Math.pow(16, power) * (int) (c - 'A' + 10);
            } else {
                dec += Math.pow(16, power) * (int) (c - '0');
            }
            power--;
        }
        return dec;
    }
}
