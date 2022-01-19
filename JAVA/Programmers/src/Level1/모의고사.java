package Level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) p1++;
            if(answers[i] == two[i%8]) p2++;
            if(answers[i] == three[i%10]) p3++;
        }
        int max = Math.max(p1, Math.max(p2, p3));
        if(p1 == max) answer.add(1);
        if(p2 == max) answer.add(2);
        if(p3 == max) answer.add(3);
        int[] a = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            a[i] = answer.get(i);
        }
        return a;
    }
}
