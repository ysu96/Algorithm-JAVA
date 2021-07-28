package 네이버웹툰;

import java.util.Arrays;
import java.util.Collections;

public class first {
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Integer[] p = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] d = Arrays.stream(discounts).boxed().toArray(Integer[]::new);
        Arrays.sort(p, Collections.reverseOrder());
        Arrays.sort(d,Collections.reverseOrder());

        int pl = prices.length;
        int dl = discounts.length;
        if (pl <= dl) {
            for (int i = 0; i < pl; i++) {
                answer += p[i] * (100 - d[i]) / 100;
            }
        }
        else{
            for (int i = 0; i < dl; i++) {
                answer += p[i]*(100 - d[i])/100;
            }
            for (int i=dl; i<pl; i++){
                answer += p[i];
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        first a = new first();
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20};
        System.out.println(a.solution(prices,discounts));
    }
}
