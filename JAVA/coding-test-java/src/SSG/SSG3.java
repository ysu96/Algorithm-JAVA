package SSG;

import java.util.Arrays;
import java.util.Comparator;

public class SSG3 {
    // 가격, 내구도
    // 외출할 날짜

    // 1. 가성비 순으로 일단 정렬
    // 2. 첫 날과 다음 날까지의 차이 계산
    // 3650일

    // 내구도는 처음 날 포함하여 며칠 사용 가능한지


    //                                 1   2   3    4    5     6   7    8    9    10    11
    public static int[] months = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 302, 334};
    public int solution(int[][] masks, String[] dates){
        boolean[] days = new boolean[3651]; // 2021.01.01 ~ 2030.12.31
        for (String date : dates) {
            if (date.length() == 10) { // "2021/12/31" = 365, "2022/1/1" = 365+1 = 366, "2021/2/28" = 31+28 = 59, "2021/3/1" = 60
                int y = Integer.parseInt(date.substring(0,4));
                int m = Integer.parseInt(date.substring(5,7));
                int d = Integer.parseInt(date.substring(8,10));
                int idx = (y - 2021) * 365 + months[m] + d;
                days[idx] = true;
            }else{
                String[] split = date.split("~");
                String from = split[0];
                String to = split[1];
                int y1 = Integer.parseInt(from.substring(0,4));
                int m1 = Integer.parseInt(from.substring(5,7));
                int d1 = Integer.parseInt(from.substring(8,10));

                int y2 = Integer.parseInt(to.substring(0,4));
                int m2 = Integer.parseInt(to.substring(5,7));
                int d2 = Integer.parseInt(to.substring(8,10));
                int idx1 = (y1 - 2021) * 365 + months[m1] + d1;
                int idx2 = (y2 - 2021) * 365 + months[m2] + d2;
                for(int i = idx1; i <= idx2; i++){
                    days[i] = true;
                }
            }
        }

        // 마스크 가성비 정렬
        Arrays.sort(masks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return 1;
                }
                else return -1;
            }
        });

        int[] dp = new int[3651];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int len = masks.length;
        for(int i = 1; i<3651; i++){
            if(days[i]) {

                for(int j =0; j<len; j++){
                    int p = masks[j][0];
                    int d = masks[j][1];
                    if(i - d <= 0) dp[i] = Math.min(dp[i], p);
                    else dp[i] = Math.min(dp[i-d] + p, dp[i]);
                }

            }else{
                dp[i] = dp[i-1];
            }
        }

        return dp[3650];
    }

    public static void main(String[] args) {
        SSG3 ssg3 = new SSG3();
        int[][] a = new int[][]{{3200, 4}, {2300, 2}, {1100, 1}, {4200, 6}};
        int[][] a2 = new int[][]{{100000, 1},{5,10}};
        String[] b = new String[]{"2022/05/02", "2022/05/01", "2022/05/07", "2022/05/05", "2022/05/08", "2022/05/13~2022/05/15", "2022/05/14~2022/05/17", "2022/05/01~2022/05/02", "2022/05/16"};
        String[] b2 = new String[]{"2021/01/01"};
        System.out.println(ssg3.solution(a2, b2));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(365000000);
    }
}
