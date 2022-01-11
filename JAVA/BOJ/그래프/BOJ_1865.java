package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge_1865 {
    int a;
    int b;
    int w;

    Edge_1865(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}

public class BOJ_1865 {
    public static int TC, N, M, W, S, E, T;
    public static List<Edge_1865> edges;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            distance = new int[N + 1];
            edges = new ArrayList<>();

            // 돋로 정보
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                edges.add(new Edge_1865(S, E, T));
                edges.add(new Edge_1865(E, S, T));
            }

            // 웜홀 정보
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                edges.add(new Edge_1865(S, E, T * -1));
            }

            String answer = "NO";
            // 각 시작 지점부터 벨만 포드
            for (int i = 1; i <= N; i++) {
                if(bellmanford(i)){
                    answer = "YES";
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean bellmanford(int start) {
        Arrays.fill(distance, (int) 1e9);
        distance[start] = 0;
        boolean update = false;

        for(int i=0; i<N-1; i++){
            update = false;
            for (int j = 0; j < edges.size(); j++) {
                Edge_1865 e = edges.get(j);


                if(distance[e.a] == (int)1e9){
                    continue;
                }

                if(distance[e.a] + e.w < distance[e.b]){
                    distance[e.b] = distance[e.a] + e.w;
                    update = true;
                }
            }
            if(!update) break;
        }

        //마지막까지 업데이트가 계속 일어났으면 한번 더 갱신해서 업데이트 또 되면 음수 사이클
        if(update){
            update = false;
            for (int j = 0; j < edges.size(); j++) {
                Edge_1865 e = edges.get(j);
                if(distance[e.a] == (int)1e9){
                    continue;
                }
                if(distance[e.a] + e.w < distance[e.b]){
                    distance[e.b] = distance[e.a] + e.w;
                    update = true;
                    return true;
                }
            }
        }
        return false;
    }
}
