package JAVA.BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//dp[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때,
//방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용.
public class BOJ_2098_외판원순회 {
    static int N, INF = 987654321;
    static int[][] dp, arr;
    static int fullBit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        fullBit = (1 << N) - 1; // N = 6 -> 111111
        dp = new int[N][fullBit];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], INF);
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1)); // 0번도시부터 ㄱ, check = 0001
    }

    static int tsp(int x, int check) {
        // 완료
        if (check == fullBit) {
            // 다 방문했는데 원위치로 돌아오는 길이 없으면
            if(arr[x][0] == 0) return INF;
            else return arr[x][0];
        }

        if(dp[x][check] != INF){
            return dp[x][check];
        }

        for(int i=0; i<N; i++){
            // i번 도시 방문
            int next = check | (1<<i);

            // 경로 없거나, 이미 i도시를 방문한 경우 (0011 & 0010) = 0010, (0011 & 1000) = 0000;
            if(arr[x][i] == 0 || (check & (1<<i)) != 0) continue;

            //( tsp(다음 도시, 다음도시 방문했다고 가정) + 여기서 다음 도시까지의 거리 )와 최소거리 비교
            dp[x][check] = Math.min(dp[x][check], tsp(i, next) + arr[x][i]);
        }
        return dp[x][check];
    }
}
