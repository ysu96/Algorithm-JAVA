package 네이버ETECH;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public String solution(String T) {
        // write your code in Java SE 8
        char[] chars = T.toCharArray();
        StringBuilder answer = new StringBuilder();
        Arrays.sort(chars); //듀얼 피봇 퀵 정렬  nlogn ~ n^2
        for(int i=chars.length-1; i>=0; i--){
            answer.append(chars[i]);
        }
        return answer.toString();
    }

    public static void main(String[] args){
        Task1 t1 = new Task1();
        t1.solution("LSLSLSLS");
    }

}
