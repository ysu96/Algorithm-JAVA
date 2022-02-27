package JAVA.BOJ.삼성SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
    public static int N, answer;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        StringTokenizer st;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        divide(team1, team2, 0);
        System.out.println(answer);
    }

    public static void divide(List<Integer> team1, List<Integer> team2, int idx) {
        if (idx == N) {
            // 수치 구하기
            int n = calculate(team1, team2);
            answer = Math.min(answer, n);
            return;
        }

        if (team1.size() < N / 2) {
            team1.add(idx);
            divide(team1, team2, idx + 1);
            team1.remove(Integer.valueOf(idx));
        }

        if (team2.size() < N / 2) {
            team2.add(idx);
            divide(team1, team2, idx + 1);
            team2.remove(Integer.valueOf(idx));
        }
    }

    public static int calculate(List<Integer> team1, List<Integer> team2) {
        int t1 = 0, t2 = 0;
        for(int i : team1){
            for(int j : team1){
                t1 += (arr[i][j] + arr[j][i]);
            }
        }
        t1 /= 2;

        for(int i : team2){
            for(int j : team2){
                t2 += (arr[i][j] + arr[j][i]);
            }
        }
        t2 /= 2;
        return Math.abs(t1 - t2);
    }
}
