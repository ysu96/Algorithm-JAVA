package Level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int cnt = 0;
        for (int num : lottos) {
            if(num == 0){
                zero++;
                continue;
            }

            for (int wn : win_nums) {
                if(num == wn){
                    cnt++;
                    continue;
                }
            }
        }
        //최저는 cnt개
        //최대는 cnt+zero
        return new int[]{7-Math.max(cnt+zero, 1), 7-Math.max(cnt,1)};
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        로또의최고순위와최저순위 a = new 로또의최고순위와최저순위();
        System.out.println(a.solution(lottos, win_nums)[0]);
    }
}
