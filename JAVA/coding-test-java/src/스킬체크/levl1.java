package 스킬체크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class levl1 {

    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<= n ; i++){
            if(n%i == 0){
                answer += i;
                System.out.println(i);
            }
        }
        return answer;
    }

    class rate implements Comparable<rate>{
        int idx;
        double fail_rate;

        rate(int idx, double fail_rate){
            this.idx = idx;
            this.fail_rate = fail_rate;
        }

        @Override
        public int compareTo(rate o) {
            if(this.fail_rate == o.fail_rate){
                return this.idx - o.idx;
            }
            else{
                if(this.fail_rate > o.fail_rate) return -1;
                else return 1;
            }

        }
    }

    public int[] solution2(int N, int[] stages) {
        int[] answer = new int[N];
        int[] pass = new int[N];
        int[] fail = new int[N];
        Arrays.fill(pass, 0);
        Arrays.fill(fail, 0);

        for(int i=0; i< stages.length; i++){
            if(stages[i] == N+1){
                for(int j=0; j<N; j++){
                    pass[j]++;
                }
            }
            else{
                for(int j=0; j<stages[i]; j++){
                    pass[j]++;
                }
                fail[stages[i]-1]++;
            }
        }
        ArrayList<rate> ans = new ArrayList<rate>();


        for(int i=0;i<N;i++){
            if(pass[i] == 0){
                ans.add(new rate(i+1, 0));

            }
            else{
                ans.add(new rate(i+1, (double) fail[i]/pass[i]));

            }
        }
        Collections.sort(ans);

        for(int i=0; i<N;i++){
            answer[i] = ans.get(i).idx;
        }
        return answer;
    }

    public static void main(String[] args) {
        levl1 n = new levl1();
//        n.solution(12);
        int[] a = {2, 1, 2, 6, 2, 4, 3, 3};
        n.solution2(5,a);
    }
}


