package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class House{
    int r;
    int c;
    House(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class BOJ_15686_치킨배달_backtracking {
    public static int n,m;
    public static int[][] arr;
    public static boolean[] open;
    public static List<House> chickens = new ArrayList<>();
    public static List<House> houses = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) houses.add(new House(i, j));
                if(arr[i][j] == 2) chickens.add(new House(i, j));
            }
        }

        open = new boolean[chickens.size()];
        dfs(0,0);
        System.out.println(answer);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == m) {
            int res = 0;

            for (int i = 0; i < houses.size(); i++) {
                int temp = Integer.MAX_VALUE;

                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chickens.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(houses.get(i).r - chickens.get(j).r)
                                + Math.abs(houses.get(i).c - chickens.get(j).c);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            answer = Math.min(answer, res);
            return;
        }

        // 백트래킹
        for (int i = start; i < chickens.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }

}
