package JAVA.BOJ.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑 {
    public static int N,K;
    public static int[] C;
    public static int[][] MV;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        MV = new int[N][2];
        visited = new boolean[N];
        C = new int[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            MV[i][0] = Integer.parseInt(st.nextToken());
            MV[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(MV, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        // 무게 오름차순 정렬, 무게 같으면 비용 큰거부터
        for(int i=0; i<K; i++){
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        for(int i=0; i<K; i++){
            while (idx < N && MV[idx][0] <= C[i]) {
                pq.add(MV[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
