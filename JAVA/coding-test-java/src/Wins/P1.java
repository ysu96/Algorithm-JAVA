package Wins;

import java.util.ArrayList;
import java.util.List;

public class P1 {
    public int[] solution(String logs){
        int[] answer = new int[24];
        List<String> list = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        for(int i=0; i<logs.length(); i++){
            if(logs.charAt(i) == '\n'){
                list.add(tmp.toString());
                tmp = new StringBuilder();
            }else{
                tmp.append(logs.charAt(i));
            }
        }
        list.add(tmp.toString());

        for (String log : list) {
            int time = (Integer.parseInt(log.substring(11, 13)) + 9) % 24;
            answer[time]++;
        }
        return answer;
    }
}
