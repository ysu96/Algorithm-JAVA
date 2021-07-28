package 네이버웹툰;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class second {
    public String[] solution(String s) {
        List<String> answer = new ArrayList<>();
        String laststr = Character.toString(s.charAt(s.length()-1));
        int start= 0;
        int last = s.length();
        for(int i=0; i<s.length()/2; i++){
            if (Character.toString(s.charAt(i)).equals(laststr)){
                String tmp = s.substring(start,i+1);
                String tmp2 = s.substring(last-tmp.length(), last);
                if(tmp.equals(tmp2)){
                    answer.add(tmp);
                    start += tmp.length();
                    last -= tmp.length();
                    laststr = Character.toString(s.charAt(last-1));
                }
            }
        }
        for(int i=answer.size()-1; i>=0; i--){
            answer.add(answer.get(i));
        }

        if(last != start){
            answer.add(answer.size()/2,s.substring(start,last));
        }

        for (String ss : answer) {
            System.out.println(ss);
        }

        String[] a = answer.toArray(new String[answer.size()]);
        return a;
    }

    public static void main(String[] args) {
        second a = new second();
        a.solution("abcab");
    }
}
