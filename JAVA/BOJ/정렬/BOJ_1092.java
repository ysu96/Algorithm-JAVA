package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//while문 안에 이중포문 구현하니 시간초과가 남
// 특이한 for문 방식으로 해결
// 그리디, 정렬 문제
public class BOJ_1092 {
    public static int N,M;
    public static int[] crains, boxes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crains = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            crains[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        boxes = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crains);
        Arrays.sort(boxes);
        int time = 0;
        boolean[] visited = new boolean[M];
        int visit = 0;
        if(crains[N-1] < boxes[M-1]) System.out.println(-1);
        else{
            while (visit != M) {
                int idx = M-1;
                //특이한 for문 쓰는 방식
                for(int i= N-1; i>=0;){
                    if(idx < 0) break;
                    if (crains[i] >= boxes[idx] && !visited[idx]) {
                        visited[idx] = true;
                        visit++;
                        i--;
                    }
                    else idx--;
                }
                time++;
            }
            System.out.println(time);
        }
    }
}
