package JAVA.BOJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1007_벡터 {
    public static int T, N;
    public static double answer;
    public static boolean[] check;
    public static int[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            answer = Double.MAX_VALUE;
            check = new boolean[N];
            points = new int[N][2];

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i][0] = x;
                points[i][1] = y;
            }

            // 더하는 포인트  n/2개 찾기
            combination(0, N / 2);
            System.out.println(answer);
        }
    }

    public static void combination(int idx, int cnt) {
        if(cnt == 0){
            answer = Math.min(answer, getVector());
        }else{
            for(int i=idx; i<N; i++){
                check[i] = true;
                combination(i + 1, cnt - 1);
                check[i] = false;
            }
        }
    }

    private static double getVector()
    {
        int x = 0;
        int y = 0;

        for (int i = 0; i < points.length; i++)
        {
            // 양수로 선택된 점일 경우
            if (check[i])
            {
                x += points[i][0];
                y += points[i][1];
            }

            // 음수로 선택된 점일 경우
            else
            {
                x -= points[i][0];
                y -= points[i][1];
            }
        }

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
