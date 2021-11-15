package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시간 같으면 시작 앞인거 앞으로오게
                if(o1[1] == o2[1])
                    return o1[0]-o2[0];
                //종료 빠른거부터 정렬
                return o1[1]-o2[1];
            }
        });
        int end_time = 0; //가장 최근 종료시간
        int answer = 0;
        for(int i=0;i<N;i++){
            //다음 시작시간이 최근 종료시간보다 뒤인경우
            if (end_time <= arr[i][0]) {
                end_time = arr[i][1];
                answer++;
            }
        }
        System.out.println(answer);

    }
}
