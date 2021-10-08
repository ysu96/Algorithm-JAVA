package Level1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class 상호평가 {
    public String solution(int[][] scores) {
        String answer = "";
        int cnt = scores.length;

        for(int i=0; i<cnt; i++){
            ArrayList<Long> al = new ArrayList<>();
            for(int j=0; j<cnt; j++){
                al.add((long) scores[j][i]);
            }
            if ((al.get(i).equals(Collections.max(al))&&(Collections.frequency(al, al.get(i))==1)) ||
                    (al.get(i).equals(Collections.min(al)) && (Collections.frequency(al, al.get(i))==1))) {
                al.remove(i);
            }

            long total = 0;
            for (long a : al) {
                total += a;
            }

            long avg = total / al.size();
            if(avg>= 90) answer+='A';
            else if(avg>=80) answer+='B';
            else if(avg>=70) answer+='C';
            else if(avg>=50) answer+='D';
            else answer+='F';
        }
        return answer;
    }

    public static void main(String[] args) {
        상호평가 a = new 상호평가();
        System.out.println(a.solution(new int[][]{{90, 90, 90, 90}, {70, 70, 70, 70},{90, 90, 90, 90}, {70, 70, 70, 70}}));

    }
}
