package 프로그래머스.level3;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        Map<String, Integer> result = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for(String s:enroll){
            result.put(s, 0);
        }

        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }

        for(int i=0; i<seller.length; i++){
            result.put(seller[i], result.get(seller[i])+ (amount[i]*90));
            int temp = amount[i]*10;
            String p = parent.get(seller[i]);
            while(!p.equals("-")){

                result.put(p, result.get(p) + (amount[i]*9));
                p = parent.get(p);
            }

        }
        return answer;
    }

}
