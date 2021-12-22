package ESTSoft;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class first {
    public static HashMap<Character, Integer> map;

    public int solution(String[] scores) {
        int answer = 0;

        for (String s : scores) {
            map = new LinkedHashMap<>();
            for(int i=0; i<s.length(); i++){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                }else{
                    map.put(s.charAt(i), 1);
                }
            }

            if(map.containsKey('F') && map.get('F') >= 2) continue;
            if(map.containsKey('A') && map.get('A') >= 2){
                answer++;
                continue;
            }
            int maxScore = 0;
            int minScore = 6;
            int sum = 0;
            for(Character c : map.keySet()){
                if(c == 'A'){
                    maxScore = Math.max(maxScore, 5);
                    minScore = Math.min(minScore, 5);
                    sum+=(5*map.get(c));
                }
                else if(c == 'B'){
                    maxScore = Math.max(maxScore, 4);
                    minScore = Math.min(minScore, 4);
                    sum+=(4*map.get(c));
                }
                else if(c == 'C'){
                    maxScore = Math.max(maxScore, 3);
                    minScore = Math.min(minScore, 3);
                    sum+=(3*map.get(c));
                }
                else if(c == 'D'){
                    maxScore = Math.max(maxScore, 2);
                    minScore = Math.min(minScore, 2);
                    sum+=(2*map.get(c));
                }
                else if(c == 'E'){
                    maxScore = Math.max(maxScore, 1);
                    minScore = Math.min(minScore, 1);
                    sum+=(1*map.get(c));
                }
                else{
                    maxScore = Math.max(maxScore, 0);
                    minScore = Math.min(minScore, 0);
                }
            }
            if((sum-maxScore-minScore)/(s.length()-2) >= 3){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        first f = new first();
        f.solution(new String[]{"BBB"});
    }
}
