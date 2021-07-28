package ICT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ICT4 {
    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        int n = arrival.size();
        int ans = 0;
        int[][] arr = new int[n][2];
        for(int i=0; i<n;i++){
            arr[i][0] = arrival.get(i);
            arr[i][1] = duration.get(i)+arrival.get(i); //종료시간
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
        for(int i=0;i<n;i++){
            //다음 시작시간이 최근 종료시간보다 뒤인경우
            if (end_time <= arr[i][0]) {
                end_time = arr[i][1];
                ans++;
            }
        }

        return ans;
    }
}
