package SKFamily;

import java.util.Arrays;
import java.util.Comparator;

public class SK_p1 {
    public int solution(int money, int[] costs) {
        int answer = 0;
        int[] weight = {1, 5, 10, 50, 100, 500};
        double[][] value = new double[costs.length][2];
        for(int i=0; i<costs.length; i++){
            value[i][0] = (double) costs[i] / weight[i];
            value[i][1] = weight[i];
        }

        Arrays.sort(value, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                }else if (o1[0] == o2[0]){
                    if(o1[1] < o2[1]) return 1;
                    else return -1;
                }else{
                    return -1;
                }
            }
        });


        for(int i=0; i<costs.length; i++){
            System.out.println(value[i][0]);
            System.out.println(value[i][1]);
        }

        for(int i=0; i<costs.length; i++){
            if(value[i][1] <= money){
                int cnt = money / (int)value[i][1];
                answer += (cnt * (int)(value[i][0] * value[i][1]));
                money -= cnt * value[i][1];
                System.out.println("화폐 : " + value[i][1]);
                System.out.println("개수 : " + cnt);

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SK_p1 p1 = new SK_p1();
        System.out.println(p1.solution(1999, new int[]{2, 11, 20, 100, 200, 600}));
    }
}
